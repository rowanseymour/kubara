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

/**
 * Basic Bantu noun which uses the 16 standard Bantu noun classes
 */
public class BantuNoun extends Noun {

	protected int singularClazz;
	protected int pluralClazz;
	
	/**
	 * Constructs a basic Bantu word
	 * @param singularForm the singular form
	 * @param singularClazz the singular class
	 * @param pluralForm the plural form
	 * @param pluralClazz the plural class
	 */
	public BantuNoun(String singularForm, int singularClazz, String pluralForm, int pluralClazz) {
		super(singularForm, pluralForm);
		
		this.singularClazz = singularClazz;
		this.pluralClazz = pluralClazz;
	}

	/**
	 * Gets the singular class
	 * @return the singular class
	 */
	public int getSingularClazz() {
		return singularClazz;
	}

	/**
	 * Gets the plural class
	 * @return the plural class
	 */
	public int getPluralClazz() {
		return pluralClazz;
	}
}