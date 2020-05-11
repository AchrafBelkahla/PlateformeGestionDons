package metier.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("D_enNature")
public class DonEnNature extends Don implements Serializable{
	
	private double prix_totale;
	private int quantite;
	
	
	public DonEnNature() {
		super();
	}


	public DonEnNature(Date date_planifiee, boolean estAcceptee, boolean estSupprimee, String visibilite,
			double prix_totale2, int quantite2, boolean vu) {
		super(date_planifiee, estAcceptee, estSupprimee, visibilite,vu);
		this.prix_totale = prix_totale2;
		this.quantite = quantite2;
	}
	public double getPrix_totale() {
		return prix_totale;
	}

	public void setPrix_totale(double prix_totale) {
		this.prix_totale = prix_totale;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	
}