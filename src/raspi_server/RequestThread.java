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
		
		System.out.println("RequestThread für Port "+clientSocket.getLocalPort()+" läuft.");
		try {
			PrintWriter out = new PrintWriter (clientSocket.getOutputStream(), true);
			out.println("Guten Tag");
			 BufferedReader bufferedReader = new BufferedReader(
				          new InputStreamReader(
				            clientSocket.getInputStream()));
			
			 System.out.println("Nachricht empfangen");
			 clientSocket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	

}
