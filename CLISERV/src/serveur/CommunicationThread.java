package serveur;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import client.Client;
import client.Service;

public class CommunicationThread implements Runnable {

	private Socket clientSocket;
	private BufferedReader input;
	private BufferedWriter output;
	
	public CommunicationThread(Socket clientSocket) {
		this.clientSocket = clientSocket;
		try{
			this.input = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
			this.output = new BufferedWriter(new OutputStreamWriter(this.clientSocket.getOutputStream()));
		}catch (IOException e){
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()){
			try {
				String read = this.input.readLine();
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
						case "SERVICE":
							String[] n = reponse[1].split("[|]");
							Client cl = Serveur.getClientByEmail(n[0]);
							new Service(cl, n[1], n[2]); 
							break;
						case "REFRESH":
							Client cl2 = Serveur.getClientByEmail(reponse[1]);
							PrintWriter out = new PrintWriter(this.output);
							String sout = "SERVICE:";
							for (int k=0; k<cl2.getClientVoisins().size(); k++){
								for (int r=0; r<cl2.getClientVoisins().get(k).getListOwnService().size(); r++){
									Service stmp = cl2.getClientVoisins().get(k).getListOwnService().get(r);
									sout += cl2.getEmail() + "|" + stmp.getTitre() + "|" + stmp.getDescription() + ":";
								}
							}
							sout.substring(0, sout.length()-1);
							out.println(sout);
							break;
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
