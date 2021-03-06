package _00_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	Stack<String> rem = new Stack<String>();
	public static void main(String[] args) {
		new _02_TextUndoRedo();
	}

	/*
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look
	 * like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character
	 * is erased from the JLabel.
	 * 
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed,
	 * the top Character is popped off the Stack and added back to the JLabel.
	 */
	_02_TextUndoRedo() {

		frame.setVisible(true);
		frame.add(panel);
		frame.add(label);
		frame.addKeyListener(this);
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
		
		
		System.out.println(e.getKeyCode());
		
		if (e.getKeyCode() == 8) {
			rem.push("" + label.getText().charAt(label.getText().length()-1));
			label.setText(label.getText().substring(0, label.getText().length()-1));
		}
		
		if (e.getKeyCode() == 81) {
			label.setText(label.getText() + rem.pop());
		}
		
		else if(e.getKeyCode() != 8){
			label.setText(label.getText() + kc);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
