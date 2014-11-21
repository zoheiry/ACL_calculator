package edu.cmu.sphinx.demo.calculator0701;

import java.util.Arrays;
import java.util.List;

public class Parser {
	public static final int PLUS = 1;
	public static final int MINUS = 2;
	public static final int DIVIDE = 3;
	public static final int MULTIPLY = 4;
	public static final int LOG = 5;
	public static final int POWER = 6;
	public static final int SQUARE = 7;
	public static final int CUBE = 8;
	public static final int SAVE = 9;
	public static final int RESTORE = 10;

	private int command;

	public int getCommand() {
		return command;
	}

	public double[] getParsedArgs() {
		return parsedArgs;
	}

	private double[] parsedArgs;

	public Parser(String statement) throws Exception {
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
			if (args[0].contains("base")) {
				args = args[0].split("base");
			}
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
		} else if (statement.contains("save")) {
			args = new String[0];
			this.command = SAVE;
		} else if (statement.contains("restore")) {
			args = new String[0];
			this.command = RESTORE;
		} else {
			throw new ArithmeticException("Statement: '" + statement
					+ "' does not have a valid command");
		}
		this.parseArgs(args);
	}

	public void parseArgs(String[] args) throws Exception {
		parsedArgs = new double[args.length];
		for (int i = 0; i < args.length; i++) {
			if (args[i].trim().equalsIgnoreCase("e"))
				parsedArgs[i] = 2.71828;
			else if (args[i].trim().equalsIgnoreCase("pi"))
				parsedArgs[i] = 3.1415;
			else
				parsedArgs[i] = convertToInt(args[i].trim());
		}
	}

	public static long convertToInt(String input) throws Exception {
		String[] digits = { "zero", "one", "two", "three", "four", "five",
				"six", "seven", "eight", "nine" };
		String[] testArray = input.split(" ");
		String digitResult = "";
		boolean allThere = true;
		for (int i = 0; i < testArray.length; i++) {
			boolean found = false;
			for (int j = 0; j < digits.length; j++) {
				if (testArray[i].equals(digits[j])) {
					digitResult += j;
					found = true;
				}
			}
			if (!found) {
				allThere = false;
				break;
			}
		}
		if (allThere) {
			// System.out.println(digitResult);
			return Integer.parseInt(digitResult);
		}

		boolean isValidInput = true;
		long result = 0;
		long finalResult = 0;
		List<String> allowedStrings = Arrays.asList("zero", "one", "two",
				"three", "four", "five", "six", "seven", "eight", "nine",
				"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
				"sixteen", "seventeen", "eighteen", "nineteen", "twenty",
				"thirty", "forty", "fifty", "sixty", "seventy", "eighty",
				"ninety", "hundred", "thousand", "million", "billion",
				"trillion");

		// String input="One hundred two thousand and thirty four";

		if (input != null && input.length() > 0) {
			input = input.replaceAll("-", " ");
			input = input.toLowerCase().replaceAll(" and", " ");
			String[] splittedParts = input.trim().split("\\s+");

			for (String str : splittedParts) {
				if (!allowedStrings.contains(str)) {
					isValidInput = false;
					System.out.println("Invalid word found : " + str);
					break;
				}
			}
			if (isValidInput) {
				for (String str : splittedParts) {
					if (str.equalsIgnoreCase("zero")) {
						result += 0;
					} else if (str.equalsIgnoreCase("one")) {
						result += 1;
					} else if (str.equalsIgnoreCase("two")) {
						result += 2;
					} else if (str.equalsIgnoreCase("three")) {
						result += 3;
					} else if (str.equalsIgnoreCase("four")) {
						result += 4;
					} else if (str.equalsIgnoreCase("five")) {
						result += 5;
					} else if (str.equalsIgnoreCase("six")) {
						result += 6;
					} else if (str.equalsIgnoreCase("seven")) {
						result += 7;
					} else if (str.equalsIgnoreCase("eight")) {
						result += 8;
					} else if (str.equalsIgnoreCase("nine")) {
						result += 9;
					} else if (str.equalsIgnoreCase("ten")) {
						result += 10;
					} else if (str.equalsIgnoreCase("eleven")) {
						result += 11;
					} else if (str.equalsIgnoreCase("twelve")) {
						result += 12;
					} else if (str.equalsIgnoreCase("thirteen")) {
						result += 13;
					} else if (str.equalsIgnoreCase("fourteen")) {
						result += 14;
					} else if (str.equalsIgnoreCase("fifteen")) {
						result += 15;
					} else if (str.equalsIgnoreCase("sixteen")) {
						result += 16;
					} else if (str.equalsIgnoreCase("seventeen")) {
						result += 17;
					} else if (str.equalsIgnoreCase("eighteen")) {
						result += 18;
					} else if (str.equalsIgnoreCase("nineteen")) {
						result += 19;
					} else if (str.equalsIgnoreCase("twenty")) {
						result += 20;
					} else if (str.equalsIgnoreCase("thirty")) {
						result += 30;
					} else if (str.equalsIgnoreCase("forty")) {
						result += 40;
					} else if (str.equalsIgnoreCase("fifty")) {
						result += 50;
					} else if (str.equalsIgnoreCase("sixty")) {
						result += 60;
					} else if (str.equalsIgnoreCase("seventy")) {
						result += 70;
					} else if (str.equalsIgnoreCase("eighty")) {
						result += 80;
					} else if (str.equalsIgnoreCase("ninety")) {
						result += 90;
					} else if (str.equalsIgnoreCase("hundred")) {
						result *= 100;
					} else if (str.equalsIgnoreCase("thousand")) {
						result *= 1000;
						finalResult += result;
						result = 0;
					} else if (str.equalsIgnoreCase("million")) {
						result *= 1000000;
						finalResult += result;
						result = 0;
					} else if (str.equalsIgnoreCase("billion")) {
						result *= 1000000000;
						finalResult += result;
						result = 0;
					} else if (str.equalsIgnoreCase("trillion")) {
						result *= 1000000000000L;
						finalResult += result;
						result = 0;
					}
				}

				finalResult += result;
				result = 0;
				// System.out.println(finalResult);
				return finalResult;
			}
		}
		throw new Exception("Invalid number: " + input);
	}

	public static void main(String[] args) throws Exception {
		convertToInt("fifty five thousand three hundred and thirty three");
	}
}
