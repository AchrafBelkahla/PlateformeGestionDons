package metier.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@DiscriminatorValue("D_reglement")
public class Reglement extends Don{
	
	private double montant;
	private Date dateReglement;
	//cheque ou bien virement bancaire
	private String modeReglement;
	
	
	public Reglement() {
		super();
	}


	public Reglement(Date date_planifiee, boolean estAcceptee, boolean estSupprimee, String visibilite,
			double montant2, Date date_reglement, String mode_reglement, boolean vu) {
		super(date_planifiee, estAcceptee, estSupprimee, visibilite, vu);
		this.montant = montant2;
		this.dateReglement = date_reglement;
		this.modeReglement = mode_reglement;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Date getDateReglement() {
		return dateReglement;
	}

	public void setDateReglement(Date dateReglement) {
		this.dateReglement = dateReglement;
	}

	public String getModeReglement() {
		return modeReglement;
	}

	public void setModeReglement(String modeReglement) {
		this.modeReglement = modeReglement;
	}
	
	
}