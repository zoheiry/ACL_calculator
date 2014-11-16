package edu.cmu.sphinx.demo.calculator0701;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Gui extends JFrame{
	
	JTextArea calcScreen;
	
	public Gui() {
		super("Caluclator");
		getContentPane().setBackground(new Color(154, 205, 50));
		getContentPane().setLayout(null);
		
		calcScreen = new JTextArea();
		calcScreen.setBounds(6, 6, 465, 96);
		getContentPane().add(calcScreen);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(6, 114, 217, 140);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton buttonOne = new JButton("1");
		buttonOne.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				appendInput("One");
			}
		});
		buttonOne.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		buttonOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(buttonOne);
		
		JButton buttonTwo = new JButton("2");
		buttonTwo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				appendInput("Two");
			}
		});
		buttonTwo.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		panel.add(buttonTwo);
		
		JButton buttonThree = new JButton("3");
		buttonThree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				appendInput("Three");
			}
		});
		buttonThree.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		panel.add(buttonThree);
		
		JButton buttonFour = new JButton("4");
		buttonFour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				appendInput("Four");
			}
		});
		buttonFour.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		panel.add(buttonFour);
		
		JButton buttonFive = new JButton("5");
		buttonFive.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				appendInput("Five");
			}
		});
		buttonFive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonFive.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		panel.add(buttonFive);
		
		JButton buttonSix = new JButton("6");
		buttonSix.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				appendInput("Six");
			}
		});
		buttonSix.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		panel.add(buttonSix);
		
		JButton buttonSeven = new JButton("7");
		buttonSeven.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				appendInput("Seven");
			}
		});
		buttonSeven.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		panel.add(buttonSeven);
		
		JButton buttonEight = new JButton("8");
		buttonEight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				appendInput("Eight");
			}
		});
		buttonEight.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		panel.add(buttonEight);
		
		JButton buttonNine = new JButton("9");
		buttonNine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				appendInput("Nine");
			}
		});
		buttonNine.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		panel.add(buttonNine);
		
		JButton buttonZero = new JButton("0");
		buttonZero.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				appendInput("Zero");
			}
		});
		
		JButton button_pi = new JButton("π");
		button_pi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				appendInput("Pi");
			}
		});
		button_pi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_pi.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		panel.add(button_pi);
		buttonZero.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		panel.add(buttonZero);
		
		JButton button_e = new JButton("e");
		button_e.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				appendInput("e");
			}
		});
		button_e.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		panel.add(button_e);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 128));
		panel_1.setBounds(228, 114, 134, 140);
		getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(3, 2, 0, 0));
		
		JButton btnNewButton_2 = new JButton("+");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				appendInput("plus");
			}
		});
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("-");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				appendInput("minus");
			}
		});
		btnNewButton_3.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_5 = new JButton("x");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				appendInput("multiply");
			}
		});
		btnNewButton_5.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_4 = new JButton("/");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				appendInput("divide");
			}
		});
		btnNewButton_4.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_6 = new JButton("MR");
		btnNewButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton_6.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(btnNewButton_6);
		
		JButton btnMc = new JButton("MC");
		btnMc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnMc.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		panel_1.add(btnMc);
		
		JButton button_10 = new JButton("=");
		button_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		button_10.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		button_10.setBounds(420, 163, 51, 91);
		getContentPane().add(button_10);
		
		JButton btnAc = new JButton("AC");
		btnAc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calcScreen.setText("");
			}
		});
		btnAc.setBounds(367, 163, 51, 91);
		getContentPane().add(btnAc);
		
		JButton btnSpeak = new JButton("Speak");
		btnSpeak.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnSpeak.setBounds(367, 114, 104, 44);
		getContentPane().add(btnSpeak);
	}
	
	public void appendInput(String inp){
		if(calcScreen.getText().length() == 0)
			calcScreen.setText(inp);
		else
			calcScreen.setText(calcScreen.getText() + " " + inp);
	}
	
	public static void main(String[]args){
		Gui g = new Gui();
		g.setSize(475, 300);
		g.setVisible(true);
	}
}


