package client;

import java.io.IOException;

import google.AddressConverter;
import google.GoogleResponse;
import google.Result;

/**
 * 
 * @author tamere
 * 
 */

public class Client {

	private String adresse;
	private double[] coord;
	private String email;
	private String nom;
	private String prenom;
	private int age;
	private String sexe;
	private String mdp;

	public String getAdresse() {
		return adresse;
	}

	public void setAddress(String adresse) {
		this.adresse = adresse;
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

	public Client() {
		this.adresse = null;
		this.age = -1;
		this.coord = null;
		this.email = null;
		this.mdp = null;
		this.nom = null;
		this.prenom = null;
		this.sexe = null;
	}

	public Client(String adresse, double[] coord, String email, String nom,
			String prenom, int age, String sexe, String mdp) {
		super();
		this.adresse = adresse;
		this.coord = coord;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.sexe = sexe;
		this.mdp = mdp;
	}

	public Client(String adresse, String email, String nom, String prenom,
			int age, String sexe, String mdp) throws IOException {
		super();
		this.adresse = adresse;
		GoogleResponse res = new AddressConverter()
				.convertToLatLong(this.adresse);
		if (res.getStatus().equals("OK")) {
			for (Result result : res.getResults()) {
				this.coord[0] = Double.parseDouble(result.getGeometry().getViewport().getNortheast().getLat());
				this.coord[1] = Double.parseDouble(result.getGeometry().getViewport().getNortheast().getLng());
				this.coord[2] = Double.parseDouble(result.getGeometry().getViewport().getSouthwest().getLat());
				this.coord[3] = Double.parseDouble(result.getGeometry().getViewport().getSouthwest().getLng());
			}
		}
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.sexe = sexe;
		this.mdp = mdp;
	}

}
