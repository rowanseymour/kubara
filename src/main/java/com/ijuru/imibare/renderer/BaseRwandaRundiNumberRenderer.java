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

import com.ijuru.imibare.DecimalBases;
import com.ijuru.imibare.RendererUtils;
import com.ijuru.imibare.lang.BantuNoun;
import com.ijuru.imibare.lang.Gender;
import com.ijuru.imibare.lang.NounDescriptor;

/**
 * Abstract base class for number renderers for Rwanda-Rundi family of languages
 */
public abstract class BaseRwandaRundiNumberRenderer implements NumberRenderer {

	private static final String CONJ_BEFORE_CONSONANT = " na ";
	private static final String CONJ_BEFORE_VOWEL = " n'";
	
	/**
	 * @see com.ijuru.imibare.renderer.NumberRenderer#render(long, com.ijuru.imibare.lang.NounDescriptor)
	 */
	@Override
	public String render(long number, NounDescriptor noun) {
		if (number == 0) {
			return getZeroWord();
		}

		int nounClass = noun.getClazz() != null ? noun.getClazz() : 0;
		
		// Break down number into bases used by Kinyarwanda and Kirundi
		DecimalBases bases = new DecimalBases(number, false);
		
		// Calculate spoken components from each base
		List<String> components = new ArrayList<String>();
		components.add(makeComponent(getBillionNoun(), bases.billions));
		components.add(makeComponent(getMillionNoun(), bases.millions));
		components.add(makeComponent(getThousandNoun(), bases.thousands));
		components.add(getHundreds()[bases.hundreds]);
		components.add(getTens()[bases.tens]);
		components.add(getOnes()[nounClass][bases.ones]);
		
		// Join components using conjunctions
		return (bases.negative ? getNegativeWord() + " " : "") + join(components);
	}
	
	/**
	 * Makes a component of the spoken form
	 * @param base the base, e.g. thousands, millions
	 * @param count the count for that base
	 * @return the spoken form
	 */
	protected String makeComponent(BantuNoun base, int count) {
		if (count == 0)
			return "";
		else if (count == 1)
			return base.getSingularForm() + " " + render(count, new NounDescriptor(base.getSingularClazz(), null));
		else
			return base.getPluralForm() + " " + render(count, new NounDescriptor(base.getPluralClazz(), null));
	}

	/**
	 * Joins components into a grammatically correct phrase
	 * @param components the components
	 * @return the phrase
	 */
	protected String join(List<String> components) {
		// Remove empty components
		List<String> nonEmptyComponents = RendererUtils.removeEmpty(components);
		if (nonEmptyComponents.size() == 0)
			return "";
		
		StringBuilder builder = new StringBuilder(nonEmptyComponents.get(0));
		for (int c = 1; c < nonEmptyComponents.size(); ++c) {
			String component = nonEmptyComponents.get(c);
			if (RendererUtils.isVowel(component.charAt(0)))
				builder.append(CONJ_BEFORE_VOWEL);
			else
				builder.append(CONJ_BEFORE_CONSONANT);
				
			builder.append(component);
		}
		
		return builder.toString();
	}
	
	/**
	 * Get the array of numbers 0...9 for each noun class
	 * @return the array of numbers
	 */
	protected abstract String[][] getOnes();
	
	/**
	 * Gets the array of numbers 0, 10... 90
	 * @returng the array of numbers
	 */
	protected abstract String[] getTens();
	
	/**
	 * Gets the array of numbers 0, 100... 900
	 * @return the array of numbers
	 */
	protected abstract String[] getHundreds();
	
	/**
	 * Gets the word used for negative
	 * @return the noun
	 */
	protected abstract String getNegativeWord();
	
	/**
	 * Gets the word used for zero
	 * @return the noun
	 */
	protected abstract String getZeroWord();
	
	/**
	 * Gets the noun used for thousands
	 * @return the noun
	 */
	protected abstract BantuNoun getThousandNoun();
	
	/**
	 * Gets the noun used for millions
	 * @return the noun
	 */
	protected abstract BantuNoun getMillionNoun();
	
	/**
	 * Gets the noun used for billions
	 * @return the noun
	 */
	protected abstract BantuNoun getBillionNoun();
}