package ch14_Serialization;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class QuizCardPlayer {
	private JTextArea display;
	private JTextArea answer;
	private ArrayList<QuizCard> cardList;
	private QuizCard currentCard;
	private int currentCardIndex;
	private JFrame frame;
	private JButton nextButton;
	private boolean isShowAnswer;
	
	public static void main(String[] args) {
		QuizCardPlayer reader = new QuizCardPlayer();
		reader.go();
	}
	public void go() { //GUI 만들고 화면에 출력
		frame = new JFrame("Quiz Card Player, yo");
		JPanel mainPanel = new JPanel();
		Font bigFont = new Font("sanserif", Font.BOLD, 24);
		
		display = new JTextArea(10, 20);
		display.setFont(bigFont);
		display.setLineWrap(true);
		display.setEditable(false);
		
		JScrollPane qScroller = new JScrollPane(display);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		nextButton = new JButton("Show Question");
		mainPanel.add(qScroller);
		mainPanel.add(nextButton);
		nextButton.addActionListener(new NextCardListener());
		
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem loadMenuItem = new JMenuItem("Load card set");
		loadMenuItem.addActionListener(new OpenMenuListener());
		fileMenu.add(loadMenuItem);
		menuBar.add(fileMenu);
		frame.setJMenuBar(menuBar);
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(640, 500);
		frame.setVisible(true);
	}
	
	public class NextCardListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			//질문이면 답을 보여주고, 그렇지 않으면 다음 질문을 보여준다.
			//질문을 보여주는지 답을 보여주는지 확인하기 위한 플래그 설정
			if(isShowAnswer) { // 문제는 이미 봤으니 정답을 보여준다.
				display.setText(currentCard.getAnswer());
				nextButton.setText("Next Card");
				isShowAnswer = false;
			} else { // 다음 문제를 보여준다.
				if(currentCardIndex < cardList.size()) {
					showNextCard();
				} else { // 카드가 더 없을 때.
					display.setText("That was last card");
					nextButton.setEnabled(false);
				}
			}
		}
	}

	public class OpenMenuListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			// 파일 대화 상자를 표시
			// 사용자가 암기장 카드 세트를 선택하게 할 수 있음
			JFileChooser fileOpen = new JFileChooser();
			fileOpen.showOpenDialog(frame);
			loadFile(fileOpen.getSelectedFile());
		}
	}
	
	private void loadFile(File file) {
		// OpenMenuListener 이벤트 핸들러에서 요청한 텍스를 파일을 읽어서 암기장 카드로 구성된 arraylist 만든다.
		// 이 때 파일을 한 행씩 읽은 다음 makeCard() 메소드를 호출하여 그 행을 바탕으로 새 카드를 만든다.
		// 한 줄에 질문과 답이 둘 다 들어간다. 문제와 답은 "/"으로 구분한다.
		cardList = new ArrayList<QuizCard> ();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while((line = reader.readLine()) != null) {
				makeCard(line);
			}
			reader.close();
		} catch(Exception ex) {
			System.out.println("couldn't read the card file");
			ex.printStackTrace();
		}
		//첫번찌 카드부터 보여주기 시작한다.
		showNextCard();
	}
	
	private void makeCard(String lineToParse) {
		//loadFile 메소드에서 호출하는 메소드로 텍스트 파일에서 한 행을 받아서
		//두 부분(문제와 답)으로 파싱한 다음 새로운 QuizCard 객체를 만들고 그 객체를 CardList라는 ArrayList에 추가한다.
		String[] result = lineToParse.split("/");
		QuizCard card = new QuizCard(result[0], result[1]);
		cardList.add(card);
		System.out.println("made a card");
	}
	private void showNextCard() {
		currentCard = cardList.get(currentCardIndex);
		currentCardIndex++;
		display.setText(currentCard.getQuestion());
		nextButton.setText("Show Answer");
		isShowAnswer = true;
	}
}
