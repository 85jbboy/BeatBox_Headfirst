//package ch14_Serialization;
//
//import java.awt.BorderLayout;
//import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//
//import javax.swing.JButton;
//import javax.swing.JFileChooser;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JMenu;
//import javax.swing.JMenuBar;
//import javax.swing.JMenuItem;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
//import javax.swing.ScrollPaneConstants;
//
//public class QuizCardBuilder {
//	
//	private JTextArea question;
//	private JTextArea answer;
//	private ArrayList<QuizCard> cardList;
//	private JFrame frame;
//	
//	public static void main(String[] args) {
//		QuizCardBuilder builder = new QuizCardBuilder();
//		builder.go();
//	}
//	
//	public void go() { // 이벤트 리스터를 만들고 등록하는 과정을 포함한 GUI를 만들고 화면에 표시하는 작업 처리
//		frame = new JFrame("Quiz Card Builder, baby!!");
//		JPanel mainPanel = new JPanel();
//		Font bigFont = new Font("sanserif", Font.BOLD, 24);
//		
//		question = new JTextArea(6, 20);
//		question.setLineWrap(true);
//		question.setWrapStyleWord(true);
//		question.setFont(bigFont);
//		
//		JScrollPane qScroller = new JScrollPane(question);
//		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//		
//		answer = new JTextArea(6, 20);
//		answer.setLineWrap(true);
//		answer.setWrapStyleWord(true);
//		answer.setFont(bigFont);
//		
//		JScrollPane aScroller = new JScrollPane(answer);
//		aScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//		aScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//		
//		JButton nextButton = new JButton("Next Card~!");
//		cardList = new ArrayList<QuizCard>();
//		
//		JLabel qLabel = new JLabel("QUESTION!: ");
//		JLabel aLabel = new JLabel("ANSWER!:" );
//		
//		mainPanel.add(qLabel);
//		mainPanel.add(qScroller);
//		mainPanel.add(aLabel);
//		mainPanel.add(aScroller);
//		mainPanel.add(nextButton);
//		nextButton.addActionListener(new NextCardListener());
//		
//		JMenuBar menuBar = new JMenuBar();
//		JMenu fileMenu = new JMenu("File");
//		JMenuItem newMenuItem = new JMenuItem("New");
//		JMenuItem saveMenuItem = new JMenuItem("Save");
//		newMenuItem.addActionListener(new NewMenuListener());
//		saveMenuItem.addActionListener(new SaveMenuListener());
//		
//		fileMenu.add(newMenuItem);
//		fileMenu.add(saveMenuItem);
//		menuBar.add(fileMenu);
//		
//		frame.setJMenuBar(menuBar);
//		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
//		frame.setSize(500, 600);
//		frame.setVisible(true);
//	}
//	
//	public class NextCardListener implements ActionListener { //nextCard 버튼 클릭시! 방금입력한 카드를 목록에 저장, 다음카드작성 
//		public void actionPerformed(ActionEvent ev) { // 현재카드를 몰공게 추가하고 텍스트 영역을 지움.
//			QuizCard card = new QuizCard(question.getText(), answer.getText());
//			cardList.add(card);
//			clearCard();
//		}
//	}
//	
//	public class SaveMenuListener implements ActionListener { //file 메뉴에서 save 선택시! 목록에 있는 카드를 한꺼번에 저장. 
//		public void actionPerformed(ActionEvent ev) { // 파일 대화상자 열고 파일명 저장한 다음 저장.
//			QuizCard card = new QuizCard(question.getText(), answer.getText());
//			cardList.add(card);
//			
//			JFileChooser fileSave = new JFileChooser();
//			fileSave.showSaveDialog(frame);
//			saveFile(fileSave.getSelectedFile());
//		}
//	}
//	
//	public class NewMenuListener implements ActionListener { //file 메뉴에서 new 선택시! 완전히 새로운 카드세트 시작
//		public void actionPerformed(ActionEvent ev) { // 카드목록을 비우고 텍스트 영역을 지움.
//			cardList.clear();
//			clearCard();
//		}
//	}
//	private void clearCard() {
//		question.setText("");
//		answer.setText("");
//		question.requestFocus();
//	}
//
//	private void saveFile(File file) { // 카드 목록을 순환하면서 각 내용을 나중에 파싱할 수 있는 방식으로 파일에 저장.
//		try {
//			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
//			for(QuizCard card : cardList) {
//				writer.write(card.getQuestion() + "/");
//				writer.write(card.getAnswer() + "\n");
//			}
//			writer.close();
//		} catch(IOException ex) {
//			System.out.println("couldn't write the cardList out");
//			ex.printStackTrace();
//		}
//	}
//}
