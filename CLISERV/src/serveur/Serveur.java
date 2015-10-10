package serveur;

import java.util.ArrayList;
import java.util.HashMap;

import calcul.Distance;
import client.Client;
import client.Service;

/**
 * 
 * @author dowan
 * a mettre sur le serveur OH really thanks captain obvious
 */
public class Serveur {
	public static ArrayList<Client> listClient;
	public static HashMap<Client, Service> listService;

	public static ArrayList<Client> clientVoisins(Client ref){
		double d = ref.getDistance();
		ArrayList<Client> ret = new ArrayList<Client>();
		for (int i=0; i<listClient.size(); i++){
			if (Distance.calcul(listClient.get(i).getCoord(), ref.getCoord())<=d){
				ret.add(listClient.get(i));
			}
		}
		return ret;
	}
}
