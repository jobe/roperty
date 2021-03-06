/*
 * Roperty - An advanced property management and retrival system
 * Copyright (C) 2013 PARSHIP GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.parship.roperty;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;


/**
 * @author mfinsterwalder
 * @since 2013-05-15 15:26
 */
public class MapBackedDomainResolverTest {

	private MapBackedDomainResolver resolver = new MapBackedDomainResolver().set("dom1", "val1").set("dom2", "val2");

	@Test
	public void setAndGetDomainValues() {
		assertThat(resolver.getDomainValue("dom1"), is("val1"));
	}

	@Test
	public void setAndGetActiveChangeSets() {
		resolver.addActiveChangeSets("CS1", "CS2");
		assertThat(resolver.getActiveChangeSets(), containsInAnyOrder("CS1", "CS2"));
		resolver.addActiveChangeSets("CS3");
		assertThat(resolver.getActiveChangeSets(), containsInAnyOrder("CS1", "CS2", "CS3"));
	}

	@Test
	public void toStringTest() {
		assertThat(resolver.toString(), is("com.parship.roperty.MapBackedDomainResolver with {dom1=val1, dom2=val2}"));
	}
}
