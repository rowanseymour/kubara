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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * General attributes of any noun
 */
public class NounAttributes {
	
	private static final int UNSPECIFIED_CLAZZ = 0;
	
	public static final NounAttributes MALE = new NounAttributes(UNSPECIFIED_CLAZZ, Gender.MALE);
	public static final NounAttributes FEMALE = new NounAttributes(UNSPECIFIED_CLAZZ, Gender.FEMALE);
	
	private int clazz = UNSPECIFIED_CLAZZ;
	private Gender gender = Gender.UNSPECIFIED;
	
	/**
	 * Constructs default noun attributes
	 */
	public NounAttributes() {
	}
	
	/**
	 * Constructs new noun attributes
	 * @param clazz the class
	 * @param gender the gender
	 */
	public NounAttributes(int clazz, Gender gender) {
		this.clazz = clazz;
		this.gender = gender;
	}
	
	/**
	 * Parses noun attributes from a string in the format [clazz][gender], e.g. 1, m, 2f
	 * @param str the input string
	 * @return the noun attributes
	 */
	public static NounAttributes parse(String str) {
		if (str != null) {	
			str = str.trim();	
			
			Pattern regex = Pattern.compile("(c\\d{1,2})?([mfn]?)", Pattern.CASE_INSENSITIVE);
			Matcher matcher = regex.matcher(str);
			if (matcher.find()) {
				String strClazz = matcher.group(1);
				String strGender = matcher.group(2);
				int clazz = (strClazz != null) ? Integer.parseInt(strClazz.substring(1)) : UNSPECIFIED_CLAZZ;
				Gender gender = Gender.parse(strGender);
				return new NounAttributes(clazz, gender);
			}
		}
		return new NounAttributes();
	}
	
	/**
	 * Gets the noun class
	 * @return the noun class
	 */
	public int getClazz() {
		return clazz;
	}
	
	/**
	 * Gets the noun gender
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NounAttributes other = (NounAttributes)obj;
		return (clazz == other.clazz && gender == other.gender);
	}
	
	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return clazz + gender.hashCode();
	}
}
