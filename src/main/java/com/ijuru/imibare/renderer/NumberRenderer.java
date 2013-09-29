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

package com.ijuru.imibare.renderer;

import com.ijuru.imibare.lang.NounAttributes;

import java.util.Locale;

/**
 * Interface for a basic number renderer
 */
public interface NumberRenderer {

	/**
	 * Gets the locale of this renderer
	 * @return the locale
	 */
	Locale getLocale();

	/**
	 * Renders the number into it's spoken form
	 * @param number the number
	 * @param attributes noun attributes
	 * @return the spoken form
	 */
	String render(long number, NounAttributes attributes);
}