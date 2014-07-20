package raspi_server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{
	
	private ServerSocket mySocket;
	private Socket myClient;
	private int myPort;

	public Server(int port) {
		myPort = port;
	}

	@Override
	public void run() {
		System.out.println("Startet new Server on port " + myPort + ".");
		while (true) {
			try {
				mySocket = new ServerSocket(myPort);
				myClient = mySocket.accept();
				System.out.println(myClient.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Stopped Server");
				e.printStackTrace();
			}
		}
	}
	
}
