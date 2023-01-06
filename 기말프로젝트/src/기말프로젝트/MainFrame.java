package 기말프로젝트;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
	
	public MainFrame() {
		setTitle("Lotte Giants 개막전 예매하기");
		setSize(500,400);
		JPanel panel = new JPanel();
		panel.setLayout(null);
			
		JLabel label = new JLabel("Lotte Giants");
		label.setFont(new Font(label.getFont().getName(),Font.BOLD,30));
		label.setForeground(Color.white);
		
		ImageIcon icon = new ImageIcon("images/image4.jpg");
		ImageIcon icon2 = new ImageIcon("images/image6.jpg");
		JLabel imageLabel = new JLabel(icon);
		JLabel imageLabel2 = new JLabel(icon2);
		imageLabel.setBounds(0, 0, 500, 400);
		imageLabel2.setBounds(350, 250, 100, 100);
		
		JButton button1 = new JButton("경기예매");
		JButton button2 = new JButton("예매확인");
		
		JLabel ques = new JLabel("question");
		ques.setFont(new Font(ques.getFont().getName(),Font.BOLD,15));
		ques.setForeground(Color.red);
		
		label.setBounds(180, 30, 200, 80);
		button1.setBounds(180, 180, 140, 30);
		button2.setBounds(180, 240, 140, 30);
	
		panel.add(label);
		panel.add(button1);
		panel.add(button2);
		panel.add(imageLabel2);
		panel.add(imageLabel);
	
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		add(panel);
		
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new TicketingFrame().setVisible(true);
			MainFrame.this.setVisible(false);
		}

				});
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new CheckTicketFrame().setVisible(true);
			MainFrame.this.setVisible(false);
		}

		});
		
		imageLabel2.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				new AskService().setVisible(true);
				MainFrame.this.setVisible(false);
			}
		});
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFrame().setVisible(true);
	}

}
