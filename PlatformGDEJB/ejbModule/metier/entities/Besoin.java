package metier.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Besoin")
@NamedQuery(name="Besoin.findAll", query="SELECT b FROM Besoin b ORDER BY b.dateBesoin DESC")
public class Besoin implements Serializable 
{

	@Id
	private String idBesoin;
	private Date dateBesoin;
	private String etat;
	private int quantiteInitiale;
	private int quantiteRestante;
	private String priorite;
	private boolean annule;
	private String motif;
	private Boolean reaffected;
	
	@OneToOne
	private Produit produit;
	
	@ManyToOne
	private PhotoBesoin photoBesoin;

	@ManyToOne
	private Etablisement etablisement;

	
	public Besoin() {
		super();
		this.idBesoin = UUID.randomUUID().toString();
	}
	
	
	
	public Besoin( Date dateBesoin, String etat, int quantiteInitiale, int quantiteRestante,
			String priorite, boolean annule, String motif) {
		super();
		

		this.idBesoin = UUID.randomUUID().toString();
		this.dateBesoin = dateBesoin;
		this.etat = etat;
		this.quantiteInitiale = quantiteInitiale;
		this.quantiteRestante = quantiteRestante;
		this.priorite = priorite;
		this.annule = annule;
		this.motif = motif;
	}
	
	
	public String getIdBesoin() {
		return idBesoin;
	}
	public void setIdBesoin(String idBesoin) {
		this.idBesoin = idBesoin;
	}
	public Date getDateBesoin() {
		return dateBesoin;
	}
	public void setDateBesoin(Date dateBesoin) {
		this.dateBesoin = dateBesoin;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public int getQuantiteInitiale() {
		return quantiteInitiale;
	}
	public void setQuantiteInitiale(int quantiteInitiale) {
		this.quantiteInitiale = quantiteInitiale;
	}
	public int getQuantiteRestante() {
		return quantiteRestante;
	}
	public void setQuantiteRestante(int quantiteRestante) {
		this.quantiteRestante = quantiteRestante;
	}
	public String getPriorite() {
		return priorite;
	}
	public void setPriorite(String priorite) {
		this.priorite = priorite;
	}
	public boolean isAnnule() {
		return annule;
	}
	public void setAnnule(boolean annule) {
		this.annule = annule;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public PhotoBesoin getPhotoBesoin() {
		return photoBesoin;
	}
	public void setPhotoBesoin(PhotoBesoin photoBesoin) {
		this.photoBesoin = photoBesoin;
	}



	public Etablisement getEtablisement() {
		return etablisement;
	}



	public void setEtablisement(Etablisement etablisement) {
		this.etablisement = etablisement;
	}



	public Boolean getReaffected() {
		return reaffected;
	}



	public void setReaffected(Boolean reaffected) {
		this.reaffected = reaffected;
	}



	@Override
	public String toString() {
		return "Besoin [idBesoin=" + idBesoin + ", dateBesoin=" + dateBesoin + ", etat=" + etat + ", quantiteInitiale="
				+ quantiteInitiale + ", quantiteRestante=" + quantiteRestante + ", priorite=" + priorite + ", annule="
				+ annule + ", motif=" + motif + ", produit=" + produit + ", photoBesoin=" + photoBesoin + "]";
	}




}