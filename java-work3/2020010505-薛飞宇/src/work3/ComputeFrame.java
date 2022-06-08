package work3;


import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;

public class ComputeFrame extends JFrame{
	JPanel northPanel,centralPanel;
	JButton resultField;
	public ComputeFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400,500);
		setLocationRelativeTo(null);
		init();
		setVisible(true);
	}
	void init() {
		setLayout(new BorderLayout());
		northPanel = new JPanel();
		northPanel.setSize(400,100);
		resultField = new JButton();
		resultField.setSize(400, 100);
		northPanel.add(resultField);
		add(northPanel, BorderLayout.NORTH);
		
		centralPanel = new JPanel();
		centralPanel.setLayout(new GridLayout(4,4));
		add(centralPanel,BorderLayout.CENTER);
	}
	public static void main(String[] args) {
		new ComputeFrame();
	}

}
