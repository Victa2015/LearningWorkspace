package com.vic.Warrap;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtIP;
	private JLabel lbIP;
	private JLabel lbeg;
	private JLabel lbPort;
	private JTextField txtPort;
	private JLabel lbeg1;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Login() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setTitle("Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,380);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtName = new JTextField();
		txtName.setBounds(70, 44, 160, 26);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lbName = new JLabel("Name");
		lbName.setBounds(128, 27, 43, 16);
		contentPane.add(lbName);
		
		txtIP = new JTextField();
		txtIP.setBounds(70, 103, 160, 26);
		contentPane.add(txtIP);
		txtIP.setColumns(10);
		
		lbIP = new JLabel("IP Adress:");
		lbIP.setBounds(118, 89, 63, 16);
		contentPane.add(lbIP);
		
		lbeg = new JLabel("(eg. 192.168.1.1)");
		lbeg.setBounds(94, 130, 112, 16);
		contentPane.add(lbeg);
		
		lbPort = new JLabel("Port");
		lbPort.setBounds(134, 173, 31, 16);
		contentPane.add(lbPort);
		
		txtPort = new JTextField();
		txtPort.setColumns(10);
		txtPort.setBounds(70, 189, 160, 26);
		contentPane.add(txtPort);
		
		lbeg1 = new JLabel("(eg. 8167)");
		lbeg1.setBounds(118, 216, 63, 16);
		contentPane.add(lbeg1);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				String address = txtIP.getText();
				int port = Integer.parseInt(txtPort.getText());
				login(name, address, port);
			}
		});
		btnLogin.setBounds(91, 309, 117, 29);
		contentPane.add(btnLogin);
	}
	private void login(String name, String address, int port){
		new Client(name,address,port);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
