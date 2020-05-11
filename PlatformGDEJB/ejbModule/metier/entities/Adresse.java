package metier.entities;

import java.io.Serializable;
import java.util.UUID;


import javax.persistence.Entity;

import javax.persistence.Id;




@Entity
public class Adresse implements Serializable {
	@Id
	private String idAdresse=UUID.randomUUID().toString();
	private String gouvernorat;
	private String adresse;
	private int codePostale;


	public String getIdAdresse() {
		return idAdresse;
	}

	public void setIdAdresse(String idAdresse) {
		this.idAdresse = idAdresse;
	}


	public Adresse(String gouvernorat, String adresse, int codePostale) {
		super();
		this.idAdresse = UUID.randomUUID().toString();
		this.gouvernorat = gouvernorat;
		this.adresse = adresse;
		this.codePostale = codePostale;
	}

	public Adresse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getGouvernorat() {
		return gouvernorat;
	}

	public void setGouvernorat(String gouvernorat) {
		this.gouvernorat = gouvernorat;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getCodePostale() {
		return codePostale;
	}

	public void setCodePostale(int codePostale) {
		this.codePostale = codePostale;
	}

}