package raspi_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class RequestThread extends Thread {
	
	private Socket clientSocket;
	private Client client;

	public RequestThread(Socket socket) {
		clientSocket = socket;
		client = new Client();
	}

	@Override
	public void run() {
		
		System.out.println("Verbindung aufgebaut "+clientSocket.getRemoteSocketAddress() +".");
		try {
			while (true) {
			 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true );

			 BufferedReader bufferedReader = new BufferedReader(
				          new InputStreamReader(
				            clientSocket.getInputStream()));
		     char[] buffer = new char[1024];
		     int anzahlZeichen = bufferedReader.read(buffer, 0, 1024); 
		     String[] werte = new String(buffer).split("\\:"); 
			 if (anzahlZeichen>0) {
				 switch (werte[0]) {
				case "name":
					client.setName(werte[1]);
					System.out.println("new Client: "+werte[1]);
					out.write("Hello: " +werte[1]);
					break;

				default:
					break;
				}
			 }
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	

}
