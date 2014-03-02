package com.iexpertos.queryparser;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ParserTests {

	@Test
	public void es_insensible_a_mayusculas_minusculas() {	
		Parser parser = new Parser();
		List<String> tokens = parser.parse("TEACHER");
		
		assertThat(tokens.get(0), equalTo("teacher"));
	}
	
	@Test
	public void es_insensible_a_mayusculas_minusculas_siempre() {
		Parser parser = new Parser();
		List<String> tokens = parser.parse("DOCTOR");
		
		assertThat(tokens.get(0), equalTo("doctor"));
	}
}
