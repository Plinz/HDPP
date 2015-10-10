package client;

import google.AddressConverter;
import google.GoogleResponse;
import google.Result;

import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * @author tamere
 * 
 */

public class Client {

	private String adresse;
	private double[] coord = new double[2];
	private String email;
	private String nom;
	private String prenom;
	private int age;
	private String sexe;
	private String mdp;
	private ArrayList<Service> listService;
	private ArrayList<Service> listAttente;
	private double distance;

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

	public ArrayList<Service> getListService() {
		return listService;
	}

	public void setListService(ArrayList<Service> listService) {
		this.listService = listService;
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

	public Client(String adresse, double[] coord, String email, String nom,
			String prenom, int age, String sexe, String mdp,
			ArrayList<Service> listService, double distance, ArrayList<Service> listAttente) {
		this.listAttente = listAttente;
		this.adresse = adresse;
		this.coord = coord;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.sexe = sexe;
		this.mdp = mdp;
		this.listService = listService;
		this.distance = distance;
	}

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
		this.listService = new ArrayList<Service>();
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

}
