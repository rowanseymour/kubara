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

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.ijuru.imibare.DecimalBases;
import com.ijuru.imibare.Utils;

/**
 * Number renderer for French language (WIP)
 */
public class FrenchRenderer implements Renderer {
	
	public static final int MALE = 0;
	public static final int FEMALE = 1;
	
	private static final String CONJ_MINOR = "-";
	private static final String CONJ_MAJOR = " et ";
	
	private static final String[] ONE = { "un", "une" };
	
	private static final String[] ONES = {
		"", "", "deux", "trois", "quatre", "cinq", "six", "sept", "huit", "neuf"    
	};
	
	private static final String[] TEENS = {
		"", "onze", "douze", "treize", "quatorze", "quinze", "seize", "dix-sept", "dix-huit", "dix-neuf"		
	};
	
	private static final String[] TENS = {
		"", "dix", "vingt", "trente", "quarante", "cinquante", "soixante", "soixante-dix", "quatre-vingt", "quatre-vingt-dix"		
	};
	
	private static final String NEGATIVE = "négatifs";
	private static final String ZERO = "zéro";
	private static final String HUNDRED = "cent";
	private static final String THOUSAND = "mille";
	private static final String MILLION = "million";
	private static final String BILLION = "milliard";
	private static final String TRILLION = "trillion";

	/**
	 * @see com.ijuru.imibare.renderer.Renderer#render(int, int)
	 */
	@Override
	public String render(long number, int clazz) {
		if (number == 0)
			return ZERO;
		
		// Break down number into bases used by French
		DecimalBases bases = new DecimalBases(number, true);
		
		// Calculate spoken components from each base
		List<String> components = new ArrayList<String>();
		components.add(makeComponent(TRILLION, bases.trillions));
		components.add(makeComponent(BILLION, bases.billions));
		components.add(makeComponent(MILLION, bases.millions));
		components.add(makeComponent(THOUSAND, bases.thousands));
		components.add(makeComponent(HUNDRED, bases.hundreds));
		
		if (bases.tens == 0) {
			if (bases.ones == 1)
				components.add(ONE[clazz]);
			else
				components.add(ONES[bases.ones]);
		}
		else if (bases.tens == 1) {
			components.add(TEENS[bases.ones]);
		}
		else {
			if (bases.ones == 1)
				components.add(TENS[bases.tens] + CONJ_MAJOR + ONE[clazz]);
			else
				components.add(TENS[bases.tens] + CONJ_MINOR + ONES[bases.ones]);
		}
				
		// Join components using conjunctions
		// TODO negative adj needs to agree with singular/plural
		return join(components) + (bases.negative ? " " + NEGATIVE : "");
	}
	
	/**
	 * Makes a component of the spoken form
	 * @param base the base, e.g. thousand, million
	 * @param count the count for that base
	 * @return the spoken form
	 */
	protected String makeComponent(String base, int count) {
		if (count == 0)
			return "";
		return render(count, 0) + " " + base;
	}
	
	/**
	 * Joins components into a grammatically correct phrase
	 * @param components the components
	 * @return the phrase
	 */
	protected String join(List<String> components) {	
		if (components.size() == 0)
			return "";
		
		Stack<String> comps = new Stack<String>();
		for (String component : components)
			comps.add(component);
		
		// Join every but tens with spaces
		String compMinor = comps.pop();
		String compMajor = Utils.join(Utils.removeEmpty(comps), " ");		
		
		List<String> parts = new ArrayList<String>();
		parts.add(compMajor);
		parts.add(compMinor);
		
		return Utils.join(Utils.removeEmpty(parts), CONJ_MAJOR);
	}
}
