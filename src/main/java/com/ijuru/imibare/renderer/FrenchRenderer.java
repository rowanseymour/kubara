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
import com.ijuru.imibare.lang.Gender;
import com.ijuru.imibare.lang.Noun;
import com.ijuru.imibare.lang.NounAttributes;

/**
 * Number renderer for French language
 */
public class FrenchRenderer implements Renderer {
	
	private static final String[] ONES = {
		"", "un", "deux", "trois", "quatre", "cinq", "six", "sept", "huit", "neuf", 
		"dix", "onze", "douze", "treize", "quatorze", "quinze", "seize", "dix-sept", "dix-huit", "dix-neuf",
		"vingt", "vingt et un", "vingt-deux", "vingt-trois", "vingt-quatre", "vingt-cinq", "vingt-six", "vingt-sept", "vingt-huit", "vingt-neuf",
		"trente", "trente et un", "trente-deux", "trente-trois", "trente-quatre", "trente-cinq", "trente-six", "trente-sept", "trente-huit", "trente-neuf",
		"quarante", "quarante et un", "quarante-deux", "quarante-trois", "quarante-quatre", "quarante-cinq", "quarante-six", "quarante-sept", "quarante-huit", "quarante-neuf",
		"cinquante", "cinquante et un", "cinquante-deux", "cinquante-trois", "cinquante-quatre", "cinquante-cinq", "cinquante-six", "cinquante-sept", "cinquante-huit", "cinquante-neuf",
		"soixante", "soixante et un", "soixante-deux", "soixante-trois", "soixante-quatre", "soixante-cinq", "soixante-six", "soixante-sept", "soixante-huit", "soixante-neuf",
		"soixante-dix", "soixante et onze", "soixante-douze", "soixante-treize", "soixante-quatorze", "soixante-quinze", "soixante-seize", "soixante-dix-sept", "soixante-dix-huit", "soixante-dix-neuf",
		"quatre-vingt", "quatre-vingt et un", "quatre-vingt-deux", "quatre-vingt-trois", "quatre-vingt-quatre", "quatre-vingt-cinq", "quatre-vingt-six", "quatre-vingt-sept", "quatre-vingt-huit", "quatre-vingt-neuf",
		"quatre-vingt-dix", "quatre-vingt-onze", "quatre-vingt-douze", "quatre-vingt-treize", "quatre-vingt-quatorze", "quatre-vingt-quinze", "quatre-vingt-seize", "quatre-vingt-dix-sept", "quatre-vingt-dix-huit", "quatre-vingt-dix-neuf"
	};
	
	private static final String ZERO = "zéro";
	private static final String NEGATIVE = "négatifs";
	private static final Noun HUNDRED = new Noun("cent", "cent");
	private static final Noun THOUSAND = new Noun("mille", "mille");
	private static final Noun MILLION = new Noun("million", "millions");
	private static final Noun BILLION = new Noun("milliard", "milliards");
	private static final Noun TRILLION = new Noun("trillion", "trillions");

	/**
	 * @see com.ijuru.imibare.renderer.Renderer#render(int, NounAttributes)
	 */
	@Override
	public String render(long number, NounAttributes attributes) {
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
		
		// If cent is not followed by another number then add s
		int upTo100 = bases.tens * 10 + bases.ones;
		boolean addS = bases.hundreds > 0 && upTo100 == 0;
		components.add(makeComponent(HUNDRED, bases.hundreds) + (addS ? "s" : ""));
		
		boolean feminize = attributes != null && attributes.getGender() == Gender.FEMALE && bases.ones == 1;
		
		components.add(ONES[upTo100] + (feminize ? "e" : ""));
				
		// Join components
		return join(components) + (bases.negative ? " " + NEGATIVE : "");
	}
	
	/**
	 * Makes a component of the spoken form
	 * @param base the base, e.g. thousand, million
	 * @param count the count for that base
	 * @return the spoken form
	 */
	protected String makeComponent(Noun base, int count) {
		if (count == 0)
			return "";
		// Don't put un in front of cent or mille
		else if (count == 1 && (base == HUNDRED || base == THOUSAND))
			return base.getSingularForm();
		// But do put in front of million etc
		else if (count == 1)
			return render(count, null) + " " + base.getSingularForm();
		
		return render(count, null) + " " + base.getPluralForm();
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
		
		return Utils.join(Utils.removeEmpty(parts), " ");
	}
}
