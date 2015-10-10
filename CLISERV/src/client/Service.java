package client;

import java.util.ArrayList;
import java.util.UUID;

public class Service {
	private Client demandeur;
	private String titre;
	private String description;
	private UUID uuid;
	private ArrayList<String> commentaires;

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
		this.commentaires = new ArrayList<String>();
	}

	public Service(Client demandeur, String titre, String description) {
		this.demandeur = demandeur;
		this.titre = titre;
		this.description = description;
		this.uuid = UUID.randomUUID();
		;
	}

	public Service() {
		this.commentaires = new ArrayList<String>();
	}

	public void addComment(String comment) {
		this.commentaires.add(comment);
	}

	public ArrayList<String> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(ArrayList<String> commentaires) {
		this.commentaires = commentaires;
	}
}
