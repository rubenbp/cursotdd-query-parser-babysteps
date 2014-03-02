package com.iexpertos.queryparser;

import java.util.ArrayList;
import java.util.List;

public class Parser {
	
	public List<String> parse(String query) {
		List<String> result = new ArrayList<String>();
		String token = normalizingToken(query);
		result.add(token);
		return result;
	}

	private String normalizingToken(String token) {
		token = token.toLowerCase().trim();
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
