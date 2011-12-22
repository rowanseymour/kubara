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

import com.ijuru.imibare.lang.BantuNoun;

/**
 * Number renderer for Kirundi language
 */
public class KirundiNumberRenderer extends RwandaRundiNumberRenderer {
	
	private static final String[][] ONES = {
		//0   1        2         3         4       5         6            7        8          9
		{ "", "rimwe", "kabiri", "gatatu", "kane", "gatanu", "gatandatu", "indwi", "umunani", "icenda" }, // no noun
		{ "", "umwe",  "-",      "-",      "-",    "-",      "-",         "-",     "-",       "-"      }, // c1
		{ "", "umwe",  "babiri", "batatu", "bane", "batanu", "batandatu", "indwi", "umunani", "icenda" }, // c2
		{ "", "umwe",  "-",      "-",      "-",    "-",      "-",         "-",     "-",       "-"      }, // c3
		{ "", "umwe",  "ibiri",  "itatu",  "ine",  "itanu",  "itandatu",  "indwi", "umunani", "icenda" }, // c4
		{ "", "rimwe", "-",      "-",      "-",    "-",      "-",         "-",     "-",       "-"      }, // c5
		{ "", "rimwe", "abiri",  "atatu",  "ane",  "atanu",  "atandatu",  "indwi", "umunani", "icenda" }, // c6
		{ "", "kimwe", "-",      "-",      "-",    "-",      "-",         "-",     "-",       "-"      }, // c7
		{ "", "kimwe", "bibiri", "bitatu", "bine", "bitanu", "bitandatu", "indwi", "umunani", "icenda" }, // c8
		{ "", "imwe",  "-",      "-",      "-",    "-",      "-",         "-",     "-",       "-"      }, // c9
		{ "", "imwe",  "zibiri", "zitatu", "zine", "zitanu", "zitandatu", "indwi", "umunani", "icenda" }, // c10
		{ "", "rumwe", "-",      "-",      "-",    "-",      "-",         "-",     "-",       "-"      }, // c11
		{ "", "kamwe", "kabiri", "gatatu", "kane", "gatanu", "gatandatu", "indwi", "umunani", "icenda" }, // c12 (used for counting)
		{ "", "kamwe", "tubiri", "dutatu", "tune", "dutanu", "dutandatu", "indwi", "umunani", "icenda" }, // c13
		{ "", "bumwe", "bubiri", "butatu", "bune", "butanu", "butandatu", "indwi", "umunani", "icenda" }, // c14
		{ "", "kumwe", "-",      "-",      "-",    "-",      "-",         "-",     "-",       "-"      }, // c15
		{ "", "hamwe", "-",      "-",      "-",    "-",      "-",         "-",     "-",       "-"      }, // c16
	};
	
	private static final String[] TENS = {
		"",                 // 0
		"icumi",            // 10		
		"mirongo ibiri",    // 20
		"mirongo itatu",    // 30
		"mirongo ine",      // 40
		"mirongo itanu",    // 50
		"mirongo itandatu", // 60
		"mirongo irindwi",  // 70
		"mirongo umunani",  // 80
		"mirongo icenda",   // 90
	};
	
	private static final String[] HUNDREDS = {
		"",                 // 0
		"ijana",            // 100	
		"amajana abiri",    // 200
		"amajana atatu",    // 300
		"amajana ane",      // 400
		"amajana atanu",    // 500
		"amajana atandatu", // 600
		"amajana indwi",    // 700
		"amajana umunani",  // 800
		"amajana icenda",   // 900
	};
	
	public static final String NEGATIVE = "kuramwo";
	public static final String ZERO = "ubusa";
	public static final BantuNoun THOUSAND = new BantuNoun("igihumbi", 7, "ibihumbi", 8);
	public static final BantuNoun MILLION = new BantuNoun("umuliyoni", 3, "imiliyoni", 4);
	public static final BantuNoun BILLION = new BantuNoun("umuliyaridi", 3, "imiliyaridi", 4);
	
	@Override
	protected String[][] getOnes() {
		return ONES;
	}

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
	protected String getZeroWord() {
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
