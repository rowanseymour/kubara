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

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

/**
 * Tests for {@link Gender}
 */
public class GenderTest {

	/**
	 * @see Gender#parse(String)
	 */
	@Test
	public void parse_shouldParseString() {
		Assert.assertThat(Gender.parse("m"), is(Gender.MALE));
		Assert.assertThat(Gender.parse("f"), is(Gender.FEMALE));
		Assert.assertThat(Gender.parse("n"), is(Gender.NEUTER));
	}

	/**
	 * @see Gender#parse(String)
	 */
	@Test(expected = NullPointerException.class)
	public void parse_shouldThrowExceptionIfInputNull() {
		Gender.parse(null);
	}

	/**
	 * @see Gender#parse(String)
	 */
	@Test(expected = IllegalArgumentException.class)
	public void parse_shouldThrowExceptionIfInputNotParseable() {
		Gender.parse("xxxx");
	}

	/**
	 * @see Gender#toString()
	 */
	@Test
	public void toString_shouldReturnAsCode() {
		Assert.assertThat(Gender.MALE.toString(), is("m"));
		Assert.assertThat(Gender.FEMALE.toString(), is("f"));
		Assert.assertThat(Gender.NEUTER.toString(), is("n"));
	}
}
