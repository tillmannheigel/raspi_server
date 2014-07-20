package raspi_server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{
	
	private ServerSocket mySocket;
	private Socket myClient;

	public Server(ServerSocket socket) {
		mySocket = socket;
	}

	@Override
	public void run() {
		System.out.println("++Startet new Server on port " + mySocket.getLocalPort() + ".++");
		while (true) {
			System.out.println("while");
			try {
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
