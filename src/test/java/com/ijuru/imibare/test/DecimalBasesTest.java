/**
 * Copyright 2011 Rowan Seymour
 * 
 * This file is part of Imibare.
 *
 * Imibare is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Imibare is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Imibare. If not, see <http://www.gnu.org/licenses/>.
 */

package com.ijuru.imibare.test;

import junit.framework.TestCase;

import com.ijuru.imibare.DecimalBases;

/**
 * Test cases for DecimalBases class
 */
public class DecimalBasesTest extends TestCase {

	public void testConstructor() {
		// Number is zero
		DecimalBases num = new DecimalBases(0, false);
		assertFalse(num.negative);
		assertEquals(0, num.ones);
		assertEquals(0, num.tens);
		assertEquals(0, num.hundreds);
		assertEquals(0, num.thousands);
		assertEquals(0, num.millions);
		assertEquals(0, num.billions);
		
		// Number is less than ten
		num = new DecimalBases(5, true);
		assertFalse(num.negative);
		assertEquals(5, num.ones);
		assertEquals(0, num.tens);
		assertEquals(0, num.hundreds);
		assertEquals(0, num.thousands);
		assertEquals(0, num.millions);
		assertEquals(0, num.billions);
		
		num = new DecimalBases(1234567890, true);
		assertFalse(num.negative);
		assertEquals(0, num.ones);
		assertEquals(9, num.tens);
		assertEquals(8, num.hundreds);
		assertEquals(567, num.thousands);
		assertEquals(234, num.millions);
		assertEquals(1, num.billions);
		
		// Number larger than one trillion but not using trillions
		num = new DecimalBases(1234567890123l, false);
		assertFalse(num.negative);
		assertEquals(3, num.ones);
		assertEquals(2, num.tens);
		assertEquals(1, num.hundreds);
		assertEquals(890, num.thousands);
		assertEquals(567, num.millions);
		assertEquals(1234, num.billions);
		assertEquals(0, num.trillions);
		
		// Number larger than one trillion and using trillions
		num = new DecimalBases(1234567890123l, true);
		assertFalse(num.negative);
		assertEquals(3, num.ones);
		assertEquals(2, num.tens);
		assertEquals(1, num.hundreds);
		assertEquals(890, num.thousands);
		assertEquals(567, num.millions);
		assertEquals(234, num.billions);
		assertEquals(1, num.trillions);
		
		// Number less than zero
		num = new DecimalBases(-1234567890, true);
		assertTrue(num.negative);
		assertEquals(0, num.ones);
		assertEquals(9, num.tens);
		assertEquals(8, num.hundreds);
		assertEquals(567, num.thousands);
		assertEquals(234, num.millions);
		assertEquals(1, num.billions);
	}
	
	public void testCalcValue() {
		DecimalBases num = new DecimalBases(0, true);
		assertEquals(0, num.calcValue());
		
		num = new DecimalBases(1234567890123l, true);
		assertEquals(1234567890123l, num.calcValue());
		
		num = new DecimalBases(-1234567890123l, true);
		assertEquals(-1234567890123l, num.calcValue());
	}
}
