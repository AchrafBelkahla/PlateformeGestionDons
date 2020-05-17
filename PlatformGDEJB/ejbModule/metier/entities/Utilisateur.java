package metier.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.UUID; 

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "Utilisateur")
public class Utilisateur implements Serializable {
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = 1L;
	@Id
	private String idut=UUID.randomUUID().toString();
	private String email;
	private String Nom;
	private String Prenom;
	private String mdp;
	private Boolean etatDecompte;
	private String role;
	private Boolean accepted;
	private Boolean confirmed;
	private String confirmId;
	
	@OneToMany(targetEntity = Reclamation.class, mappedBy = "utilisateur")
	private Collection<Reclamation> reclamations;


	@OneToOne
	private Adresse adresse;

	@OneToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	//@JoinTable(name = "T_UTILISATEUR_TELEPHONE", joinColumns = @JoinColumn(name = "idut"), inverseJoinColumns = @JoinColumn(name = "IdTel"))
	private List<Telephone> telephone;

	

	@ManyToOne
	private Etablisement etablissement;

	
	@OneToMany(mappedBy="utilisateur", fetch = FetchType.EAGER)
	private List<Don> dons;
	
	public Utilisateur(String email, String nom, String prenom, String mdp, Boolean etatDecompte, String role) {
		super();
		this.idut = UUID.randomUUID().toString();
		this.email = email;
		Nom = nom;
		Prenom = prenom;
		this.mdp = mdp;
		this.etatDecompte = etatDecompte;
		this.role = role;
		this.confirmed = false;
	}

	public String getIdut() {
		return idut;
	}

	public void setIdut(String idut) {
		this.idut = idut;
	}

	public Collection<Reclamation> getReclamations() {
		return reclamations;
	}

	public void setReclamations(Collection<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}

	public List<Telephone> getTelephone() {
		return telephone;
	}

	public void setTelephone(List<Telephone> telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Boolean getEtatDecompte() {
		return etatDecompte;
	}

	public void setEtatDecompte(Boolean etatDecompte) {
		this.etatDecompte = etatDecompte;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Collection<Reclamation> getReclamation() {
		return reclamations;
	}

	public void setReclamation(Collection<Reclamation> reclamation) {
		this.reclamations = reclamation;
	}



	public List<Don> getDons() {
		return dons;
	}

//	public void setDons(List<Don> dons) {
//		this.dons = dons;
//	}
	public void addDon(Don don) 
	{
		dons.add(don);
	    don.setUtilisateur(this);
    }

	public Boolean getAccepted() {
		return accepted;
	}

	public void setAccepted(Boolean accepted) {
		this.accepted = accepted;
	}

	public Etablisement getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(Etablisement etablissement) {
		this.etablissement = etablissement;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getConfirmId() {
		return confirmId;
	}

	public void setConfirmId(String confirmId) {
		this.confirmId = confirmId;
	}

	public Boolean getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(Boolean confirmed) {
		this.confirmed = confirmed;
	}
	
}