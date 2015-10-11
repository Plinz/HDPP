package serveur;

import java.net.Socket;

public class ServeurTCP {
	private Thread serverThread = null;	
	
	public ServeurTCP() {
			this.serverThread = new Thread(new ServerThread());
			this.serverThread.start();
	}

	public static void main(String[] args){
		new ServeurTCP();
	}
}
