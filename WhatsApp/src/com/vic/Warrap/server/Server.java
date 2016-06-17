package com.vic.Warrap.server;

/*
 * This is how a String message is sent from a client to a server.
 * ---------------------------------------------------------------
 * We have a String.
 * convert it to bytes.
 * package it.
 * Use a Socket to send it. (A socket just kind of relaxes on a Port and waits to send stuff)
 * 
 * */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server implements Runnable {
	private int port;
	private DatagramSocket socket;
	private Thread run, manage, send, receive;
	private boolean running;

	public Server(int port) {
		this.port = port;
		try {
			socket = new DatagramSocket(port);
		} catch (SocketException e) {
			e.printStackTrace();
			return;
		}
		run = new Thread(this, "Server");
		run.start();
	}

	@Override
	public void run() {
		running = true;
		System.out.println("Server successfully started on port " + port);
		manageClients();
		receive();

	}

	private void manageClients() {
		manage = new Thread("Manage") {
			public void run() {
				while (running) {
					// Managing

				}
			}
		};
		manage.start();
	}

	private void receive() {
		receive = new Thread("Receive") {
			public void run() {
				while (running) {
					byte[] data = new byte[1024];
					DatagramPacket packet = new DatagramPacket(data, data.length);
					try {
						socket.receive(packet);
					} catch (IOException e) {

						e.printStackTrace();
					}
					String msg = new String(packet.getData());

				
				System.out.println(msg); //This is where this method prints the received message to the console
				} 

			}
		};
		receive.start();
	}

}
