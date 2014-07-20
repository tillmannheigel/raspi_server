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
		while (true) {
			System.out.println("waiting for incomming connections...");
			try {
				clientSocket = serverSocket.accept();
				this.sendCurrentStatus();
				System.out.println(clientSocket.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void sendCurrentStatus() {
		RequestThread requestThread = new RequestThread(clientSocket);
		requestThread.start();
	}
	
}
