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

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for {@link NounAttributes}
 */
public class NounAttributesTest {

	/**
	 * @see NounAttributes#equals(Object)
	 */
	@Test
	public void equals_shouldCheckEquality() {
		Assert.assertFalse(new NounAttributes().equals(null));
		Assert.assertFalse(new NounAttributes().equals(new String("")));
		Assert.assertTrue(new NounAttributes().equals(new NounAttributes()));
		Assert.assertTrue(new NounAttributes(1, Gender.MALE).equals(new NounAttributes(1, Gender.MALE)));
		Assert.assertFalse(new NounAttributes(2, Gender.MALE).equals(new NounAttributes(1, Gender.MALE)));
		Assert.assertFalse(new NounAttributes(1, Gender.FEMALE).equals(new NounAttributes(1, Gender.MALE)));
	}

	/**
	 * @see NounAttributes#parse(String)
	 */
	@Test
	public void parse() {
		Assert.assertEquals(new NounAttributes(), NounAttributes.parse(null));
		Assert.assertEquals(new NounAttributes(), NounAttributes.parse(""));
		Assert.assertEquals(new NounAttributes(1, Gender.UNSPECIFIED), NounAttributes.parse("c1"));
		Assert.assertEquals(new NounAttributes(2, Gender.MALE), NounAttributes.parse("c2m"));
		Assert.assertEquals(new NounAttributes(3, Gender.FEMALE), NounAttributes.parse("c3f"));
		Assert.assertEquals(new NounAttributes(4, Gender.NEUTER), NounAttributes.parse("c4n"));
		Assert.assertEquals(new NounAttributes(0, Gender.MALE), NounAttributes.parse("m"));
	}
}
