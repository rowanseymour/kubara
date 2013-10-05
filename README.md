#Kubara

This is a library for rendering numbers as text in their spoken forms. So far only it supports English, French, Kinyarwanda and Kirundi.

Thanks to Nkurunziza Ildephonse and Emmanuel Habumuremyi for helping with the Kirundi and Kinyarwanda rendering.

All code is available under GPLv3. Copyright Rowan Seymour 2013.

##Usage

First create a noun attributes object to describe the kind of noun (i.e. class number or gender):

	NounClassification classification = new NounClassification(8);

Then get a renderer instance for the locale (rw, rn, en, fr):

	NumberRenderer renderer = NumberRendererFactory.getRendererByLocale(new Locale("rw"));

Finally render the number as a string:

	renderer.render(123, classification);

... which will return *"ijana na makumyabiri na batatu"*