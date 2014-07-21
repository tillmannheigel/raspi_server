package raspi_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class RequestThread extends Thread {
	
	private Socket clientSocket;

	public RequestThread(Socket socket) {
		clientSocket = socket;
	}

	@Override
	public void run() {
		
		System.out.println("Verbindung aufgebaut "+clientSocket.getRemoteSocketAddress() +".");
		try {
			PrintWriter out = new PrintWriter (clientSocket.getOutputStream(), true);
			out.println("Guten Tag");
			 BufferedReader bufferedReader = new BufferedReader(
				          new InputStreamReader(
				            clientSocket.getInputStream()));
		     char[] buffer = new char[100];
		     int anzahlZeichen = bufferedReader.read(buffer, 0, 100); 
			 if (anzahlZeichen>0) {
			     System.out.println("Nachricht empfangen. Länge: " +anzahlZeichen+".");
			 }
			 clientSocket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	

}
