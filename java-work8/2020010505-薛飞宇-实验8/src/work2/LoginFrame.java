package work2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private LoginConnection loginConnection = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("用户名：");
		lblNewLabel.setBounds(99, 60, 57, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(166, 57, 173, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("密码：");
		lblNewLabel_1.setBounds(99, 110, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginConnection = new LoginConnection();
				String a = textField.getText();
				char[] c = passwordField.getPassword();
				String b = new String(c);
				if(loginConnection.check(a, b)) {
					JOptionPane.showMessageDialog(LoginFrame.this, "登录成功！");
				}else {
					JOptionPane.showMessageDialog(LoginFrame.this, "登录失败！", null, JOptionPane.ERROR_MESSAGE);
				}
				loginConnection.ending();
			}
		});
		btnNewButton.setBounds(101, 191, 95, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(244, 191, 95, 23);
		contentPane.add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(166, 107, 173, 21);
		contentPane.add(passwordField);
	}
}
