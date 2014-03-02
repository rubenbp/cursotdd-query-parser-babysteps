package com.iexpertos.queryparser;

public class TokenDiscarder {
	
	public boolean isDisposable(String token) {
		return isNumber(token);
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
