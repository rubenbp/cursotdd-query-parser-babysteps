package com.iexpertos.queryparser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
	
	public List<String> parse(String query) {
		List<String> result = new ArrayList<String>();
		
		for(String token : tokenizeQuery(query)) {
			if (token.equals("777")) continue;
			
			token = normalizingToken(token);
			result.add(token);
		}
		return result;
	}
	
	private List<String> tokenizeQuery(String query) {
		query = prepareQueryToTokenize(query);
		return Arrays.asList(query.split(" "));
	}
	
	private String prepareQueryToTokenize(String query) {
		return query.toLowerCase().trim();
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
