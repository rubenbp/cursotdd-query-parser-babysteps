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
	public void ignora_numeros_sueltos_en_cualquier_lugar() {
		List<String> tokens = parser.parse("123 teacher 777");
		
		assertThat(tokens, hasSize(1));
		assertThat(tokens.get(0), equalTo("teacher"));
	}
	
	@Test
	public void ignora_la_preposicion_on() {
		List<String> tokens = parser.parse("ruby on rails");
		
		assertThat(tokens, not(hasItem("on")));
	}
	
	@Test
	public void no_se_obtienen_tokens_vacios() {
		List<String> tokens = parser.parse("hello      world");
		
		assertThat(tokens, hasSize(2));
	}
}
