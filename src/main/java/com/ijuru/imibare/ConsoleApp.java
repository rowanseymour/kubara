package com.ijuru.imibare;

import com.ijuru.imibare.renderer.Renderer;

public class ConsoleApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Print usage message if we have wrong number of arguments
		if (args.length != 2 && args.length != 3) {
			System.out.println("usage: imibare <en|rw|rn> <number> [class]");
			return;
		}
		
		try {
			// Get program arguments
			String lang = args[0];
			long val = Long.parseLong(args[1]);
			int clazz = (args.length == 3) ? Integer.parseInt(args[2]) : 0;
			
			try {
				// Select a renderer based on the specified language
				Renderer renderer = RendererFactory.getRenderer(lang);
				
				// Calculate the result and print it
				System.out.println(renderer.render(val, clazz));
				
			} catch (UnsupportedLanguageException e) {
				System.out.println("error: unsupported language");
				return;
			}	
		}
		catch (NumberFormatException ex) {
			System.out.println("error: invalid number");
			return;
		}
	}

}
