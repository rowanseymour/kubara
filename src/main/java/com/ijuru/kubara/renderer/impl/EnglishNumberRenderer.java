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

package com.ijuru.kubara.renderer.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Stack;

import com.ijuru.kubara.DecimalBases;
import com.ijuru.kubara.RendererUtils;
import com.ijuru.kubara.lang.NounClassification;
import com.ijuru.kubara.renderer.AbstractNumberRenderer;
import com.ijuru.kubara.renderer.NumberRenderer;

/**
 * Number renderer for English language
 */
public class EnglishNumberRenderer extends AbstractNumberRenderer {
	
	private static final String CONJ_COMPONENT = " ";
	private static final String CONJ_PART = " and ";
	
	private static final String[] ONES = {
		"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"    
	};
	
	private static final String[] TEENS = {
		"", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"		
	};
	
	private static final String[] TENS = {
		"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"		
	};
	
	private static final String NEGATIVE = "negative";
	private static final String ZERO = "zero";
	private static final String HUNDRED = "hundred";
	private static final String THOUSAND = "thousand";
	private static final String MILLION = "million";
	private static final String BILLION = "billion";
	private static final String TRILLION = "trillion";

	/**
	 * @see NumberRenderer#getLocale()
	 */
	@Override
	public Locale getLocale() {
		return Locale.of("en");
	}

	/**
	 * @see NumberRenderer#getSupportedNounClassifications()
	 */
	@Override
	public List<NounClassification> getSupportedNounClassifications() {
		return Collections.emptyList();
	}

	/**
	 * @see AbstractNumberRenderer#renderInternal(long, com.ijuru.kubara.lang.NounClassification)
	 */
	@Override
	public String renderInternal(long number, NounClassification classification) {
		if (number == 0)
			return ZERO;
		
		// Break down number into bases used by English
		DecimalBases bases = new DecimalBases(number, true);
		
		// Calculate spoken components from each base
		List<String> components = new ArrayList<String>();
		components.add(makeComponent(TRILLION, bases.trillions));
		components.add(makeComponent(BILLION, bases.billions));
		components.add(makeComponent(MILLION, bases.millions));
		components.add(makeComponent(THOUSAND, bases.thousands));
		components.add(makeComponent(HUNDRED, bases.hundreds));
		
		if (bases.tens == 1) {
			components.add(TEENS[bases.ones]);
			components.add("");
		}
		else {
			components.add(TENS[bases.tens]);
			components.add(ONES[bases.ones]);
		}
				
		// Join components using English conjunctions
		return (bases.negative ? NEGATIVE + " " : "") + join(components);
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
		return render(count, null) + CONJ_COMPONENT + base;
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
		
		// Join tens and ones
		String ones = comps.pop();
		String tens = comps.pop();
		String compMinor = (tens + CONJ_COMPONENT + ones).trim();
		
		// Join the other components
		String compMajor = RendererUtils.join(RendererUtils.removeEmpty(comps), CONJ_COMPONENT);
		
		List<String> parts = new ArrayList<String>();
		parts.add(compMajor);
		parts.add(compMinor);
		
		return RendererUtils.join(RendererUtils.removeEmpty(parts), CONJ_PART);
	}

	/**
	 * @see AbstractNumberRenderer#getZeroWord(com.ijuru.kubara.lang.NounClassification)
	 */
	@Override
	protected String getZeroWord(NounClassification classification) {
		return ZERO;
	}
}
