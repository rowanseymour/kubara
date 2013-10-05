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

package com.ijuru.kubara.renderer;

import com.ijuru.kubara.lang.NounClassification;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Locale;

/**
 * Interface for a basic number renderer
 */
@XmlRootElement
public interface NumberRenderer {

	/**
	 * Gets the locale of this renderer
	 * @return the locale
	 */
	@XmlElement
	Locale getLocale();

	/**
	 * Gets the list of noun classifications that are supported by this renderer
	 * @return the noun classifications
	 */
	@XmlElement(name = "supports")
	List<NounClassification> getSupportedNounClassifications();

	/**
	 * Renders the number into it's spoken form
	 * @param number the number
	 * @param classification noun classification
	 * @return the spoken form
	 */
	String render(long number, NounClassification classification);
}