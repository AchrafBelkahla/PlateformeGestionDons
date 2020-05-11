package metier.entities;

import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "Fournisseur")
@NamedQuery(name="Fournisseur.findAll", query="SELECT f FROM Fournisseur f")
public class Fournisseur 
{
	@Id 
	private String idF;
	private String Libelle;
	private String emailF;
	private String adresseF;
	private String gouvernorat;
	private String codePostal;
	private long numTelF;
	
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Produit> produits;
	
	public Fournisseur() {
		super();
		this.idF = UUID.randomUUID().toString();
	}
	public Fournisseur(String libelle) {
		super();
		this.idF = UUID.randomUUID().toString();
		this.Libelle = libelle;
	}	
	
	public Fournisseur(String libelle, String emailF, String adresseF, String gouvernorat, String codePostal,
			long numTelF) {
		super();
		this.idF = UUID.randomUUID().toString();
		this.Libelle = libelle;
		this.emailF = emailF;
		this.adresseF = adresseF;
		this.gouvernorat = gouvernorat;
		this.codePostal = codePostal;
		this.numTelF = numTelF;
	}
	public String getLibelle() {
		return Libelle;
	}
	public void setLibelle(String libelle) {
		Libelle = libelle;
	}
	public String getIdF() {
		return idF;
	}
	public void setIdF(String idF) {
		this.idF = idF;
	}
	public String getEmailF() {
		return emailF;
	}
	public void setEmailF(String emailF) {
		this.emailF = emailF;
	}
	public String getAdresseF() {
		return adresseF;
	}
	public void setAdresseF(String adresseF) {
		this.adresseF = adresseF;
	}
	public long getNumTelF() {
		return numTelF;
	}
	public void setNumTelF(long numTelF) {
		this.numTelF = numTelF;
	}
	public List<Produit> getProduits() {
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	public String getGouvernorat() {
		return gouvernorat;
	}
	public void setGouvernorat(String gouvernorat) {
		this.gouvernorat = gouvernorat;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	
	
	
	

}