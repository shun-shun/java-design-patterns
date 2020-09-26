package interpreter;

import java.util.StringTokenizer;

public class Context {

	private StringTokenizer tokenizer;
	private String currentToken;

	public Context(String text) {
		tokenizer = new StringTokenizer(text);
		nextToken();
	}

	public void skipToken(String token) throws ParseException{
		if (!token.equals(currentToken)) {
			throw new ParseException("Warning: " + token + " is expected, but " + currentToken + " is found.");
		}
		nextToken();
	}

	public String currentToken() {
		return currentToken;
	}

	public String nextToken() {
		if (tokenizer.hasMoreTokens()) {
			currentToken = tokenizer.nextToken();
		} else {
			currentToken = null;
		}
		return currentToken;
	}

	public int currentNumber() throws ParseException {
		int number = 0;
		try {
			number = Integer.parseInt(currentToken);
		} catch (NumberFormatException e) {
			throw new ParseException("warning; " + e);
		}
		return number;
	}

}
