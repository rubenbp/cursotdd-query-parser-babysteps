package com.iexpertos.queryparser;

import java.util.ArrayList;
import java.util.List;

public class Parser {
	
	public List<String> parse(String query) {
		List<String> result = new ArrayList<String>();
		String token = query.toLowerCase().trim();
		if (token.endsWith("s")) {
			token = token.substring(0, token.length() - 1);
		}
		result.add(token);
		return result;
	}
}
