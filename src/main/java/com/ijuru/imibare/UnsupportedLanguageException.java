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

/**
 * Exception class for unsupported languages
 */
public class UnsupportedLanguageException extends Exception {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Creates an exception for the requested language
	 * @param lang the requested language
	 */
	public UnsupportedLanguageException(Locale locale) {
		super("Language '" + locale.getDisplayLanguage() + "' is not supported");
	}
}
