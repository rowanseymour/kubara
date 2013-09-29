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

import static org.hamcrest.CoreMatchers.*;

/**
 * Tests for {@link NounDescriptor}
 */
public class NounDescriptorTest {

	/**
	 * @see NounDescriptor#equals(Object)
	 */
	@Test
	public void equals_shouldCheckEquality() {
		Assert.assertFalse(new NounDescriptor().equals(null));
		Assert.assertFalse(new NounDescriptor().equals(new String("")));
		Assert.assertTrue(new NounDescriptor().equals(new NounDescriptor()));
		Assert.assertTrue(new NounDescriptor(1, Gender.MALE).equals(new NounDescriptor(1, Gender.MALE)));
		Assert.assertFalse(new NounDescriptor(2, Gender.MALE).equals(new NounDescriptor(1, Gender.MALE)));
		Assert.assertFalse(new NounDescriptor(1, Gender.FEMALE).equals(new NounDescriptor(1, Gender.MALE)));
	}

	/**
	 * @see NounDescriptor#parse(String)
	 */
	@Test
	public void parse_shouldParseString() {
		Assert.assertThat(NounDescriptor.parse(""), is(NounDescriptor.GENERIC));

		Assert.assertThat(NounDescriptor.parse("m"), is(NounDescriptor.MALE));
		Assert.assertThat(NounDescriptor.parse("f"), is(NounDescriptor.FEMALE));
		Assert.assertThat(NounDescriptor.parse("n"), is(new NounDescriptor(null, Gender.NEUTER)));

		Assert.assertThat(NounDescriptor.parse("c1"), is(new NounDescriptor(1, null)));
		Assert.assertThat(NounDescriptor.parse("c2m"), is(new NounDescriptor(2, Gender.MALE)));
		Assert.assertThat(NounDescriptor.parse("c3f"), is(new NounDescriptor(3, Gender.FEMALE)));
		Assert.assertThat(NounDescriptor.parse("c4n"), is(new NounDescriptor(4, Gender.NEUTER)));

	}

	/**
	 * @see NounDescriptor#parse(String)
	 */
	@Test(expected = NullPointerException.class)
	public void parse_shouldThrowExceptionIfNull() {
		NounDescriptor.parse(null);
	}
}
