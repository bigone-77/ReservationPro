package 기말프로젝트;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MsgBox extends JDialog implements ActionListener 	//다이어로그로 상속받은 메시지 박스에 엑션리스너를 추가하는 클래스
{
	Button ok;					//버튼
	JFrame parent;
	public MsgBox(JFrame frame, String gameName,String ticketNum,String etc,String seats, boolean okcan,JFrame parent)
	{
		super(frame, "Message", true);		//Message의 프레임 설정
		this.parent = parent;
		
		Container c = frame.getContentPane();
		c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
		
		c.add(new Label(gameName));	c.add(new Label(ticketNum));	c.add(new Label(seats));	c.add(new Label(etc));
		add(c);
		addOKPanel();
		pack();
		setVisible(true);
	}

	void addOKPanel() 
	{
		Panel p = new Panel();				//패널 생성
		p.setLayout(new FlowLayout());
		p.add(ok=new Button("OK"));
		ok.addActionListener(this);
		add("South",p);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == ok) 					//버튼 클릭에 따라 액션 설정
		{
			if(parent!=null) parent.setVisible(false);
			new MainFrame().setVisible(true);
			setVisible(false);
		}
		
	}
}
