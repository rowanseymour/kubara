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

import com.ijuru.imibare.renderer.EnglishRenderer;
import com.ijuru.imibare.renderer.FrenchRenderer;
import com.ijuru.imibare.renderer.KinyarwandaRenderer;
import com.ijuru.imibare.renderer.KirundiRenderer;
import com.ijuru.imibare.renderer.Renderer;

/**
 * Factory class to create renderer instances
 */
public class RendererFactory {

	/**
	 * Gets a renderer for the given language
	 * @param lang the language, e.g. 'en'
	 * @return the renderer
	 */
	public static Renderer getRenderer(String lang) throws UnsupportedLanguageException {
		if (lang.equals("en"))
			return new EnglishRenderer();
		else if (lang.equals("fr"))
			return new FrenchRenderer();
		else if (lang.equals("rw"))
			return new KinyarwandaRenderer();
		else if (lang.equals("rn"))
			return new KirundiRenderer();
		
		throw new UnsupportedLanguageException(lang);
	}
}
