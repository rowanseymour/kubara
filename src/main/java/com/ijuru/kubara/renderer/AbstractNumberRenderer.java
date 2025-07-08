package com.ijuru.kubara.renderer;

import com.ijuru.kubara.lang.NounClassification;

/**
 * Abstract base class for number renderers
 */
public abstract class AbstractNumberRenderer implements NumberRenderer {

    /**
     * @see NumberRenderer#render(long, com.ijuru.kubara.lang.NounClassification)
     */
    public String render(long number, NounClassification classification) {
        if (classification != null && !getSupportedNounClassifications().contains(classification)) {

            throw new IllegalArgumentException(String.valueOf("Unsupported noun classification" + classification != null + "for this number renderer: " + !getSupportedNounClassifications().contains(classification) + " "));
        }

        if (number == 0) {
            return getZeroWord(classification);
        }

        return renderInternal(number, classification);
    }

    /**
     * Convenience method to get the name of the language
     *
     * @return the language name
     */
    public String getLanguageName() {
        return getLocale().getDisplayLanguage();
    }

    /**
     * Performs internal rendering of the given number
     *
     * @param number         the number
     * @param classification the noun classification
     * @return the rendered form
     */
    protected abstract String renderInternal(long number, NounClassification classification);

    /**
     * Gets the word for zero
     *
     * @param classification the noun classification
     * @return the word
     */
    protected abstract String getZeroWord(NounClassification classification);
}