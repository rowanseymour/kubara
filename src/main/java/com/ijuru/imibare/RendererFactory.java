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

import com.ijuru.imibare.renderer.EnglishRenderer;
import com.ijuru.imibare.renderer.FrenchRenderer;
import com.ijuru.imibare.renderer.KinyarwandaRenderer;
import com.ijuru.imibare.renderer.KirundiRenderer;
import com.ijuru.imibare.renderer.Renderer;

/**
 * Factory class to create renderer instances
 */
public class RendererFactory {

	private static final Map<Locale, Renderer> renderers = new HashMap<Locale, Renderer>();
	
	static {
		registerRenderer(new Locale("en"), new EnglishRenderer());
		registerRenderer(new Locale("fr"), new FrenchRenderer());
		registerRenderer(new Locale("rw"), new KinyarwandaRenderer());
		registerRenderer(new Locale("rn"), new KirundiRenderer());
	}
	
	/**
	 * Gets a renderer for the given locale
	 * @param locale the locale
	 * @return the renderer
	 */
	public static Renderer getRendererByLocale(Locale locale) throws UnsupportedLanguageException {
		if (!renderers.containsKey(locale))
			throw new UnsupportedLanguageException(locale);
		
		return renderers.get(locale);
	}
	
	/**
	 * Registers a renderer for the given locale
	 * @param locale the locale
	 * @param renderer the renderer
	 */
	public static void registerRenderer(Locale locale, Renderer renderer) {
		renderers.put(locale, renderer);
	}
}
