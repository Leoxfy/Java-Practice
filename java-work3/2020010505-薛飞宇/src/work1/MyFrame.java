package work1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.*;

public class MyFrame extends JFrame{
	JLabel userLabel, pawdLabel, confirmLabel, emailLabel;
	JTextField userField, pawdField, confirmField, emailField;
	JButton commitButton, cancelButton;
	JLabel noticeLabel1, noticeLabel2, noticeLabel3, noticeLabel4;
	boolean key = false, key1 = false, key2 = false, key3 = false, key4 = false;
	String password = "";
	
	public MyFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(450, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		init();
		
		//setVisible���������
		setVisible(true);
	}
	
	void init(){
		setTitle("ע��");
		setLayout(null); 
		final int labelX = 55;
		final int fieldX = 120;
		final int width = 250;
		final int height = 22;
		
		
		final int noticeWid = 300;
		
		noticeLabel1 = new JLabel("�û��������ǲ������ַ���6-20λ�ַ���");
		noticeLabel2 = new JLabel("���������8-20λ�Ŀɺ������Ż򵥴��ַ����ַ���");
		noticeLabel3 = new JLabel("ȷ�����������������ͬ");
		noticeLabel4 = new JLabel("������Ϸ��������ַ");
		
		noticeLabel1.setBounds(fieldX,73,noticeWid, height);
		noticeLabel2.setBounds(fieldX,123,noticeWid,height);
		noticeLabel3.setBounds(fieldX,173,noticeWid,height);
		noticeLabel4.setBounds(fieldX,223,noticeWid,height);
		
		noticeLabel1.setForeground(Color.RED);
		noticeLabel2.setForeground(Color.RED);
		noticeLabel3.setForeground(Color.RED);
		noticeLabel4.setForeground(Color.RED);
		
		
		add(noticeLabel1);
		add(noticeLabel2);
		add(noticeLabel3);
		add(noticeLabel4);
		noticeLabel1.setVisible(false);
		noticeLabel2.setVisible(false);
		noticeLabel3.setVisible(false);
		noticeLabel4.setVisible(false);
		
		
		userLabel = new JLabel("�û�����");
		userLabel.setBounds(labelX, 50, width, height);
		
		userField = new JTextField(10);
		userField.setBounds(fieldX, 50, width, height);
		userField.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				//System.out.println("get1");
			}

			@Override
			public void focusLost(FocusEvent e) {
				//��ȡ�ı�������ݣ��ж��Ƿ�ƥ��
				String str =  userField.getText();
				if(str.matches("\\S{6,20}")) {
					noticeLabel1.setVisible(false);
					//System.out.println("yes1");
					key1 = true;
					repaint();
				}else {
					noticeLabel1.setVisible(true);
					key1 = false;
					repaint();
				}
			}
			
		});
		
		
		pawdLabel = new JLabel("���룺");
		pawdLabel.setBounds(labelX, 100, width, height);
		
		pawdField = new JTextField(10);
		pawdField.setBounds(fieldX, 100, width, height);
		pawdField.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				//System.out.println("get2");
			}

			@Override
			public void focusLost(FocusEvent e) {
				String str = pawdField.getText();
				if(str.matches("[\\p{P}a-zA-Z]{8,20}")) {
					noticeLabel2.setVisible(false);
					password = str;
					key2 = true;
					repaint();
				}else {
					noticeLabel2.setVisible(true);
					key2 = false;
					repaint();
				}
			}
			
		});
		
		confirmLabel = new JLabel("ȷ�����룺");
		confirmLabel.setBounds(labelX, 150, width, height);
		
		confirmField = new JTextField(10);
		confirmField.setBounds(fieldX, 150, width, height);
		confirmField.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				//System.out.println("get3");
			}

			@Override
			public void focusLost(FocusEvent e) {
				String str = confirmField.getText();
				if(str.equals(password) && key2==true) {
					noticeLabel3.setVisible(false);
					key3 = true;
					repaint();
				}else {
					noticeLabel3.setVisible(true);
					key3 = false;
					repaint();
				}
			}
			
		});
		
		emailLabel = new JLabel("���䣺");
		emailLabel.setBounds(labelX, 200, width, height);
		
		emailField = new JTextField(10);
		emailField.setBounds(fieldX, 200, width, height);
		emailField.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				//System.out.println("get4");
			}

			@Override
			public void focusLost(FocusEvent e) {
				String str = emailField.getText();
				if(str.matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")) {
					noticeLabel4.setVisible(false);
					key4 = true;
					repaint();
				}else {
					noticeLabel4.setVisible(true);
					key4 = false;
					repaint();
				}
			}
			
		});
		
		commitButton = new JButton("ȷ��");
		commitButton.setBounds(130, 270,70,30);
		//�ڲ���ע���¼�������
		commitButton.addActionListener(new ButtonListener());
		
		
		
		
		
		
		cancelButton = new JButton("ȡ��");
		cancelButton.setBounds(250,270,70,30);
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		
		
		
		add(userLabel);
		add(userField);
		add(pawdLabel);
		add(pawdField);
		add(confirmLabel);
		add(confirmField);
		add(emailLabel);
		add(emailField);
		add(commitButton);
		add(cancelButton);
		
	}
	
	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==commitButton) {
				if(key1&&key2&&key3&&key4) {
					key = true;
				}else {
					key = false;
				}
				if(key==true) {
					JOptionPane.showMessageDialog(null, "ע��ɹ�!", "ע����ʾ", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "��������д!","ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		new MyFrame();
	}
}
