package edu.cmu.sphinx.demo.calculator0701;

public class Solver {
	private static double lastResult;
	private static double lastSavedResult;
	public static boolean hasSavedResult;
	public static boolean hasResult;

	public static String solve(String statement) {
		try {
			lastResult = calculate(statement);
			hasResult = true;
			return "" + lastResult;
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public static double calculate(String statement) throws Exception {
		Parser p = new Parser(statement.toLowerCase());
		switch (p.getCommand()) {
		case Parser.CUBE:
			return Math.pow(p.getParsedArgs()[0], 3);
		case Parser.SQUARE:
			return Math.pow(p.getParsedArgs()[0], 2);
		case Parser.POWER:
			return Math.pow(p.getParsedArgs()[0], p.getParsedArgs()[1]);
		case Parser.LOG:
			if (p.getParsedArgs().length > 1) {
				return Math.log(p.getParsedArgs()[0]);
			} else {
				return Math.log(p.getParsedArgs()[0])
						/ Math.log(p.getParsedArgs()[1]);
			}
		case Parser.MINUS:
			return p.getParsedArgs()[0] - p.getParsedArgs()[1];
		case Parser.PLUS:
			return p.getParsedArgs()[0] + p.getParsedArgs()[1];
		case Parser.MULTIPLY:
			return p.getParsedArgs()[0] * p.getParsedArgs()[1];
		case Parser.DIVIDE:
			return p.getParsedArgs()[0] / p.getParsedArgs()[1];
		case Parser.SAVE:
			if (hasResult) {
				lastSavedResult = lastResult;
				hasSavedResult = true;
				return lastResult;
			} else {
				throw new Exception("You don't have anything to save yet");
			}
		case Parser.RESTORE:
			if (hasSavedResult)
				return lastSavedResult;
			else
				throw new Exception("You have not saved any result yet");
		}
		throw new Exception("Operation not valid");
	}
}
