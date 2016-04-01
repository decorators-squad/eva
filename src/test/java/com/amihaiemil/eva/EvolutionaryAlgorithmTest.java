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
package com.amihaiemil.eva;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

import com.amihaiemil.eva.backpack.FitnessForBackpackEvaluator;
import com.amihaiemil.eva.util.BinaryArraySolutionsGenerator;

/**
 * Test cases for {@link Eva} implementations.
 * @author Mihai Andronache (amihaiemil@gmail.com)
 */
public class EvolutionaryAlgorithmTest {
    private Random r = new Random();

    /**
     * {@link SimpleEvolutionaryAlgorithm} can find an acceptable solution.
     * This test might take a while to finish, since there is no time limit specified.
     * @throws Exception If something goes wrong.
     */
    @Test
    public void simpleEvaFindsASolution() throws Exception {
        long[] weights = new long[10];
        for(int i=0;i<10;i++) {
            weights[i] = r.nextInt(100);
        }
        FitnessForBackpackEvaluator evaluator = new FitnessForBackpackEvaluator(weights);
        BinaryArraySolutionsGenerator generator = new BinaryArraySolutionsGenerator(weights.length);

         // The algorithm should stop only when the found solution is acceptable.
        Condition solutionIsAcceptable = new Condition() {
            public boolean passed(Solution solution) {
                return solution.isAcceptable();
            }
        };

        Eva algorithm = new SimpleEvolutionaryAlgorithm();
        Solution solution = algorithm.with(generator).with(evaluator).with(solutionIsAcceptable).calculate();
        assertTrue(
            "Expected solution with weight <= 100",
            solutionIsAcceptable.passed(solution)
        );
    }
}