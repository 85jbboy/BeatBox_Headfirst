package ch13_Swing;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panel1 {
	
	public static void main(String[] args) {
		Panel1 gui = new Panel1();
		gui.go();
	}
	
	public void go() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setBackground(Color.pink);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	
		JButton button = new JButton("shock me~");
		JButton buttonTwo = new JButton("bliss");
		JButton buttonThree = new JButton("third button");
		
//		Font bigFont = new Font("serif", Font.BOLD, 23);
//		button.setFont(bigFont);
		
		panel.add(button);
		panel.add(buttonTwo);
		panel.add(buttonThree);
		
		frame.getContentPane().add(BorderLayout.EAST, panel);
		frame.setSize(500, 500);
		frame.setVisible(true);

	}
}
