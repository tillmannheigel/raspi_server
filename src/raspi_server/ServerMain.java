package raspi_server;

public class ServerMain {
	
	public static void main(String[] args) {
		System.out.println("main");
		Server server = new Server(51296);
	}

}
