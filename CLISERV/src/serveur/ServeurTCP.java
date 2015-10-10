package serveur;

import java.net.Socket;

public class ServeurTCP {
	private Thread serverThread = null;
	private Socket unClient = null;
	
	
	public ServeurTCP() {
			this.serverThread = new Thread(new ServerThread());
			this.serverThread.start();
	}
/*	
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
*/
	public static void main(String[] args){
		new ServeurTCP();
//		serv.miseEnService();
	}
}
