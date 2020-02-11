package bda.meteo.alert.model;

import java.util.Date;

public class Indice {
	Date date;
	Double valeur;
	String couleur_html;
	String qualificatif;
	String type_valeur;
	
	public Indice() {}
	
	public Indice(Date date, Double valeur, String couleur_html, String qualificatif, String type_valeur) {
		super();
		this.date = date;
		this.valeur = valeur;
		this.couleur_html = couleur_html;
		this.qualificatif = qualificatif;
		this.type_valeur = type_valeur;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getValeur() {
		return valeur;
	}

	public void setValeur(Double valeur) {
		this.valeur = valeur;
	}

	public String getCouleur_html() {
		return couleur_html;
	}

	public void setCouleur_html(String couleur_html) {
		this.couleur_html = couleur_html;
	}

	public String getQualificatif() {
		return qualificatif;
	}

	public void setQualificatif(String qualificatif) {
		this.qualificatif = qualificatif;
	}

	public String getType_valeur() {
		return type_valeur;
	}

	public void setType_valeur(String type_valeur) {
		this.type_valeur = type_valeur;
	}
	
}
