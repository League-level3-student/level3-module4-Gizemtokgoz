package _03_Hangman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman implements KeyListener{
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	String letterPressed = "";
	String firstWord = "";
	String underscores = "";

	public static void main(String[] args) {
		new Hangman().start();
	}
	
	void start() {
		frame.add(label);
		frame.addKeyListener(this);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Stack<String> words = new Stack<String>();
		String number = JOptionPane.showInputDialog("Enter the number of words to guess (1-100)");
		int num = Integer.parseInt(number);
		
		for (int i = 0; i < num; i++) {
			words.push(Utilities.readRandomLineFromFile("dictionary.txt"));
		}
		
		String firstWord = words.pop();
		for (int i = 0; i < firstWord.length(); i++) {
			underscores += "_";
		}
		label.setText(underscores);
		frame.pack();
		
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		char kc = e.getKeyChar();
		System.out.println(kc);
		
		if (firstWord.contains(kc + "")) {
			underscores = firstWord.replace(underscores, kc + "");
		}
		label.setText(underscores);
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
