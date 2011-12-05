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

package com.ijuru.imibare;

/**
 * Number representation used in spoken English, Kinyarwanda and Kirundi etc
 */
public class DecimalBases {
	public boolean negative;
	public int trillions;
	public int billions;
	public int millions;
	public int thousands;
	public int hundreds;
	public int tens;
	public int ones;
	
	/**
	 * Creates a based number 
	 * @param val the number
	 * @param useTrillion true if trillion should be used as a base
	 */
	public DecimalBases(long val, boolean useTrillion) {
		this.negative = val < 0;
		val = Math.abs(val);
		
		if (useTrillion) {
			this.trillions = (int)(val / 1000000000000l);
			val = val - this.trillions * 1000000000000l;
		}
		
		this.billions = (int)(val / 1000000000l);
		val = val - this.billions * 1000000000l;
		this.millions = (int)(val / 1000000l);
		val = val - this.millions * 1000000l;
		this.thousands = (int)(val / 1000l);
		val = val - this.thousands * 1000l;
		this.hundreds = (int)(val / 100l);
		val = val - this.hundreds * 100l;
		this.tens = (int)(val / 10l);
		this.ones = (int)(val - this.tens * 10l);
	}
	
	/**
	 * Calculates the value of this number
	 * @return the value
	 */
	public long calcValue() {
		long mag = ones + tens * 10l + hundreds * 100l + thousands * 1000l + millions * 1000000l + billions * 1000000000l + trillions * 1000000000000l;
		return this.negative ? -mag : mag;
	}
}
