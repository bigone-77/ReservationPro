package 기말프로젝트;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AskService extends JFrame{
	JTextArea ta = new JTextArea(10,20);
	JScrollPane js = new JScrollPane(ta);
	JButton btn = new JButton("입력");
	
	public AskService() {
		setTitle("고객 문의 센터");
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pn = new JPanel(null);
		
		JLabel lb = new JLabel("누리봇");
		JLabel lb1 = new JLabel("거인");
		JLabel info = new JLabel("무엇이든 물어보세요");
		info.setFont(new Font(info.getFont().getName(),Font.BOLD,15));
		info.setForeground(Color.orange);
		info.setOpaque(true);
		JLabel pg = new JLabel("https://www.giantsclub.com/html/");
		pg.setFont(new Font(pg.getFont().getName(),Font.ITALIC,13));
		JLabel pc = new JLabel("문의번호:051)852-1981");
		pc.setFont(new Font(pc.getFont().getName(),Font.ITALIC,13));
		
		ImageIcon icon = new ImageIcon("images/image6.jpg");
		ImageIcon icon2 = new ImageIcon("images/image7.jpg");
		JLabel imageLabel = new JLabel(icon);
		imageLabel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
			new MainFrame().setVisible(true);
			AskService.this.setVisible(false);
			}
		});
		JLabel imageLabel2 = new JLabel(icon2);
		
		ta.setEditable(false);
		ta.setLineWrap(true); // textarea에서 자동 줄바꿈
        pn.add(js);
 
		
		
		Choice question = new Choice();
		question.add("사직 구장 근처 지하철 역이 있나요 ?");
		question.add("근처 먹거리 추천해주세요!");
		question.add("롯데 자이언츠 마스코트 제일 유명한 애 이름이 뭐죠 ?");
		question.add("응원하기 좋은 좌석 추천해주세요 !");
		question.add("할인 해택은 어떤게 있나요 ?");
		
		
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int c = question.getSelectedIndex();
				switch(c) {
				case 0:
					ta.setText("종합운동장역 5,6번 출구로 하차하셔서 도보로 10분 이내면 오실 수 있습니다.");
					break;
					
				case 1:
					ta.setText("분식집인 '남도푸드', 생맥주를 즐기시려면 '봉구비어', 치킨체인점 'BBQ', 족발집 등등 다양합니다 ^^");
					break;
				case 2:
					ta.setText("바로 저 누리가 아무래도 가장 유명하지요 ~");
					break;
				case 3:
					ta.setText("사람마다 편차가 있겠지만 조심스럽게 내야상단석 중앙자리를 추천해드릴게요 ~");
					break;	
				case 4:
					ta.setText("롯데포인트플러스카드로 최대 10만원 캐시백 해택, 롯데신용카드 결제시 단독 10% 할인(본인 + 동반1인)");
					break;
				}
			}
		});
		
		
		
		info.setBounds(200,5,150,30);
		lb.setBounds(15,230,50,20);
		js.setBounds(15,250,150,90);
		lb1.setBounds(300,90,50,20);
		btn.setBounds(450,110,30,30);
		question.setBounds(300,100,150,50);
		imageLabel.setBounds(20,30,230,200);
		imageLabel2.setBounds(250,200,130,60);
		pg.setBounds(250,280,200,30);
		pc.setBounds(250,300,200,30);
		
		pn.add(info);	pn.add(lb);		pn.add(lb1);	pn.add(question);	pn.add(btn);	pn.add(imageLabel);	pn.add(imageLabel2);
		pn.add(pg);		pn.add(pc);
	
		add(pn);
	
		
		
		
		setVisible(true);

}
}
