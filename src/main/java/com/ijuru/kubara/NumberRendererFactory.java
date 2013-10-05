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

import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.ijuru.kubara.renderer.impl.EnglishNumberRenderer;
import com.ijuru.kubara.renderer.impl.FrenchNumberRenderer;
import com.ijuru.kubara.renderer.impl.KinyarwandaNumberRenderer;
import com.ijuru.kubara.renderer.impl.KirundiNumberRenderer;
import com.ijuru.kubara.renderer.NumberRenderer;

/**
 * Factory class to create renderer instances
 */
public class NumberRendererFactory {

	private static final Map<Locale, NumberRenderer> renderers = new HashMap<Locale, NumberRenderer>();
	
	static {
		registerRenderer(new EnglishNumberRenderer());
		registerRenderer(new FrenchNumberRenderer());
		registerRenderer(new KinyarwandaNumberRenderer());
		registerRenderer(new KirundiNumberRenderer());
	}
	
	/**
	 * Gets a renderer for the given locale
	 * @param locale the locale
	 * @return the renderer
	 */
	public static NumberRenderer getRendererByLocale(Locale locale) throws UnsupportedLanguageException {
		if (!renderers.containsKey(locale))
			throw new UnsupportedLanguageException(locale);
		
		return renderers.get(locale);
	}

	/**
	 * Gets all available renderers
	 * @return the renderers
	 */
	public static Collection<NumberRenderer> getAllRenderers() {
		return renderers.values();
	}
	
	/**
	 * Registers a renderer
	 * @param renderer the renderer
	 */
	public static void registerRenderer(NumberRenderer renderer) {
		renderers.put(renderer.getLocale(), renderer);
	}
}
