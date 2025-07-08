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

import java.util.Collections;
import java.util.List;
import java.util.Locale;

import com.ijuru.kubara.lang.NounClassification;
import com.ijuru.kubara.renderer.impl.EnglishNumberRenderer;
import com.ijuru.kubara.renderer.impl.FrenchNumberRenderer;
import com.ijuru.kubara.renderer.impl.KinyarwandaNumberRenderer;
import com.ijuru.kubara.renderer.impl.KirundiNumberRenderer;
import com.ijuru.kubara.renderer.NumberRenderer;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for {@link NumberRendererFactory}
 */
public class NumberRendererFactoryTest {

	/**
	 * @see NumberRendererFactory#getRendererByLocale(java.util.Locale)
	 */
	@Test
	public void getRenderer() throws UnsupportedLanguageException {
		Assert.assertTrue(NumberRendererFactory.getRendererByLocale(Locale.of("en","","")) instanceof EnglishNumberRenderer);
		Assert.assertTrue(NumberRendererFactory.getRendererByLocale(Locale.of("fr","","")) instanceof FrenchNumberRenderer);
		Assert.assertTrue(NumberRendererFactory.getRendererByLocale(Locale.of("rw","","")) instanceof KinyarwandaNumberRenderer);
		Assert.assertTrue(NumberRendererFactory.getRendererByLocale(Locale.of("rn","","")) instanceof KirundiNumberRenderer);
	}

	/**
	 * @see NumberRendererFactory#getAllRenderers()
	 */
	@Test
	public void getAllRenderers() {
        Assert.assertFalse(NumberRendererFactory.getAllRenderers().isEmpty());
	}

	/**
	 * @see NumberRendererFactory#registerRenderer(com.ijuru.kubara.renderer.NumberRenderer)
	 */
	@Test
	public void registerRenderer() throws UnsupportedLanguageException {
		NumberRendererFactory.registerRenderer(new TestRenderer());
		Assert.assertTrue(NumberRendererFactory.getRendererByLocale(Locale.of("tt")) instanceof TestRenderer);
	}

	/**
	 * Dummy renderer for testing
	 */
	protected static class TestRenderer implements NumberRenderer {

		@Override
		public Locale getLocale() {
			return Locale.of("tt");
		}

		@Override
		public List<NounClassification> getSupportedNounClassifications() {
			return Collections.singletonList(NounClassification.MALE);
		}

		@Override
		public String render(long number, NounClassification attributes) {
			return "test";
		}
	}
}
