package raspi_server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

public class ServerMain {

	public static void main(String[] args) {
		try {
			ServerSocket socket = new ServerSocket();
			socket.setReuseAddress(true);
			socket.bind(new InetSocketAddress(52396));
			Server server = new Server(socket);
			Thread serverThread = new Thread(server);
			serverThread.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
