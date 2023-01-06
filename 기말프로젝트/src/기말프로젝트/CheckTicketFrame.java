package 기말프로젝트;
import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class CheckTicketFrame extends JFrame{
	ArrayList<String> ticket; 											// text파일에서 예매된 정보를 가져와서 arraylist에 넣어줌
	JPanel panel;
	ImageIcon icon;
	JLabel label,numLabel,imageLabel;
	JButton next,home;
	JPasswordField numText;
	
	public CheckTicketFrame(){
		setSize(500,400);
		setTitle("Lotte Giants");
		panel = new JPanel(null);
		label = new JLabel("Lotte Giants");
		label.setFont(new Font(label.getFont().getName(), Font.ITALIC, 30));
		label.setForeground(Color.white);
		icon = new ImageIcon("images/image.jpg");
		imageLabel = new JLabel(icon);
		next = new JButton("NEXT");
		home = new JButton("HOME");
		
		numLabel = new JLabel("예약 번호 : ");
		numText = new JPasswordField(10);
		
		ticket = new ArrayList<String>(); 								// arraylist 초기화
		
		try {
			FileReader fr = new FileReader("ticket.txt");				// ticket.txt 파일에서 예매 정보를 가져옴
			BufferedReader br = new BufferedReader(fr);
			String str;
			while((str = br.readLine()) != null) { 						// 한줄단위로읽어서 arraylist에 넣어줌
				ticket.add(str);
			}
			br.close();
			fr.close();
		} catch (Exception e2) {
		
			e2.printStackTrace();
		}
		
		home.addActionListener(new ActionListener() { 					// home 버튼 이벤트 리스너
			
			@Override
			public void actionPerformed(ActionEvent e) {
		
				CheckTicketFrame.this.setVisible(false); 						
				new MainFrame().setVisible(true);								
			}
		});
		next.addActionListener(new ActionListener() { 					// 예매 정보 확인 버튼 이벤트 리스너
			
			@Override
			public void actionPerformed(ActionEvent e) {
		
				for(int i=0;i<ticket.size();i++) {						// text에서 읽어온 예매된정보 에서 
					
					StringTokenizer st = new StringTokenizer(ticket.get(i).toString());
					String name = st.nextToken("\t ");					// 경기 정보
					String num = st.nextToken("\t ");					// 랜덤 수
					
					if(num.equals(numText.getText().toString())) {
						String price = st.nextToken("\t ");				// 가격
						String seats = st.nextToken("\t ");				// 좌석
						String type = st.nextToken("\t");				// 좌석 유형		
						String etc = "좌석 유형 : "+type+"   가     격 : "+price;
						new MsgBox(new JFrame("") ,"경기 선택 : "+name,"예약 번호 : "+num, etc,"좌     석   : "+seats, false,null);
					}
					
					else if(!num.equals(numText.getText().toString()))
					{
						JOptionPane.showMessageDialog(null, "맞는 예매번호가 아닙니다.","Message",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		imageLabel.setBounds(0,0,500,400);
		next.setBounds(80, 300, 140, 30);
		home.setBounds(280,300,140,30);
		label.setBounds(160,60,200,80);
		numLabel.setBounds(120, 200, 140, 30);
		numText.setBounds(220, 200, 140, 30);
		
		panel.add(label);
		panel.add(numLabel);
		panel.add(numText);
		panel.add(next);
		panel.add(home);
		panel.add(imageLabel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);				 // 크기 조절 불가
		add(panel);
		
		
	}
}
