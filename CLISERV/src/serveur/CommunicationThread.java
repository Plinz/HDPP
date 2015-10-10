package serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import client.Client;

public class CommunicationThread implements Runnable {

	private Socket clientSocket;
	private BufferedReader inpout;
	
	public CommunicationThread(Socket clientSocket) {
		this.clientSocket = clientSocket;
		try{
			this.inpout = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
		}catch (IOException e){
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()){
			try {
				String read = this.inpout.readLine();
				String[] reponse = read.split("[:]");
				System.out.println("Recu :"+read);
				switch (reponse[0]){
						case "RGTR":
							String[] l = reponse[1].split("[|]");
							Client c = new Client(l[0], l[1], l[2], l[3], Integer.parseInt(l[4]), l[5], l[6], 500.0);
							Serveur.listClient.add(c);
						    c.setClientVoisins(Serveur.clientVoisins(c));
						    System.out.println("Registering OK");
							break;
						case "CO":
							break;
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
