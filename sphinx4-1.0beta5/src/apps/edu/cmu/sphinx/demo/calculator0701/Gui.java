package edu.cmu.sphinx.demo.calculator0701;

import javax.swing.JFrame;



public class Gui extends JFrame{
	
	JTextField calcScreen;
	JPanel operations_panel;
	JPanel number_panel;
	JButton btnSpeak, buttonEqual, btnAc, btnMr, btnMs ;
	String lastStoredResult = "", result = "";
	boolean speaking = false;
	private JTextField textField;
	public Gui() {
		super("Caluclator");
		getContentPane().setBackground(new Color(154, 205, 50));
		getContentPane().setLayout(null);
		
		calcScreen = new JTextField();
		calcScreen.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				buttonEqual.setEnabled(valid());
				repaint();
			}
		});

		calcScreen.setBounds(6, 6, 241, 96);
		getContentPane().add(calcScreen);
		
		number_panel = new JPanel();
		number_panel.setBackground(Color.GRAY);
		number_panel.setBounds(6, 114, 217, 140);
		getContentPane().add(number_panel);
		number_panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton buttonOne = new JButton("1");
		buttonOne.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		buttonOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appendInput("One");
			}
		});
		number_panel.add(buttonOne);
		
		JButton buttonTwo = new JButton("2");
		buttonTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appendInput("Two");
			}
		});
		buttonTwo.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		number_panel.add(buttonTwo);
		
		JButton buttonThree = new JButton("3");
		buttonThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appendInput("Three");
			}
		});
		buttonThree.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		number_panel.add(buttonThree);
		
		JButton buttonFour = new JButton("4");
		buttonFour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appendInput("Four");
			}
		});
		buttonFour.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		number_panel.add(buttonFour);
		
		JButton buttonFive = new JButton("5");
		buttonFive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appendInput("Five");
			}
		});
		buttonFive.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		number_panel.add(buttonFive);
		
		JButton buttonSix = new JButton("6");
		buttonSix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appendInput("Six");
			}
		});
		buttonSix.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		number_panel.add(buttonSix);
		
		JButton buttonSeven = new JButton("7");
		buttonSeven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appendInput("Seven");
			}
		});
		buttonSeven.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		number_panel.add(buttonSeven);
		
		JButton buttonEight = new JButton("8");
		buttonEight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appendInput("Eight");
			}
		});
		buttonEight.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		number_panel.add(buttonEight);
		
		JButton buttonNine = new JButton("9");
		buttonNine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appendInput("Nine");
			}
		});
		buttonNine.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		number_panel.add(buttonNine);
		
		JButton buttonZero = new JButton("0");
		buttonZero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appendInput("Zero");
			}
		});
		
		JButton button_pi = new JButton("π");
		button_pi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appendInput("Pi");
			}
		});
		button_pi.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		number_panel.add(button_pi);
		buttonZero.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		number_panel.add(buttonZero);
		
		JButton button_e = new JButton("e");
		button_e.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appendInput("e");
			}
		});
		button_e.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		number_panel.add(button_e);
		
		operations_panel = new JPanel();
		operations_panel.setBackground(new Color(128, 128, 128));
		operations_panel.setBounds(228, 114, 134, 140);
		getContentPane().add(operations_panel);
		operations_panel.setLayout(new GridLayout(4, 2, 0, 0));
		
		JButton buttonPlus = new JButton("+");
		buttonPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appendInput("plus");
				enableOperations(false);
			}
		});
		buttonPlus.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		operations_panel.add(buttonPlus);
		
		JButton buttonMinus = new JButton("-");
		buttonMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appendInput("minus");
				enableOperations(false);
			}
		});
		buttonMinus.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		operations_panel.add(buttonMinus);
		
		JButton buttonMultiply = new JButton("x");
		buttonMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appendInput("multiply");
				enableOperations(false);
			}
		});
		buttonMultiply.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		operations_panel.add(buttonMultiply);
		
		JButton buttonDivide = new JButton("/");
		buttonDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appendInput("divide");
				enableOperations(false);
			}
		});
		buttonDivide.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		operations_panel.add(buttonDivide);
		
		btnMr = new JButton("MR");
		btnMr.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnMr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appendInput( lastStoredResult);
			}
		});
		operations_panel.add(btnMr);
		
		btnMs = new JButton("MS");
		btnMs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lastStoredResult = result;
				valid();
			}
		});
		btnMs.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		operations_panel.add(btnMs);
		
		JButton buttonPower = new JButton("^");
		buttonPower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appendInput("power");
			}
		});
		buttonPower.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		operations_panel.add(buttonPower);
		
		JButton buttonLog = new JButton("log");
		buttonLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appendInput("log");
			}
		});
		buttonLog.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		operations_panel.add(buttonLog);
		
		buttonEqual = new JButton("=");
		buttonEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonEqual.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		buttonEqual.setBounds(420, 163, 51, 91);
		getContentPane().add(buttonEqual);
		
		btnAc = new JButton("AC");
		btnAc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcScreen.setText("");
			}
		});
		btnAc.setBounds(367, 163, 51, 91);
		getContentPane().add(btnAc);
		
		btnSpeak = new JButton("Speak");
		btnSpeak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!speaking){
					btnSpeak.setText("stop");
					speaking = true;
					btnAc.setEnabled(false);
					calcScreen.setEditable(false);
					enableOperations(false);
					enableNumbers(false);
				}else{
					btnSpeak.setText("Speak");
					speaking = false;
					buttonEqual.setEnabled(valid());
					calcScreen.setEditable(true);
					enableNumbers(true);
				}
			}
		});
		btnSpeak.setBounds(367, 114, 104, 44);
		getContentPane().add(btnSpeak);
		
		textField = new JTextField();
		textField.setBounds(291, 6, 167, 96);
		getContentPane().add(textField);
		
		JLabel label = new JLabel("=");
		label.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		label.setBounds(259, 51, 20, 16);
		getContentPane().add(label);
		
		this.setSize(475, 290);
		this.setVisible(true);
		this.enableOperations(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void appendInput(String inp){
		if(calcScreen.getText().length() == 0)
			calcScreen.setText(inp);
		else
			calcScreen.setText(calcScreen.getText() + " " + inp);
		buttonEqual.setEnabled(valid());
	}
	
	public void enableOperations(boolean b){
		for( int i = 0; operations_panel.getComponents().length > i ; i++)
			operations_panel.getComponents()[i].setEnabled(b);
		btnMs.setEnabled(result != "");
		btnMr.setEnabled(lastStoredResult != "");
		buttonEqual.setEnabled(false);
		this.repaint();
	}
	public void enableNumbers(boolean b){
		for( int i = 0; number_panel.getComponents().length > i ; i++)
			number_panel.getComponents()[i].setEnabled(b);
		this.repaint();
	}
	public boolean valid(){
		String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "pi", "e", "hundred", "thousand", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};
		String[] operations = {"plus", "minus", "multiply", "divide", "log", "power", "squared"};
		String [] tmp = calcScreen.getText().split(" ");
		boolean has_op = false;
		enableOperations(false);
		if(tmp.length > 0){ // Can not Start with operator
			if(Arrays.asList(operations).contains(tmp[0].toLowerCase()))
				return false;
			if(Arrays.asList(operations).contains(tmp[tmp.length-1].toLowerCase()))
				return false;
		}
		for(int i = 0; i < tmp.length ; i++){ 
			if(Arrays.asList(operations).contains(tmp[i].toLowerCase())) // can contain 1 operator
				if(has_op){ return false; }else{  has_op = true; }	
			// Can contain only numbers or operators
			if(!Arrays.asList(numbers).contains(tmp[i].toLowerCase()) && !Arrays.asList(operations).contains(tmp[i].toLowerCase()))	
				return false;
		}
		enableOperations(tmp.length > 0 && !has_op);
		return true;
	}
	
	public static void main(String[]args){
		Gui g = new Gui();
		
	}
}

