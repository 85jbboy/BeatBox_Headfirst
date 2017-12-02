package ch12_GUI;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SimpleGui1 {
	public static void main(String[] args) {
	
	JFrame frame = new JFrame();
	JButton button = new JButton("A-yo, what's up, baby");
	
	//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().add(button);
	
	frame.setSize(500, 500);
	frame.setVisible(true);
	}

}
