package com.iexpertos.queryparser;

import java.util.ArrayList;
import java.util.List;

public class Parser {
	
	private Tokenizer tokenizer;
	private TokenDiscarder tokenDiscarder;
	private TokenNormalizer tokenNormalizer;
	
	public Parser(Tokenizer tokenizer, 
				  TokenDiscarder tokenDiscarder, 
				  TokenNormalizer tokenNormalizer) {
		this.tokenizer = tokenizer;
		this.tokenDiscarder = tokenDiscarder;
		this.tokenNormalizer = tokenNormalizer;
	}
	
	public List<String> parse(String query) {
		List<String> result = new ArrayList<String>();

		List<String> tokens = tokenizer.tokenize(query);
		tokens = tokenDiscarder.discard(tokens);
		
		for(String token : tokens) {
			token = tokenNormalizer.normalize(token);
			result.add(token);
		}
		return result;
	}
}
