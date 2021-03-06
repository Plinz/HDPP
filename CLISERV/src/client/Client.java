package client;

import google.AddressConverter;
import google.GoogleResponse;
import google.Result;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;


/**
 * 
 * @author tamere
 * 
 */

public class Client extends Observable implements Observer {

	private String adresse;
	private double[] coord = new double[2];
	private String email;
	private String nom;
	private String prenom;
	private int age;
	private String sexe;
	private String mdp;
	private ArrayList<Service> listOwnService;
	private ArrayList<Service> listOtherService;
	private ArrayList<Service> listAttente;
	private ArrayList<Client> clientVoisins;
	private double distance;

	public void addListOwnService(Service serv){
		this.listOwnService.add(serv);
		this.setChanged();
		this.notifyObservers(serv);
	}
	
	public ArrayList<Client> getClientVoisins() {
		return clientVoisins;
	}

	public void setClientVoisins(ArrayList<Client> clientVoisins) {
		this.listOtherService = new ArrayList<Service>();
		for (int i=0; i<this.clientVoisins.size(); i++)
			this.clientVoisins.get(i).deleteObserver(this);
		this.clientVoisins = clientVoisins;
		for (int i=0; i<this.clientVoisins.size(); i++){
			this.clientVoisins.get(i).addObserver(this);
			for (int j=0; j<this.clientVoisins.get(i).getListOwnService().size(); j++)
				this.listOtherService.add(this.clientVoisins.get(i).getListOwnService().get(j));
		}
	}
	
	public void addClientVoisins(Client clientVoisin){
		clientVoisin.addObserver(this);
		this.clientVoisins.add(clientVoisin);
		for (int j=0; j<clientVoisin.getListOwnService().size(); j++)
			this.listOtherService.add(clientVoisin.getListOwnService().get(j));
	}
	
	public void removeClientVoisin(Client clientVoisin){
		clientVoisin.deleteObserver(this);
		this.clientVoisins.remove(clientVoisin);
		for (int i=0; i<clientVoisin.getListOwnService().size(); i++)
			this.listOtherService.remove(clientVoisin.getListOwnService().get(i));
	}

	public ArrayList<Service> getListAttente() {
		return listAttente;
	}

	public void setListAttente(ArrayList<Service> listAttente) {
		this.listAttente = listAttente;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public ArrayList<Service> getListOwnService() {
		return listOwnService;
	}

	public void setListOwnService(ArrayList<Service> listOwnService) {
		this.listOwnService = listOwnService;
	}

	public double[] getCoord() {
		return coord;
	}

	public void setCoord(double[] coord) {
		this.coord = coord;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	public Client() {}

	public Client(String adresse, String email, String nom, String prenom,
			int age, String sexe, String mdp, double distance) throws IOException {
		super();
		this.adresse = adresse;
		this.coord = new double[2];
		GoogleResponse res = new AddressConverter()
				.convertToLatLong(this.adresse);
		if (res.getStatus().equals("OK")) {
			for (Result result : res.getResults()) {
				this.coord[0] = Double.parseDouble(result.getGeometry()
						.getLocation().getLat());
				this.coord[1] = Double.parseDouble(result.getGeometry()
						.getLocation().getLng());
			}
		}
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.sexe = sexe;
		this.mdp = mdp;
		this.listOwnService = new ArrayList<Service>();
		this.listOwnService = new ArrayList<Service>();
		this.distance = distance;
		this.listAttente = new ArrayList<Service>();
	}

	public static void main(String[] args) throws IOException {
		double[] coordA = new double[2];
		double[] coordB = new double[2];
		GoogleResponse res = new AddressConverter()
				.convertToLatLong("RueClaudeGardelein+136,Dunkerque,France,59140");
		if (res.getStatus().equals("OK")) {
			for (Result result : res.getResults()) {
				coordA[0] = Double.parseDouble(result.getGeometry()
						.getLocation().getLat());
				coordA[1] = Double.parseDouble(result.getGeometry()
						.getLocation().getLng());
			}
		}
		GoogleResponse res2 = new AddressConverter()
				.convertToLatLong("RueClaudeGardelein+76,Dunkerque,France,59140");
		if (res2.getStatus().equals("OK")) {
			for (Result result : res2.getResults()) {
				coordB[0] = Double.parseDouble(result.getGeometry()
						.getLocation().getLat());
				coordB[1] = Double.parseDouble(result.getGeometry()
						.getLocation().getLng());
			}
		}
		double d = calcul.Distance.calcul(coordA, coordB);
		System.out.println("Distance = "+d);
	}
	
	@Override
	public void update(Observable obs, Object serv) {
		
	}

}
