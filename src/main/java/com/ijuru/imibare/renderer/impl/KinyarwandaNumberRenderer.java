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

package com.ijuru.imibare.renderer.impl;

import com.ijuru.imibare.lang.BantuNoun;
import com.ijuru.imibare.lang.NounClassification;
import com.ijuru.imibare.renderer.BaseRwandaRundiNumberRenderer;

import java.util.Locale;

/**
 * Number renderer for Kinyarwanda language
 */
public class KinyarwandaNumberRenderer extends BaseRwandaRundiNumberRenderer {
	
	private static final String[][] ONES = {
		//0   1        2         3         4       5         6            7           8         9
		{ "", "rimwe", "kabiri", "gatatu", "kane", "gatanu", "gatandatu", "karindwi", "umunani", "icyenda" }, // no noun
		{ "", "umwe",  "-",      "-",      "-",    "-",      "-",         "-",        "-",       "-"       }, // c1
		{ "", "umwe",  "babiri", "batatu", "bane", "batanu", "batandatu", "barindwi", "umunani", "icyenda" }, // c2
		{ "", "umwe",  "-",      "-",      "-",    "-",      "-",         "-",        "-",       "-"       }, // c3
		{ "", "umwe",  "ibiri",  "itatu",  "ine",  "itanu",  "itandatu",  "irindwi",  "umunani", "icyenda" }, // c4
		{ "", "rimwe", "-",      "-",      "-",    "-",      "-",         "-",        "-",       "-"       }, // c5
		{ "", "rimwe", "abiri",  "atatu",  "ane",  "atanu",  "atandatu",  "arindwi",  "umunani", "icyenda" }, // c6
		{ "", "kimwe", "-",      "-",      "-",    "-",      "-",         "-",        "-",       "-"       }, // c7
		{ "", "kimwe", "bibiri", "bitatu", "bine", "bitanu", "bitandatu", "birindwi", "umunani", "icyenda" }, // c8
		{ "", "imwe",  "-",      "-",      "-",    "-",      "-",         "-",        "-",       "-"       }, // c9
		{ "", "imwe",  "ebyiri", "eshatu", "enye", "eshanu", "esheshatu", "irindwi",  "umunani", "icyenda" }, // c10
		{ "", "rumwe", "-",      "-",      "-",    "-",      "-",         "-",        "-",       "-"       }, // c11
		{ "", "kamwe", "kabiri", "gatatu", "kane", "gatanu", "gatandatu", "karindwi", "umunani", "icyenda" }, // c12
		{ "", "kamwe", "tubiri", "dutatu", "tune", "dutanu", "dutandatu", "turindwi", "umunani", "icyenda" }, // c13
		{ "", "bumwe", "bubiri", "butatu", "bune", "butanu", "butandatu", "burindwi", "umunani", "icyenda" }, // c14
		{ "", "kumwe", "-",      "-",      "-",    "-",      "-",         "-",        "-",       "-"       }, // c15
		{ "", "hamwe", "-",      "-",      "-",    "-",      "-",         "-",        "-",       "-"       }, // c16
	};
	
	private static final String[] TENS = {
		"",                 // 0
		"cumi",             // 10		
		"makumyabiri",      // 20
		"mirongo itatu",    // 30
		"mirongo ine",      // 40
		"mirongo itanu",    // 50
		"mirongo itandatu", // 60
		"mirongo irindwi",  // 70
		"mirongo inani",    // 80
		"mirongo icyenda",  // 90
	};
	
	private static final String[] HUNDREDS = {
		"",                // 0
		"ijana",           // 100	
		"magana abiri",    // 200
		"magana atatu",    // 300
		"magana ane",      // 400
		"magana atanu",    // 500
		"magana atandatu", // 600
		"magana arindwi",  // 700
		"magana inani",    // 800
		"magana cyenda",   // 900
	};
	
	public static final String NEGATIVE = "kuramo";
	public static final String ZERO = "zeru";
	public static final BantuNoun THOUSAND = new BantuNoun("igihumbi", 7, "ibihumbi", 8);
	public static final BantuNoun MILLION = new BantuNoun("miliyoni", 9, "miliyoni", 10);
	public static final BantuNoun BILLION = new BantuNoun("miliyari", 9, "miliyari", 10);

	/**
	 * @see com.ijuru.imibare.renderer.NumberRenderer#getLocale()
	 */
	@Override
	public Locale getLocale() {
		return new Locale("rw");
	}

	/**
	 * @see BaseRwandaRundiNumberRenderer#getOnes()
	 */
	@Override
	protected String[][] getOnes() {
		return ONES;
	}

	/**
	 * @see BaseRwandaRundiNumberRenderer#getTens()
	 */
	@Override
	protected String[] getTens() {
		return TENS;
	}

	@Override
	protected String[] getHundreds() {
		return HUNDREDS;
	}
	
	@Override
	protected String getNegativeWord() {
		return NEGATIVE;
	}
	
	@Override
	protected String getZeroWord(NounClassification nounClassification) {
		return ZERO;
	}
	
	@Override
	protected BantuNoun getThousandNoun() {
		return THOUSAND;
	}
	
	@Override
	protected BantuNoun getMillionNoun() {
		return MILLION;
	}
	
	@Override
	protected BantuNoun getBillionNoun() {
		return BILLION;
	}
}
