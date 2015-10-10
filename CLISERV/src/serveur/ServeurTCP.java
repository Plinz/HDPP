package serveur;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurTCP {
	private ServerSocket serveurSocket = null;
	
	public ServeurTCP(int port) {
		try {
			serveurSocket = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public void miseEnService() {
		Socket unClient = null;
		ThreadServeur thread;
		while (true ) {
			try {
				System.out.println("Serveur Waiting Connexion");
				unClient = serveurSocket.accept();
				System.out.println("Connexion Etablished");
				thread = new ThreadServeur(unClient);
				thread.start();
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}

	public static void main(String[] args){
		ServeurTCP serv = new ServeurTCP( 4242);
		serv.miseEnService();
	}
}
