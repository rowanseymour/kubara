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

package com.ijuru.imibare.lang;

/**
 * Basic Bantu noun which uses the 16 standard Bantu noun classes
 */
public class BantuNoun extends Noun {
	public int singularClass;
	public int pluralClass;
	
	/**
	 * Constructs a basic Bantu word
	 * @param singular the singular form
	 * @param singularClass the singular class
	 * @param plural the plural form
	 * @param pluralClass the plural class
	 */
	public BantuNoun(String singular, int singularClass, String plural, int pluralClass) {
		super(singular, plural);
		
		this.singularClass = singularClass;
		this.pluralClass = pluralClass;
	}
}