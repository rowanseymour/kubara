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

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

/**
 * Test cases for Utils class
 */
public class RendererUtilsTest extends TestCase {

	public void testIsVowel() {
		assertTrue(RendererUtils.isVowel('A'));
		assertTrue(RendererUtils.isVowel('a'));
		assertFalse(RendererUtils.isVowel('Z'));
		assertFalse(RendererUtils.isVowel('z'));
	}
	
	public void testRemoveEmpty() {
		List<String> strings = new ArrayList<String>();
		strings.add("");
		strings.add("abc");
		strings.add("");
		strings.add("def");
		strings = RendererUtils.removeEmpty(strings);
		assertEquals(2, strings.size());
		assertEquals("abc", strings.get(0));
		assertEquals("def", strings.get(1));
	}

	public void testJoin() {
		List<String> strings = new ArrayList<String>();
		assertEquals("", RendererUtils.join(strings, "|"));
		
		strings.add("abc");
		assertEquals("abc", RendererUtils.join(strings, "|"));
		strings.add("def");
		assertEquals("abc|def", RendererUtils.join(strings, "|"));
		strings.add("ghi");
		assertEquals("abc|def|ghi", RendererUtils.join(strings, "|"));
	}
}
