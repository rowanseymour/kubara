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
 * Noun classification
 */
public class NounClassification {

	/**
	 * Presets
	 */
	public static final NounClassification MALE = new NounClassification(Gender.MALE);
	public static final NounClassification FEMALE = new NounClassification(Gender.FEMALE);
	
	private Integer nounClass = null;
	private Gender gender = null;

	/**
	 * Constructs new gender based classification
	 * @param gender the gender
	 */
	public NounClassification(Gender gender) {
		this.gender = gender;
	}
	
	/**
	 * Constructs new class number based classification
	 * @param nounClass the noun class
	 */
	public NounClassification(Integer nounClass) {
		this.nounClass = nounClass;
	}
	
	/**
	 * Parses noun attributes from a string, e.g. c1, m, c2
	 * @param str the input string
	 * @return the noun classification
	 */
	public static NounClassification parse(String str) {
		str = str.trim();

		if (str.startsWith("c")) {
			String strClazz = str.substring(1);
			return new NounClassification(Integer.parseInt(strClazz));
		}
		else {
			return new NounClassification(Gender.parse(str));
		}
	}
	
	/**
	 * Gets the noun class
	 * @return the noun class
	 */
	public Integer getNounClass() {
		return nounClass;
	}
	
	/**
	 * Gets the noun gender
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * Get the classification as a simple code, e.g. m, c2
	 * @return the code
	 */
	public String getCode() {
		if (nounClass != null) {
			return "c" + nounClass;
		}
		else  {
			return gender.toString();
		}
	}

	/**
	 * @see Object#equals(Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		NounClassification that = (NounClassification) o;

		if (gender != that.gender) return false;
		if (nounClass != null ? !nounClass.equals(that.nounClass) : that.nounClass != null) return false;

		return true;
	}

	/**
	 * @see Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int result = nounClass != null ? nounClass.hashCode() : 0;
		result = 31 * result + (gender != null ? gender.hashCode() : 0);
		return result;
	}
}