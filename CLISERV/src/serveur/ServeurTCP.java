package serveur;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurTCP {
	private ServerSocket serveurSocket = null;
	private Socket unClient = null;
	
	public ServeurTCP(int port) {
		try {
			this.serveurSocket = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public void miseEnService() {
		while (true ) {
			try {
				
				System.out.println("Serveur Waiting Connexion");
				unClient = serveurSocket.accept();
				System.out.println("Connexion Etablished");
				ThreadServeur thread  = new ThreadServeur(unClient);
				System.out.println("Fin constructeur");
				thread.start();
				unClient.close();
				
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
