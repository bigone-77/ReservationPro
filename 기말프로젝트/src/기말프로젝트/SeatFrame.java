package 기말프로젝트;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class SeatFrame extends JFrame {
	JPanel panel,seat;
	JLabel cheer,seats[],peopleLabel,priceLabel;
	JButton prev,next;
	boolean[] select;
	ArrayList<String> ticket;
	int member; 													
	
	public SeatFrame(String gameName,int people,int price,int ticketNum,String type,JFrame parent) { // ticketingFrame에서 버튼 누르면 그 정보가 생성자로 전달된다
		setSize(500,400);
		setTitle("좌석 선택");
		member = people;  													//생성자로 불러온 (어른,청소년,노원항목들의 사람 수 합)
		panel = new JPanel(null);
		
		cheer = new JLabel("응원단상");
		cheer.setBackground(Color.white);
		cheer.setOpaque(true);												
		
		prev = new JButton("PREV");
		next = new JButton("NEXT");
		ticket = new ArrayList<String>();									// ticket.txt에서 읽어서 저장할 arrayList
		
		seat = new JPanel(new GridLayout(7, 7));	 						
		seats = new JLabel[50];												
		select = new boolean[50];											// 현재 선택한 놈들
		

		seat.setBackground(Color.white);
		seat.setOpaque(true);
		
		for(int i=0;i<7;i++) 												
			for(int j=0;j<7;j++) {
				final int k =i*7+j;											
				seats[k] = new JLabel(Integer.toString(k+1)); 				// 라벨을 하나씩 좌석 번호로 초기화해줌
				seats[k].setHorizontalAlignment(JLabel.CENTER);				// 텍스트를 가운데 정렬 해줌
				seats[k].addMouseListener(new MouseAdapter() {			
					
					public void mouseClicked(MouseEvent e) { 						// 위에는 다 안쓰니깐 버리고 click 이벤트만 씀
	
						if(seats[k].getBackground()==Color.MAGENTA) { 					// MAGETA는 지금 선택했던 좌석
							seats[k].setBackground(Color.WHITE); 						// 다시 선택하면 다시 흰색으로 배경을 바꿔줌
							select[k] = false;											// 선택된 좌석을 false로 바꿔주고 member를 하나증가시킴
							member++;
						}
						else if(member>0 && seats[k].getBackground()!=Color.GREEN){ 	// green는 이전에 다른사람이 예매한 좌석, member가 아직 0이아니면
							seats[k].setBackground(Color.MAGENTA);						// 선택할 수 있으므로 magenta로 색깔을 바꿔주고 select를 true로해줌
							select[k] = true;						
							member--;													// 한자리 선택했으므로 member는 감소시킴
						}
						seats[k].setOpaque(true);										// 바뀐 배경색 적용
					}
				});
				seat.add(seats[k]);														
			}
	
		prev.addActionListener(new ActionListener() {									// prev 버튼 이벤트 리스너
			
			public void actionPerformed(ActionEvent e) {
			
				parent.setVisible(true);												
				SeatFrame.this.setVisible(false);										
			}
		});
		next.addActionListener(new ActionListener() {									// next 버튼 이벤트 리스너
			
			
			public void actionPerformed(ActionEvent e) {
			
				if(member>0) 
					new MsgBox(new JFrame("") ,null,null,"좌석을 전부 선택해주세요",null, false,null); 		// member가 0보다 크단것은 좌석을 전부선택 하지 않았다는 뜻
				else {
			
					String seats = "\t";
					for(int i=0;i<49;i++) {															// 해당하는 좌석이 선택되면 true이기때문에
						if(select[i])																// true인지 검사하고 맞으면 seats에 추가해줌
							seats+=(i+1)+",";
					}
					seats = seats.substring(0, seats.length()-1);									// seats의 마지막 문자가 ","이기때문에 그것을 없애주기위함
					
					String etc = "좌석 유형 : "+type+"  가     격 : "+price;
					
					String msg = gameName+"\t"+ticketNum+"\t"+price +seats+"\t"+type;				// 그게아니면 예매정보를 아래와 같이 가공함
		
					ticket.add(msg);																// 리스트에 역시 추가함
					
					/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					new MsgBox(new JFrame("") ,"경기 선택 : "+gameName,"예약 번호 : "+ticketNum, etc,"좌     석   : "+seats, false,SeatFrame.this); // 가공한 정보를 msgbox로 띄움
					
					try {
						FileWriter fw = new FileWriter("ticket.txt"); 								// 이제 예매를 했으니 ticket.txt에 쓸것임
						BufferedWriter bw = new BufferedWriter(fw);									// 지금 예매한것만 추가하고싶으나 그럴수없으므로 ticket에 있는 모든 정보를 다시 출력해줌									
						for(int i = 0 ; i<ticket.size();i++)										// 반복문을돌려서 모든 예매정보를 다시 출력해줌 									
							bw.write(ticket.get(i)+"\n"); 											//bw에는 자동개행기능이 없기때문에 각 항목마다 개행문자 넣어줘야함
						bw.close();
						fw.close();
					} catch (Exception e1) {
					
						e1.printStackTrace();
					}
				}
				
			}
		});
		
		try {
			FileReader fr = new FileReader("ticket.txt");								// ticket.txt 를 읽어드림
			BufferedReader br = new BufferedReader(fr);
			String str;
			while((str = br.readLine()) != null) { 										
				ticket.add(str); 														// ticket arraylist에 add시킴
				StringTokenizer st = new StringTokenizer(str);							// 이제 stringtokenize로 자를것임
				String name = st.nextToken("\t ");										// 경기 정보
				String str2 = st.nextToken("\t ");										
				String str3 = st.nextToken("\t ");												
				String seats = st.nextToken("\t ");
				String tyPe = st.nextToken("\t ");										// 좌석 유형
				
				StringTokenizer st2 = new StringTokenizer(seats,",");					// 이제 좌석정보를 ","로 구분할것임				
				if(gameName.equals(name) && type.equals(tyPe)) {							// 경기 정보와 좌석유형이 맞으면
					while(st2.hasMoreTokens()) {
						str2 = st2.nextToken();											// ","로 자른 좌석 번호의 배경색을 green으로 바꿔줌
						int k = Integer.parseInt(str2);
						this.seats[k].setBackground(Color.GREEN);
						this.seats[k].setOpaque(true);
					}
				}
			}
			br.close();
			fr.close();
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		 
		peopleLabel = new JLabel("인원       :     "+people+"명");
		priceLabel = new JLabel("가격       :     " +price+"원");
		cheer.setBounds(30,20,430,30);
		cheer.setHorizontalAlignment(SwingConstants.CENTER);
		
		prev.setBounds(80, 320, 140, 30);															
		next.setBounds(280,320,140,30);
		seat.setBounds(30,70,430,200);
		peopleLabel.setBounds(80,280,140,30);
		priceLabel.setBounds(280,280,140,30);
		
		panel.add(seat);
		panel.add(cheer);
		panel.add(prev);
		panel.add(next);
		panel.add(peopleLabel);
		panel.add(priceLabel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(panel);		
	}

}
