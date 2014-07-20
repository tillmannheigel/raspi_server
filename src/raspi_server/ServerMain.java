package raspi_server;

public class ServerMain {
	
	public static void main(String[] args) {
		Server server = new Server(50296);
		Thread serverThread = new Thread(server);
		serverThread.start();
	}

}
