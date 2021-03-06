package com.parship.roperty;

import org.junit.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


/**
 * User: mjaeckel
 * Date: 15.11.13
 * Time: 10:47
 */
public class DefaultDomainSpecificValueFactoryTest {

	private final DefaultDomainSpecificValueFactory factory = new DefaultDomainSpecificValueFactory();

	@Test
	public void factoryCreatesCorrectDSVForBaseKey() {
		String value = "value";
		DomainSpecificValue dsv = factory.create(value, null);
		assertThat((String)dsv.getValue(), is(value));
		assertThat(dsv.getPatternStr(), is(""));
	}

	@Test
	public void factoryCreatesCorrectDSVForOverriddenKey() {
		String value = "overriddenValue";

		DomainSpecificValue dsv = factory.create(value, null, "DE", "de_DE");

		assertThat((String)dsv.getValue(), is(value));
		assertThat(dsv.getPatternStr(), is("DE|de_DE|"));
	}

	@Test
	public void factorySetReverseOrderForMoreSpecificValues() {
		String value = "overriddenValue";

		DomainSpecificValue dsv = factory.create(value, null, "DE");
		DomainSpecificValue moreSpecificDsv = factory.create(value, null, "DE", "de_DE");

		assertThat(dsv.compareTo(moreSpecificDsv), greaterThan(0));
	}
}
