package serveur;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import client.Client;

public class ThreadServeur extends Thread {

	Serveur serveur;
	Socket client;
	ObjectInputStream in;
	ObjectOutputStream out;
	
	public ThreadServeur(){}
	
	public ThreadServeur(Socket client) throws IOException{
		this.in = new ObjectInputStream(client.getInputStream());
		this.out = new ObjectOutputStream(client.getOutputStream());
		this.client = client;
	}
	
	public void run (){
		try {
			byte buf[] = new byte[1024];
			while (in.read(buf) != -1) {}
			this.in.close();
			
			String[] reponse = new String(buf, "UTF-8").split("[:]");
			switch (reponse[0]){
					case "RGTR":
						String[] l = reponse[1].split("[|]");
						Client c = new Client(l[0], l[1], l[2], l[3], Integer.parseInt(l[4]), l[5], l[6], 500.0);
						Serveur.listClient.add(c);
					    c.setClientVoisins(Serveur.clientVoisins(c));
						break;
					case "CO":
						break;
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
