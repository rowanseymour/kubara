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

import java.util.Locale;

import com.ijuru.imibare.lang.NounAttributes;
import com.ijuru.imibare.renderer.EnglishNumberRenderer;
import com.ijuru.imibare.renderer.FrenchNumberRenderer;
import com.ijuru.imibare.renderer.KinyarwandaNumberRenderer;
import com.ijuru.imibare.renderer.KirundiNumberRenderer;
import com.ijuru.imibare.renderer.NumberRenderer;

import junit.framework.Assert;
import junit.framework.TestCase;

class TestRenderer implements NumberRenderer {
	@Override
	public String render(long number, NounAttributes attributes) {
		return "test";
	}
}

/**
 * Test case for RendererFactory class
 */
public class RendererFactoryTest extends TestCase {
	
	public void testGetRenderer() throws UnsupportedLanguageException {
		Assert.assertTrue(NumberRendererFactory.getRendererByLocale(new Locale("en")) instanceof EnglishNumberRenderer);
		Assert.assertTrue(NumberRendererFactory.getRendererByLocale(new Locale("fr")) instanceof FrenchNumberRenderer);
		Assert.assertTrue(NumberRendererFactory.getRendererByLocale(new Locale("rw")) instanceof KinyarwandaNumberRenderer);
		Assert.assertTrue(NumberRendererFactory.getRendererByLocale(new Locale("rn")) instanceof KirundiNumberRenderer);
	}

	public void testRegisterRenderer() throws UnsupportedLanguageException {
		NumberRendererFactory.registerRenderer(new Locale("tt"), new TestRenderer());
		Assert.assertTrue(NumberRendererFactory.getRendererByLocale(new Locale("tt")) instanceof TestRenderer);
	}
}
