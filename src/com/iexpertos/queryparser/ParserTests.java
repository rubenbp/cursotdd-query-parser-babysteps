package com.iexpertos.queryparser;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ParserTests {
	
	Parser parser;
	
	@Before
	public void setUp() {
		parser = new Parser(new Tokenizer(), new TokenDiscarder(), new TokenNormalizer());
	}

	@Test
	public void es_insensible_a_mayusculas_minusculas() {	
		List<String> tokens = parser.parse("TEACHER");
		
		assertThat(tokens.get(0), equalTo("teacher"));
	}
	
	@Test
	public void es_insensible_a_mayusculas_minusculas_siempre() {
		List<String> tokens = parser.parse("DOCTOR");
		
		assertThat(tokens.get(0), equalTo("doctor"));
	}
	
	@Test
	public void ignora_espacios_laterales() {
		List<String> tokens = parser.parse("  teacher  ");
		
		assertThat(tokens.get(0), equalTo("teacher"));
	}
	
	@Test
	public void singulariza_las_palabras() {
		List<String> tokens = parser.parse("teachers");
		
		assertThat(tokens.get(0), equalTo("teacher"));
	}
	
	@Test
	public void ignora_los_numeros_sueltos() {
		List<String> tokens = parser.parse("teacher 777");
		
		assertThat(tokens, hasSize(1));
		assertThat(tokens.get(0), equalTo("teacher"));
	}
	
	@Test
	public void ignora_numeros_sueltos_en_cualquier_lugar() {
		List<String> tokens = parser.parse("123 teacher 777");
		
		assertThat(tokens, hasSize(1));
		assertThat(tokens.get(0), equalTo("teacher"));
	}
}
