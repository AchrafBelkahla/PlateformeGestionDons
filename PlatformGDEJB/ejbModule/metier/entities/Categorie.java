package metier.entities;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="Categorie")
@NamedQuery(name="Categorie.findAll", query="SELECT p FROM Categorie p")

public class Categorie 
{
	@Id 
	private String idC;
	private String libelle;
	
	@OneToMany(mappedBy="categorie")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Produit> produits;
	
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Categorie(String libelle) {
		super();
		this.idC = UUID.randomUUID().toString();
		this.libelle = libelle;
	}
	public String getIdC() {
		return idC;
	}
	public void setIdC(String idC) {
		this.idC = idC;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public List<Produit> getProduits() {
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	
	
}