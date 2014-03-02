package com.iexpertos.queryparser;

import java.util.ArrayList;
import java.util.List;

public class TokenNormalizer {
	
	public List<String> normalize(List<String> tokens) {
		List<String> result = new ArrayList<String>();
		
		for(String token : tokens) {
			result.add(normalize(token));
		}
		
		return result;
	}
	
	public String normalize(String token) {
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
