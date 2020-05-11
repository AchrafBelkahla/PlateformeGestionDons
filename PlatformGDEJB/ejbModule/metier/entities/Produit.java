package metier.entities;


import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;

import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table(name="Produit")
@NamedQuery(name="Produit.findAll", query="SELECT p FROM Produit p")
public class Produit 
{
	@Id 
	private String idProduit;
	private String libelle;
	private String descriptionTechnique;
	private double prixMax;
	private double prixMin;
	
	@ManyToOne
	private UniteDeMesure uniteDeMesure;
	
	@ManyToOne
	private Categorie categorie;

	@ManyToMany(mappedBy = "produits")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Fournisseur> fournisseurs;


	
	
	public Produit() {	
		super();	
		this.idProduit = UUID.randomUUID().toString();
	}
	
	
	public Produit( String libelle, String descriptionTechnique, 
			double prixMax, double prixMin ) {
		super();
		
		this.idProduit = UUID.randomUUID().toString();
		this.libelle = libelle;
		this.descriptionTechnique = descriptionTechnique;
		this.prixMax = prixMax;
		this.prixMin = prixMin;
	}
	public String getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(String idProduit) {
		this.idProduit = idProduit;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getDescriptionTechnique() {
		return descriptionTechnique;
	}
	public void setDescriptionTechnique(String descriptionTechnique) {
		this.descriptionTechnique = descriptionTechnique;
	}
	public double getPrixMax() {
		return prixMax;
	}
	public void setPrixMax(double prixMax) {
		this.prixMax = prixMax;
	}
	public double getPrixMin() {
		return prixMin;
	}
	public void setPrixMin(double prixMin) {
		this.prixMin = prixMin;
	}

	public UniteDeMesure getUniteDeMesure() {
		return uniteDeMesure;
	}


	public void setUniteDeMesure(UniteDeMesure uniteDeMesure) {
		this.uniteDeMesure = uniteDeMesure;
	}


	public Categorie getCategorie() {
		return categorie;
	}


	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	public List<Fournisseur> getFournisseurs() {
		return fournisseurs;
	}


	public void setFournisseurs(List<Fournisseur> fournisseurs) {
		this.fournisseurs = fournisseurs;
	}


	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", libelle=" + libelle + ", descriptionTechnique="
				+ descriptionTechnique + ", prixMax=" + prixMax + ", prixMin=" + prixMin + ", uniteDeMesure="
				+ uniteDeMesure + ", categorie=" + categorie + ", fournisseurs=" + fournisseurs + "]";
	}
	

}
