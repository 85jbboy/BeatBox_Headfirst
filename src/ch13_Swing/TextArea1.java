package ch13_Swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class TextArea1 implements ActionListener {
	
	JTextArea text;
	
	public static void main(String[] args) {
		TextArea1 gui = new TextArea1();
		gui.go();
	}

	public void go() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton button = new JButton("Just Do it");
		
		button.addActionListener(this);
		text = new JTextArea(10, 20); // JTextArea text = new JTextArea(10줄, 행 당 글자수); --> 쓰는 영역 객체 확보
		text.setLineWrap(true); // 20 글자수 넘겼을 때 자동으로 행바꿔주는 기능
		
		JScrollPane scroller = new JScrollPane(text); // scroller 기능 추가
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); // 세로 스크롤 존재
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		panel.add(scroller); // panel.add(text); 라고 해보면 뭐가 다른지 알 것임.
		
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		frame.setSize(350, 300);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {
		text.append("Button clicked \n");
	}
}
