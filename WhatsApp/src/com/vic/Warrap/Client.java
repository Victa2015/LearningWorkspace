package com.vic.Warrap;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;

import java.awt.GridBagLayout;
import javax.swing.JTextArea;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Client extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String name, address;
	private int port;
	private JTextField txtMessage;
	private JTextArea txtHistory;
	private JButton btnSend;
	DefaultCaret caret;
	InetAddress ip;
	DatagramSocket socket;
	Thread send;

	public Client(String name, String address, int port) {
		this.name = name;
		this.port = port;
		this.address = address;

		boolean connect = openConnection(address);
		if (!connect) {
			System.err.println("Connection Failed!");
			console("Connection Failed! ");
		}
		createWindow();
		console("Connecting to " + name);
		String connection_notify = name + " connected from " + address  + " on port " + port;
		send(connection_notify.getBytes());

	}

	private String receive() {
		byte[] data = new byte[1024];
		DatagramPacket packet = new DatagramPacket(data, data.length);
		try {
			socket.receive(packet);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String message = new String(packet.getData());
		return message;
	}

	private void send(final byte[] data) {
		send = new Thread("Send") {
			public void run() {
				DatagramPacket packet = new DatagramPacket(data, data.length, ip, port);
				try {
					socket.send(packet); //This is where it happens.
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		send.start();
	}

	private boolean openConnection(String address) {
		try {
			socket = new DatagramSocket();
			ip = InetAddress.getByName(address);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	private void createWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Warrap Client");
		setSize(880, 550);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 16, 803, 30, 7 };
		gbl_contentPane.rowHeights = new int[] { 35, 475, 40 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0 };
		gbl_contentPane.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		txtHistory = new JTextArea();
		txtHistory.setEditable(false);
		caret = (DefaultCaret) txtHistory.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		JScrollPane scroll = new JScrollPane(txtHistory);
		GridBagConstraints scrollConstraints = new GridBagConstraints();
		scrollConstraints.insets = new Insets(0, 0, 5, 5);
		scrollConstraints.fill = GridBagConstraints.BOTH;
		scrollConstraints.gridx = 0;
		scrollConstraints.gridy = 0;
		scrollConstraints.gridwidth = 3;
		scrollConstraints.gridheight = 2;
		scrollConstraints.insets = new Insets(0, 5, 0, 0);
		contentPane.add(scroll, scrollConstraints);

		txtMessage = new JTextField();
		txtMessage.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					send(txtMessage.getText());
				}
			}
		});
		GridBagConstraints gbc_txtMessage = new GridBagConstraints();
		gbc_txtMessage.anchor = GridBagConstraints.NORTH;
		gbc_txtMessage.insets = new Insets(5, 0, 0, 5);
		gbc_txtMessage.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMessage.gridx = 0;
		gbc_txtMessage.gridwidth = 2;
		gbc_txtMessage.gridy = 2;

		contentPane.add(txtMessage, gbc_txtMessage);
		txtMessage.setColumns(10);

		btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				send(txtMessage.getText());
			}
		});
		GridBagConstraints gbc_btnSend = new GridBagConstraints();
		gbc_btnSend.insets = new Insets(0, 0, 0, 5);
		gbc_btnSend.gridx = 2;
		gbc_btnSend.gridy = 2;
		contentPane.add(btnSend, gbc_btnSend);

		setVisible(true);
		txtMessage.requestFocusInWindow();
	}

	public void send(String message) {
		if (message.equals(""))
			return;

		message = name + ":  " + message;
		console(message);
		send(message.getBytes());

		txtMessage.setText("");

	}

	public void console(String message) {
		txtHistory.append(message + "\n\r");
		txtHistory.setCaretPosition(txtHistory.getDocument().getLength());
	}
}
