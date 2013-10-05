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

package com.ijuru.kubara.lang;

/**
 * Noun gender
 */
public enum Gender {

	MALE("m"),
	FEMALE("f"),
	NEUTER("n");

	private String code;

	/**
	 * Constructs a gender value
	 * @param code the string code
	 */
	Gender(String code) {
		this.code = code;
	}

	/**
	 * @see Object#toString()
	 */
	@Override
	public String toString() {
		return code;
	}
	
	/**
	 * Parses a gender from a string
	 * @param str the input string
	 * @return the gender
	 */
	public static Gender parse(String str) {
		for (Gender gender : values()) {
			if (str.equals(gender.code)) {
				return gender;
			}
		}
		throw new IllegalArgumentException("Unable to parse " + str + " into a gender");
	}
}
