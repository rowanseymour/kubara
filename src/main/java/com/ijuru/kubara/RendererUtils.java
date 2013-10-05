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

package com.ijuru.kubara;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility methods for renderers
 */
public class RendererUtils {

	/**
	 * Checks whether the given character is a vowel
	 * @param c the character
	 * @return true if its a vowel, else false
	 */
	public static boolean isVowel(char c) {
		c = Character.toLowerCase(c);
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}
	
	/**
	 * Removes empty strings from the given list
	 * @param strings the list of strings
	 * @return the new list with no empty values
	 */
	public static List<String> removeEmpty(List<String> strings) {
		List<String> result = new ArrayList<String>();
		for (String string : strings) {
			if (string.length() > 0)
				result.add(string);
		}
		return result;
	}
	
	/**
	 * Joins the given list of strings
	 * @param strings the list of strings
	 * @param delimiter the delimiter
	 * @return the joined string
	 */
	public static String join(List<String> strings, String delimiter) {
		if (strings.size() == 0)
			return "";
		
		StringBuilder builder = new StringBuilder(strings.get(0));
		for (int s = 1; s < strings.size(); ++s) {
			builder.append(delimiter);
			builder.append(strings.get(s));
		}
		
		return builder.toString();
	}
}
