package com.iexpertos.queryparser;

import java.util.Arrays;
import java.util.List;

public class Tokenizer {
	
	public List<String> tokenize(String query) {
		query = prepareToTokenize(query);
		return Arrays.asList(query.split(" "));
	}
	
	private String prepareToTokenize(String query) {
		return query.toLowerCase().trim();
	}
}
