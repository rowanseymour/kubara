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

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Describes a type of noun
 */
public class NounDescriptor {

	/**
	 * Presets for male and female
	 */
	public static final NounDescriptor GENERIC = new NounDescriptor(null, null);
	public static final NounDescriptor MALE = new NounDescriptor(null, Gender.MALE);
	public static final NounDescriptor FEMALE = new NounDescriptor(null, Gender.FEMALE);
	
	private Integer clazz = null;
	private Gender gender = null;
	
	/**
	 * Constructs default noun attributes
	 */
	public NounDescriptor() {
	}
	
	/**
	 * Constructs new noun attributes
	 * @param clazz the class
	 * @param gender the gender
	 */
	public NounDescriptor(Integer clazz, Gender gender) {
		this.clazz = clazz;
		this.gender = gender;
	}
	
	/**
	 * Parses noun attributes from a string in the format [clazz][gender], e.g. c1, m, c2f
	 * @param str the input string
	 * @return the noun attributes
	 */
	public static NounDescriptor parse(String str) {
		str = str.trim();

		Pattern regex = Pattern.compile("(c\\d{1,2})?([mfn]?)");
		Matcher matcher = regex.matcher(str);
		if (matcher.find()) {
			String strClazz = matcher.group(1);
			String strGender = matcher.group(2);
			Integer clazz = StringUtils.isNotEmpty(strClazz) ? Integer.parseInt(strClazz.substring(1)) : null;
			Gender gender = StringUtils.isNotEmpty(strGender) ? Gender.parse(strGender) : null;
			return new NounDescriptor(clazz, gender);
		}

		return GENERIC;
	}
	
	/**
	 * Gets the noun class
	 * @return the noun class
	 */
	public Integer getClazz() {
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
	 * @see Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		if (clazz != null) {
			sb.append("c" + clazz);
		}
		if (gender != null) {
			sb.append(gender.toString());
		}
		return sb.toString();
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
		NounDescriptor other = (NounDescriptor)obj;
		return (clazz == other.clazz && gender == other.gender);
	}
	
	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return clazz + ((gender != null ) ? gender.hashCode() : 0);
	}
}
