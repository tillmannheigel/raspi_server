package raspi_server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{
	
	private ServerSocket serverSocket;
	private Socket clientSocket;

	public Server(ServerSocket socket) {
		serverSocket = socket;
	}

	@Override
	public void run() {
		System.out.println("++Startet new Server on port " + serverSocket.getLocalPort() + ".++");
		System.out.println("waiting for incomming connections...");
		System.out.println("Clients:");
		while (true) {
			try {
				clientSocket = serverSocket.accept();
				this.connect();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void connect() {
		RequestThread requestThread = new RequestThread(clientSocket);
		requestThread.start();
	}
	
}
