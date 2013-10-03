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
 * Tests for {@link NounClassification}
 */
public class NounClassificationTest {

	/**
	 * @see NounClassification#equals(Object)
	 */
	@Test
	public void equals_shouldCheckEquality() {
		Assert.assertTrue(new NounClassification(Gender.MALE).equals(new NounClassification(Gender.MALE)));
		Assert.assertTrue(new NounClassification(Gender.FEMALE).equals(new NounClassification(Gender.FEMALE)));
		Assert.assertTrue(new NounClassification(3).equals(new NounClassification(3)));

		Assert.assertFalse(new NounClassification(Gender.NEUTER).equals(new NounClassification(Gender.MALE)));
		Assert.assertFalse(new NounClassification(2).equals(new NounClassification(1)));
	}

	/**
	 * @see NounClassification#parse(String)
	 */
	@Test
	public void parse_shouldParseString() {
		Assert.assertThat(NounClassification.parse("m"), is(NounClassification.MALE));
		Assert.assertThat(NounClassification.parse("f"), is(NounClassification.FEMALE));
		Assert.assertThat(NounClassification.parse("n"), is(new NounClassification(Gender.NEUTER)));

		Assert.assertThat(NounClassification.parse("c1"), is(new NounClassification(1)));
		Assert.assertThat(NounClassification.parse("c2"), is(new NounClassification(2)));

	}

	/**
	 * @see NounClassification#parse(String)
	 */
	@Test(expected = NullPointerException.class)
	public void parse_shouldThrowExceptionIfNull() {
		NounClassification.parse(null);
	}

	/**
	 * @see NounClassification#getCode()
	 */
	@Test
	public void getCode() {
		Assert.assertThat(NounClassification.MALE.getCode(), is("m"));
		Assert.assertThat(new NounClassification(5).getCode(), is("c5"));
	}
}