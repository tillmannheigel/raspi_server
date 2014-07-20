package raspi_server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private ServerSocket mySocket;
	private Socket myClient;

	Server(int port){
		try {
			mySocket = new ServerSocket(port);
			myClient = mySocket.accept();
			System.out.println(myClient.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
