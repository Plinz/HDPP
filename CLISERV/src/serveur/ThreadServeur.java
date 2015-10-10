package serveur;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import client.Client;

public class ThreadServeur extends Thread {

	Serveur serveur;
	InputStream in;
	//OutputStream oout;
	
	public ThreadServeur(){}
	
	public ThreadServeur(Socket c) throws IOException{
	//	this.oout = new ObjectOutputStream(c.getOutputStream());
		this.in = new ObjectInputStream(c.getInputStream());
	}
	
	public void run (){
		try {
			System.out.println("Debut Lecture Socket");
			byte buf[] = new byte[1024];
			while (in.read(buf) != -1) {}
			this.in.close();
			System.out.println("Fin Lecture Socket");
			String tmp = new String(buf, "UTF-8");
			String[] reponse = tmp.split("[:]");
			System.out.println("Recu :"+tmp);
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
			System.exit(1);
		}
	}
}
