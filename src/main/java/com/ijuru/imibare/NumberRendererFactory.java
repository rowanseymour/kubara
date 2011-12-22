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

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.ijuru.imibare.renderer.EnglishNumberRenderer;
import com.ijuru.imibare.renderer.FrenchNumberRenderer;
import com.ijuru.imibare.renderer.KinyarwandaNumberRenderer;
import com.ijuru.imibare.renderer.KirundiNumberRenderer;
import com.ijuru.imibare.renderer.NumberRenderer;

/**
 * Factory class to create renderer instances
 */
public class NumberRendererFactory {

	private static final Map<Locale, NumberRenderer> renderers = new HashMap<Locale, NumberRenderer>();
	
	static {
		registerRenderer(new Locale("en"), new EnglishNumberRenderer());
		registerRenderer(new Locale("fr"), new FrenchNumberRenderer());
		registerRenderer(new Locale("rw"), new KinyarwandaNumberRenderer());
		registerRenderer(new Locale("rn"), new KirundiNumberRenderer());
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
	 * Registers a renderer for the given locale
	 * @param locale the locale
	 * @param renderer the renderer
	 */
	public static void registerRenderer(Locale locale, NumberRenderer renderer) {
		renderers.put(locale, renderer);
	}
}
