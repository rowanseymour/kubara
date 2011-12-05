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

package com.ijuru.imibare.test.renderer;

import junit.framework.TestCase;

import com.ijuru.imibare.renderer.KinyarwandaRenderer;
import com.ijuru.imibare.renderer.Renderer;

/**
 * Test case for EnglishRenderer class
 */
public class KinyarwandaRendererTest extends TestCase {

	public void testRender() {
		Renderer renderer = new KinyarwandaRenderer();
		assertEquals("zeru", renderer.render(0, 0));
		assertEquals("rimwe", renderer.render(1, 0));
		assertEquals("umwe", renderer.render(1, 1));
		assertEquals("cumi na batanu", renderer.render(15, 2));
		assertEquals("makumyabiri n'itatu", renderer.render(23, 4));
		assertEquals("ijana n'atatu", renderer.render(103, 6));
		assertEquals("ijana na mirongo ine na bitanu", renderer.render(145, 8));
		assertEquals("ibihumbi birindwi na magana atandatu na mirongo icyenda n'ebyiri", renderer.render(7692, 10));
		assertEquals("miliyoni umunani n'ibihumbi mirongo ine na birindwi na magana atandatu na mirongo icyenda n'ebyiri", renderer.render(8047692, 10));
		assertEquals("kuramo cumi na kane", renderer.render(-14, 0));
		assertEquals("kuramo igihumbi kimwe na mirongo itandatu na gatanu", renderer.render(-1065, 0));
	}
}
