package metier.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_DON", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("D")
public class Don implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private String id_don;
	private Date DatePlanifiee;
	private boolean estAccepte;
	private boolean estSupprime;
	private String visibilite;
	private boolean vu;
	
	@OneToOne
	private Besoin besoin;
	
	@ManyToOne
	private Utilisateur utilisateur;
	
	@OneToOne( cascade = CascadeType.ALL )
	private PhotoDon photoDon;
	
	@ManyToOne
	private Etablisement etablissement;
	
	
	public Don() {
		this.id_don = UUID.randomUUID().toString();
	}
	public Don(Date datePlanifiee, boolean estAccepte, boolean estSupprime, String visibilite, boolean vu) {
		this.id_don = UUID.randomUUID().toString();
		DatePlanifiee = datePlanifiee;
		this.estAccepte = estAccepte;
		this.estSupprime = estSupprime;
		this.visibilite = visibilite;
		this.vu = vu;
	}
	
	public Don(Date datePlanifiee, String visibilite) {
		this.id_don = UUID.randomUUID().toString();
		DatePlanifiee = datePlanifiee;
		this.visibilite = visibilite;
	}
	//public Collection<Utilisateur> getUtilisateur() {
	//	return utilisateur;
	//}
	//public void setUtilisateur(Collection<Utilisateur> utilisateur) {
	//	this.utilisateur = utilisateur;
	//}
	public PhotoDon getPhoto_don() {
		return photoDon;
	}
	public void setPhoto_don(PhotoDon photoDon) {
		this.photoDon = photoDon;
	}
	public String getId_don() {
		return this.id_don;
	}
	public void setId_don(String id_don) {
		this.id_don = id_don;
	}
	public Date getDatePlanifiee() {
		return DatePlanifiee;
	}
	public void setDatePlanifiee(Date datePlanifiee) {
		DatePlanifiee = datePlanifiee;
	}
	public boolean isEstAccepte() {
		return estAccepte;
	}
	public void setEstAccepte(boolean estAccepte) {
		this.estAccepte = estAccepte;
	}
	public boolean isEstSupprime() {
		return estSupprime;
	}
	public void setEstSupprime(boolean estSupprime) {
		this.estSupprime = estSupprime;
	}
	public String getVisibilite() {
		return visibilite;
	}
	public void setVisibilite(String visibilite) {
		this.visibilite = visibilite;
	}
	public boolean isVu() {
		return vu;
	}
	public void setVu(boolean vu) {
		this.vu = vu;
	}
	public PhotoDon getPhotoDon() {
		return photoDon;
	}
	public void setPhotoDon(PhotoDon photoDon) {
		this.photoDon = photoDon;
	}
	public Etablisement getEtablissement() {
		return etablissement;
	}
	public void setEtablissement(Etablisement etablissement) {
		this.etablissement = etablissement;
	}
	public Besoin getBesoin() {
		return besoin;
	}
	public void setBesoin(Besoin besoin) {
		this.besoin = besoin;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
}