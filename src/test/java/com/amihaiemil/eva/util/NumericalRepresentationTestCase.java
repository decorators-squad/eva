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
package com.amihaiemil.eva.util;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * @author Mihai Andronache (amihaiemil@gmail.com)
 */
public class NumericalRepresentationTestCase {
    /**
     * A number can be added to a NumericalRepresentation.
     */
    @Test
    public void addsNumber() {
        NumericalRepresentation representation = new NumericalRepresentation();
        assertTrue(representation.getSize() == 0);
        representation = representation.addNumber(5);
        assertTrue(representation.getSize() == 1);
        assertTrue(representation.get(0) == 5);

    }

    /**
     * A number can be replaced in a NumericalRepresentation.
     */
    @Test
    public void replacesNumberAt() {
        NumericalRepresentation representation = new NumericalRepresentation(Arrays.asList(1, 2, 3));
        assertTrue(representation.getSize() == 3);
        assertTrue(representation.get(1) == 2);
        representation = representation.replaceAt(2, 4);
        assertTrue(representation.getSize() == 3);
        assertTrue(representation.get(2) == 4);
    }
    
    /**
     * A NumericalRepresentation can be created from a string of digits.
     */
    @Test
    public void constructsFromString() {
    	NumericalRepresentation representation = new NumericalRepresentation("123456");
    	assertTrue(representation.getSize() == 6);
    	assertTrue(representation.get(3) == 4);
    }

}
