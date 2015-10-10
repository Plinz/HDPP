package client;

import java.util.UUID;

public class Service {
	private Client demandeur;
	private String titre;
	private String description;
	private UUID uuid;
	

	public Client getDemandeur() {
		return demandeur;
	}


	public void setDemandeur(Client demandeur) {
		this.demandeur = demandeur;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public UUID getUuid() {
		return uuid;
	}


	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}


	public Service(Client demandeur, String titre, String description, UUID uuid) {
		this.demandeur = demandeur;
		this.titre = titre;
		this.description = description;
		this.uuid = uuid;
	}
	
	public Service(Client demandeur, String titre, String description) {
		this.demandeur = demandeur;
		this.titre = titre;
		this.description = description;
		this.uuid = UUID.randomUUID();;
	}

	public Service(){
		
	}
	

	

}
