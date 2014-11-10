package edu.cmu.sphinx.demo.calculator0701;

public class Parser {
	public static final int PLUS = 1;
	public static final int MINUS = 2;
	public static final int DIVIDE = 3;
	public static final int MULTIPLY = 4;
	public static final int LOG = 5;
	public static final int POWER = 6;
	public static final int SQUARE = 7;
	public static final int CUBE = 8;

	private int command;
	public int getCommand() {
		return command;
	}
	public double[] getParsedArgs() {
		return parsedArgs;
	}
	private double[] parsedArgs;

	public Parser(String statement) {
		String[] args;
		if (statement.contains("plus")) {
			args = statement.split("plus");
			this.command = PLUS;
		} else if (statement.contains("minus")) {
			args = statement.split("minus");
			this.command = MINUS;
		} else if (statement.contains("multiply")) {
			args = statement.split("multiply");
			this.command = MULTIPLY;
		} else if (statement.contains("power")) {
			args = statement.split("power");
			this.command = POWER;
		} else if (statement.contains("log")) {
			args = statement.split("log");
			this.command = LOG;
		} else if (statement.contains("divide")) {
			args = statement.split("divide");
			this.command = DIVIDE;
		} else if (statement.contains("squared")) {
			args = statement.split("squared");
			this.command = SQUARE;
		} else if (statement.contains("cubed")) {
			args = statement.split("cubed");
			this.command = CUBE;
		} else {
			throw new ArithmeticException("Statement: '" + statement
					+ "' does not have a valid command");
		}
		this.parseArgs(args);
	}
	public void parseArgs(String [] args) {
		parsedArgs = new double[args.length];
		for (int i = 0; i<args.length; i++) {
			if (args[i].contains("e")) parsedArgs[i] = 2.71828;
			else if (args[i].contains("pi")) parsedArgs[i] = 3.1415;
			else parsedArgs[i] = convertToInt(args[i]);
		}
	}
	public static int convertToInt(String number) {
		return 1;
	}
}
