package work2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalendarFrame extends JFrame{
	JButton prevButton, nextButton;
	JLabel nowTime;
	JPanel pCenter, pNorth, pSouth;
	JLabel [] contentLabel; 
	JButton [] weekButton;
	CalendarBean cb = new CalendarBean();
	public CalendarFrame() {
		setSize(500,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		init();
		
		setVisible(true);
	}
	
	void init() {
		setLayout(new BorderLayout());
		setTitle("�ҵ�����");
		
		pNorth = new JPanel();
		pNorth.setLayout(new FlowLayout());
		
		pCenter = new JPanel();
		pCenter.setLayout(new GridLayout(7,7));
		
		weekButton = new JButton[7];
		weekButton[0] = new JButton("��");
		weekButton[1] = new JButton("һ");
		weekButton[2] = new JButton("��");
		weekButton[3] = new JButton("��");
		weekButton[4] = new JButton("��");
		weekButton[5] = new JButton("��");
		weekButton[6] = new JButton("��");
		
		for(int i=0;i<7;i++) {
			pCenter.add(weekButton[i]);
		}
		
		contentLabel = new JLabel[42];
		for(int i=0;i<42;i++) {
			contentLabel[i] = new JLabel("");
			pCenter.add(contentLabel[i]);
		}
		
		
		pSouth = new JPanel();
		pSouth.setLayout(new FlowLayout());
		nowTime = new JLabel("");
		pSouth.add(nowTime);
		refresh();
		
		
		
		prevButton = new JButton("����");
		nextButton = new JButton("����");
		
		pNorth.add(prevButton);
		pNorth.add(nextButton);  
		
		//printCalendar();
		
		add(pNorth, BorderLayout.NORTH);
		add(pCenter, BorderLayout.CENTER);
		add(pSouth, BorderLayout.SOUTH);
		
		
		prevButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cb.previousMonth();
				refresh();
			}
			
		});
		
		nextButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cb.nextMonth();
				refresh();
			}
			
		});
	}
	
	void refresh() {
		String [] a = cb.getCalendar();
		for(int i=0;i<42;i++) {
			contentLabel[i].setText(a[i]);
		}
		nowTime.setText("������"+cb.year+"��"+cb.month+"��");
		repaint();
	}
	
	public static void main(String[] args) {
		new CalendarFrame();
	}

}
