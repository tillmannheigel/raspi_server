package raspi_server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketException;

public class ServerMain {

	public static void main(String[] args) {

		try {
			ServerSocket socket = new ServerSocket();
			socket.bind(new InetSocketAddress(51396));
			socket.setReuseAddress(true);
			Server server = new Server(socket);
			Thread serverThread = new Thread(server);
			serverThread.start();
		} catch (IOException e) {
			e.printStackTrace();

		}

	}
}
