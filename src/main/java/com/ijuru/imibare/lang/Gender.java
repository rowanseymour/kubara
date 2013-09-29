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

package com.ijuru.imibare.lang;

/**
 * Noun gender
 */
public enum Gender {

	UNSPECIFIED,
	MALE,
	FEMALE,
	NEUTER;
	
	/**
	 * Parses a gender from a string
	 * @param str the input string
	 * @return the gender
	 */
	public static Gender parse(String str) {
		if (str != null && str.length() == 1) {
			switch (str.toLowerCase().charAt(0)) {
			case 'm':
				return MALE;
			case 'f':
				return FEMALE;
			case 'n':
				return NEUTER;
			}
		}
		return UNSPECIFIED;
	}
}
