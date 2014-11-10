package edu.cmu.sphinx.demo.calculator0701;

public class Solver {
	public static double calculate(String statement) {
		Parser p = new Parser(statement);
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
				return Math.log(p.getParsedArgs()[0])/Math.log(p.getParsedArgs()[1]);
			}
		case Parser.MINUS:
			return p.getParsedArgs()[0] - p.getParsedArgs()[1];
		case Parser.PLUS:
			return p.getParsedArgs()[0] + p.getParsedArgs()[1];
		case Parser.MULTIPLY:
			return p.getParsedArgs()[0] * p.getParsedArgs()[1];
		case Parser.DIVIDE:
			return p.getParsedArgs()[0] / p.getParsedArgs()[1];
		}
		return 0;
	}
}
