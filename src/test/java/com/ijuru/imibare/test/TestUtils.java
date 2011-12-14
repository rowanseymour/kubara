package com.ijuru.imibare.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import junit.framework.Assert;

import com.ijuru.imibare.renderer.Renderer;

public class TestUtils {
	/**
	 * Runs test cases from a CSV file
	 * @param path the path of the file
	 * @param renderer the renderer
	 * @throws IOException
	 */
	public static void runCases(String path, Renderer renderer) throws IOException {		
		InputStream stream = TestUtils.class.getResourceAsStream(path);
		BufferedReader in = new BufferedReader(new InputStreamReader(stream));
		
		String line = in.readLine();
		while (line != null) {
			if (line.trim().length() > 0 && line.charAt(0) != '#') {
				String[] parts = line.trim().split(",");
				int number = Integer.parseInt(parts[0].trim());
				int clazz = Integer.parseInt(parts[1].trim());
				String result = parts[2].trim();
				
				Assert.assertEquals(result, renderer.render(number, clazz));
			}
			
			line = in.readLine();
		}
		
		in.close();	
	}
}
