package serveur;

import java.util.HashMap;

import client.Client;
import client.Service;

/**
 * 
 * @author dowan
 * a mettre sur le serveur OH really thanks captain obvious
 */
public class Serveur {
	private HashMap<String, Client> listClient;
	private HashMap<Client, Service> listService;
}
