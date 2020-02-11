package bda.meteo.alert.model;

import java.util.Date;

public class Vigilance {
	Date date_debut;
	Date date_fin;
	String nom_procedure;
	String zone;
	String polluant;
	String niveau;
	Integer seuil;
	String commentaire;
	
	public Vigilance() {}
	
	public Vigilance(Date date_debut, Date date_fin, String nom_procedure, String zone, String polluant, String niveau,
			Integer seuil, String commentaire) {
		super();
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.nom_procedure = nom_procedure;
		this.zone = zone;
		this.polluant = polluant;
		this.niveau = niveau;
		this.seuil = seuil;
		this.commentaire = commentaire;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public String getNom_procedure() {
		return nom_procedure;
	}

	public void setNom_procedure(String nom_procedure) {
		this.nom_procedure = nom_procedure;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getPolluant() {
		return polluant;
	}

	public void setPolluant(String polluant) {
		this.polluant = polluant;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public Integer getSeuil() {
		return seuil;
	}

	public void setSeuil(Integer seuil) {
		this.seuil = seuil;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
}
