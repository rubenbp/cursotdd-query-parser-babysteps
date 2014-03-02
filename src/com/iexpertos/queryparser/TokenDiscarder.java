package com.iexpertos.queryparser;

import java.util.ArrayList;
import java.util.List;

public class TokenDiscarder {
	
	public List<String> discard(List<String> allTokens) {
		List<String> result = new ArrayList<String>();
		
		for(String token : allTokens) {
			if (isDisposable(token)) continue;
			
			result.add(token);
		}
		return result;
	}
	
	public boolean isDisposable(String token) {
		return isNumber(token) || isPreposition(token) || token.isEmpty();
	}

	private boolean isPreposition(String token) {
		return token.equals("on");
	}
	
	private boolean isNumber(String token) {
		try {
			Integer.parseInt(token);
			return true;
		} catch(NumberFormatException ex) {
			return false;
		}
	}
}
