package metier.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="unitedemesure")
@NamedQuery(name="UniteDeMesure.findAll", query="SELECT p FROM UniteDeMesure p")

public class UniteDeMesure 
{
	@Id 
	private String idUnite;

	
	@OneToMany(mappedBy="uniteDeMesure")
	private Collection<Produit> produits;
	

	public UniteDeMesure(String idUnite) {
		super();
		this.idUnite = idUnite;
	}

	public UniteDeMesure() {
		super();
	}

	public String getIdUnite() {
		return idUnite;
	}

	public void setIdUnite(String idUnite) {
		this.idUnite = idUnite;
	}

	public Collection<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Collection<Produit> produits) {
		this.produits = produits;
	}
	
	
	
	
}