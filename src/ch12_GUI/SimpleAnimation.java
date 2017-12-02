package ch12_GUI;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimpleAnimation {
	
	int x = 70;
	int y = 70;
	
	public static void main(String[] args) {
		SimpleAnimation gui = new SimpleAnimation ();
		gui.go();
	}
	
	public void go() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyDrawPanel2 drawPanel = new MyDrawPanel2();
		
		frame.getContentPane().add(drawPanel);
		frame.setSize(300, 300);
		frame.setVisible(true);
		
		for(int i = 0; i < 500; i++) {
			x++;
			y++;
			
			drawPanel.repaint();
			
			try {
				Thread.sleep(80);
			} catch(Exception ex) { }
		}
	} //go end
	
	class MyDrawPanel2 extends JPanel {
		public void paintComponent(Graphics g) {
			int red = (int) (Math.random() * 256);
			int blue = (int) (Math.random() * 256);
			int green = (int) (Math.random() * 256);
			Color ballcolor = new Color(red, blue, green);
//			g.setColor(Color.black);
//			g.fillRect(0, 0, getWidth(), getHeight());
			
			g.setColor(ballcolor);
			g.fillOval(x, y, 40, 40);
		}
	}
}
