package com.vic.Warrap.server;

public class ServerMain {
	private int port;
	public ServerMain(int port){
		this.port = port;
		new Server(port); //This line starts the server at the Parsed in Port. This is the very first thing we do.
	}

	public static void main(String[] args) {
		int port;
		if(args.length !=1){
			System.out.println("Usage: java -jar WarrapServer.jar [port]");
			return;
		}
		//System.out.println(args[0]);
		port = Integer.parseInt(args[0]);
		new ServerMain(port);

	}

}
