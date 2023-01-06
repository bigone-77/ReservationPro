package 기말프로젝트;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;





public class TicketingFrame extends JFrame implements ItemListener, ActionListener{
	Choice gameName;            	    //경기 선택  
	Choice gameSeat; 				    //좌석 유형
	Choice adultTicket;				    //성인
	Choice childTicket;					//학생
	Choice nowonTicket;
	JPanel panel;
	JLabel label,name,type,adult,child,nowon,imageLabel;
	JButton next,home;
	int ticketNum,select;
	
	public TicketingFrame(){
		setSize(500,400);
		setTitle("경기 예매");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel(null);
		label = new JLabel("Lotte Giants");
		name = new JLabel("경기 선택 : ");
		type = new JLabel("좌석 선택 : ");
		adult = new JLabel("어   른 : ");
		child = new JLabel("청소년 : ");
		nowon = new JLabel("노원 : ");
		ImageIcon icon = new ImageIcon("images/image5.jpg");
		imageLabel = new JLabel(icon);
		
		ticketNum = (int) (Math.random()*99999);						// 예매 번호를 random으로 선택함
		next = new JButton("NEXT");
		home = new JButton("HOME");
		
		next.addActionListener(this);									// next 이벤트 리스너
		
		home.addActionListener(new ActionListener() { 					
			
			
			public void actionPerformed(ActionEvent e) {
			
				TicketingFrame.this.dispose();
				new MainFrame().setVisible(true);
			}
		});
		
		gameName=new Choice();                // 초이스 객체를 생성한다.
		gameSeat=new Choice(); 
		
		gameSeat.add("내야상단석");       
		gameSeat.add("내야하단석");
		gameSeat.add("중앙테이블석");
		gameSeat.add("익사이팅석");
		gameSeat.add("외야지정석");
	
		
		adultTicket =new Choice();			
		childTicket =new Choice();			
		nowonTicket = new Choice();
		
		gameName.add("롯데_두산(11월28일)");                         
		gameName.add("롯데_두산(11월29일)");
		gameName.add("두산_롯데(12월1일)");
		gameName.add("두산_롯데(12월2일)");
		gameName.add("롯데_두산(12월4일)");
		gameName.add("롯데_두산(12월5일)");
		gameName.add("롯데_두산(12월6일)");
	
		gameName.addItemListener(this);
	
		for(int i=0; i < 11; i++) {                 //인원수 최대 10명
			adultTicket.add(String.valueOf(i));
			childTicket.add(String.valueOf(i));
			nowonTicket.add(String.valueOf(i));
		}
		
		label.setFont(new Font(label.getFont().getName(), Font.BOLD, 30));
		label.setForeground(Color.orange);
		
		
		imageLabel.setBounds(0, 0, 500, 400);
		label.setBounds(160,60,200,80);											
		name.setBounds(20,160,70,30);
		gameName.setBounds(90,163,150,30);
		type.setBounds(20,200,70,30);
		gameSeat.setBounds(90,203,150,30);
		adult.setBounds(270, 160, 70, 30);
		adultTicket.setBounds(350,163,70,30);
		child.setBounds(270, 200, 70, 30);
		childTicket.setBounds(350,203,70,30);
		nowon.setBounds(270,240,70,30);
		nowonTicket.setBounds(350, 243, 70, 30);
		next.setBounds(80, 300, 140, 30);
		home.setBounds(280,300,140,30);
		
		panel.add(label);
		panel.add(name);
		panel.add(gameName);
		panel.add(type);
		panel.add(gameSeat);
		panel.add(adult);
		panel.add(adultTicket);
		panel.add(child);
		panel.add(childTicket);
		panel.add(nowon);
		panel.add(nowonTicket);
		panel.add(next);
		panel.add(home);
		panel.add(imageLabel);
		setResizable(false);				 // 크기 조절 불가
		add(panel);
		
	}
	public void itemStateChanged(ItemEvent e) {
	
		int index = gameName.getSelectedIndex();	
		gameSeat.removeAll();
		if(index == 0)							//index가 0일 경우
		{					
			gameSeat.add("내야상단석");      
			gameSeat.add("내야하단석");
			gameSeat.add("중앙테이블석");
			gameSeat.add("익사이팅석");
			gameSeat.add("외야지정석");
		
		}
		else if(index==1)
		{					
			gameSeat.add("내야상단석");     
			gameSeat.add("내야하단석");
			gameSeat.add("중앙테이블석");
			gameSeat.add("익사이팅석");
			gameSeat.add("외야지정석");
				}
		else if(index==2)
		{					
			gameSeat.add("오렌지석");      
			gameSeat.add("네이비석");
			gameSeat.add("중앙테이블석");
			gameSeat.add("익사이팅석");
			gameSeat.add("외야지정석");
		
		}
		else if(index==3)
		{					
			gameSeat.add("오렌지석");      
			gameSeat.add("네이비석");
			gameSeat.add("중앙테이블석");
			gameSeat.add("익사이팅석");
			gameSeat.add("외야지정석");
		
		}
		else if(index==4)
		{					
			gameSeat.add("내야상단석");     
			gameSeat.add("내야하단석");
			gameSeat.add("중앙테이블석");
			gameSeat.add("익사이팅석");
			gameSeat.add("외야지정석");
		
		}
		else if(index==5)
		{					
			gameSeat.add("내야상단석");      
			gameSeat.add("내야하단석");
			gameSeat.add("중앙테이블석");
			gameSeat.add("익사이팅석");
			gameSeat.add("외야지정석");
		
		}
		else if(index == 6)
		{
			gameSeat.add("내야상단석");      
			gameSeat.add("내야하단석");
			gameSeat.add("중앙테이블석");
			gameSeat.add("익사이팅석");
			gameSeat.add("외야지정석");
		
		}
		select = index; 										// 게임 선택 - > 좌석유형 한세트로 하기 위해 변수 select사용
	}
	public void actionPerformed(ActionEvent e){

		

			int l_gameSeat = gameSeat.getSelectedIndex();		//각 아이템에서 index 를 얻어옴
			String l_strGameSeat = gameSeat.getSelectedItem();
			int l_adult_ticket = adultTicket.getSelectedIndex();
			int l_student_ticket = childTicket.getSelectedIndex();
			int l_nowon_ticket = nowonTicket.getSelectedIndex();

		
			
			int l_adult_price = 20000;					//각표에 대한 가격 설정
			int l_student_price = 15000;
			int l_nowon_price = 10000;
			int l_totalPrice = 0;

			if((l_adult_ticket == 0 && l_student_ticket == 0 && l_nowon_ticket == 0)||l_strGameSeat == null)
			{
				new MsgBox(new JFrame("") ,null,null ,"부족한 요소가 있습니다.",null, false,null);
			}
			
			else 										// 자리 유형에 맞게 가격 조정
			
				if(l_gameSeat == 0) {
					l_adult_price += 5000;
					l_student_price += 5000;
					l_nowon_price += 5000;
				}
				else if(l_gameSeat == 1) {
				l_adult_price += 2000;
				l_student_price += 2000;
				l_nowon_price += 2000;
			}
				else if(l_gameSeat == 2) {
					l_adult_price += 2000;
					l_student_price += 2000;
					l_nowon_price += 2000;
				}

				else if(l_gameSeat == 3) {
					l_adult_price += 5000;
					l_student_price += 5000;
					l_nowon_price += 5000;
				}
				else if(l_gameSeat == 4) {
					l_adult_price += 2000;
					l_student_price += 2000;
					l_nowon_price += 2000;
				}

			// 각각의 항목들 가격 총 합을 구하기 
			
			if(l_adult_ticket != 0) {
				l_totalPrice += l_adult_ticket * l_adult_price;
			}
			
			if(l_student_ticket != 0) {
				l_totalPrice += l_student_ticket * l_student_price;
			}
			
			if(l_nowon_ticket != 0) {
				l_totalPrice += l_nowon_ticket * l_nowon_price;
			}
			
		
			
			TicketingFrame.this.setVisible(false);
			
			SeatFrame seat = new SeatFrame(gameName.getItem(select),l_adult_ticket+l_student_ticket+l_nowon_ticket,l_totalPrice,ticketNum,l_strGameSeat,TicketingFrame.this);
			seat.setVisible(true);
		}
	}

