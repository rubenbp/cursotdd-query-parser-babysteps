package com.iexpertos.queryparser;

import java.util.ArrayList;
import java.util.List;

public class Parser {
	
	private Tokenizer tokenizer;
	private TokenDiscarder tokenDiscarder;
	
	public Parser(Tokenizer tokenizer, TokenDiscarder tokenDiscarder) {
		this.tokenizer = tokenizer;
		this.tokenDiscarder = tokenDiscarder;
	}
	
	public List<String> parse(String query) {
		List<String> result = new ArrayList<String>();

		List<String> tokens = tokenizer.tokenize(query);
		tokens = tokenDiscarder.discard(tokens);
		
		for(String token : tokens) {
			token = normalizingToken(token);
			result.add(token);
		}
		return result;
	}
	
	private String normalizingToken(String token) {
		token = singularizeToken(token);
		return token;
	}

	private String singularizeToken(String token) {
		if (token.endsWith("s")) {
			token = token.substring(0, token.length() - 1);
		}
		return token;
	}
	
	
}
