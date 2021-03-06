/*
 Copyright (c) 2016, Mihai-Emil Andronache
 All rights reserved.

 Redistribution and use in source and binary forms, with or without modification,
 are permitted provided that the following conditions are met:
 1. Redistributions of source code must retain the above copyright notice,
 this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright notice,
 this list of conditions and the following disclaimer in the documentation
 and/or other materials provided with the distribution.
 3. Neither the name of the copyright holder nor the names of its contributors
 may be used to endorse or promote products derived from this software
 without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 ARE DISCLAIMED.
 IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.amihaiemil.eva.concurrency;

import com.amihaiemil.eva.Eva;

/**
 * Asynchronous thread for running an evolutionary algorithm.
 * @author Mihai Andronache (amihaiemil@gmail.com)
 */
public final class AsynchronousEvaThread implements Runnable {
    private SolutionCallback callback;
    private Eva algorithm;
    private String threadName;
    private int runs;
    private Thread tr;
    /**
     * Constructor.
     * @param algorithm The evolutionary algorithm to be run.
     * @param callback The callback logic (what to do with the found solution?).
     * @param name The name of this runnable (it will be suffixed with _nrOfRuns).
     */
    public AsynchronousEvaThread(Eva algorithm, SolutionCallback callback, String name) {
        this.algorithm = algorithm;
        this.callback = callback;
        this.threadName = name;
    }

    public void run() {
        callback.execute(algorithm.calculate());
    }

    /**
     * Start the execution of a new thread.
     */
    public void start() {
        runs++;
        tr = new Thread(this, threadName + "_" + runs);
        tr.start();

    }

    public void stop() {
        tr.interrupt();
    }
}
