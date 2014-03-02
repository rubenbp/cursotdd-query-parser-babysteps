package com.iexpertos.queryparser;

import java.util.ArrayList;
import java.util.List;

public class Parser {
	
	private Tokenizer tokenizer;
	
	public Parser(Tokenizer tokenizer) {
		this.tokenizer = tokenizer;
	}
	
	public List<String> parse(String query) {
		List<String> result = new ArrayList<String>();
		TokenDiscarder tokenDiscarder = new TokenDiscarder();
		
		for(String token : tokenizer.tokenize(query)) {
			if (tokenDiscarder.isDisposable(token)) continue;
			
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
