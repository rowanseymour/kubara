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

package com.ijuru.imibare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import junit.framework.Assert;

import com.ijuru.imibare.lang.NounAttributes;
import com.ijuru.imibare.renderer.Renderer;

/**
 * Helper class for unit testing
 */
public class TestUtils {
	/**
	 * Runs test cases from a CSV file
	 * @param path the path of the file
	 * @param renderer the renderer
	 * @throws IOException
	 */
	public static void runCases(String path, Renderer renderer) throws IOException {		
		InputStream stream = TestUtils.class.getResourceAsStream(path);
		BufferedReader in = new BufferedReader(new InputStreamReader(stream, Charset.forName("UTF-8")));
		
		String line = in.readLine();
		while (line != null) {
			if (line.trim().length() > 0 && line.charAt(0) != '#') {
				String[] parts = line.trim().split(",");
				int number = Integer.parseInt(parts[0].trim());
				NounAttributes attributes = NounAttributes.parse(parts[1].trim());
				String result = parts[2].trim();
				
				Assert.assertEquals(result, renderer.render(number, attributes));
			}
			
			line = in.readLine();
		}
		
		in.close();	
	}
}
