package raspi_server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class RequestThread extends Thread {
	
	private Socket clientSocket;

	public RequestThread(Socket socket) {
		clientSocket = socket;
	}

	@Override
	public void run() {
		
		
		try {
			PrintWriter out = new PrintWriter (clientSocket.getOutputStream(), true);
			out.println("Guten Tag");
			clientSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	

}
