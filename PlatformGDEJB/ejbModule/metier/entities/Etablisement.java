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

import org.hibernate.annotations.*;

@Entity
public class Etablisement implements Serializable {
	@Id
	private String IdEtablissement=UUID.randomUUID().toString();
	private String NomEtablissement;
	private Boolean Intermediaire;
	private Boolean ministraire;
	private Boolean hospital;
	private Boolean drs;
	
	
	
	
	public Boolean getHospital() {
		return hospital;
	}

	public void setHospital(Boolean hospital) {
		this.hospital = hospital;
	}

	public String getIdEtablissement() {
		return IdEtablissement;
	}



	private String libelle;

	public Collection<Telephone> getTelephones() {
		return telephones;
	}

	public void setTelephones(Collection<Telephone> telephones) {
		this.telephones = telephones;
	}

	public void setIdEtablissement(String idEtablissement) {
		IdEtablissement = idEtablissement;
	}

	public Etablisement(String nomEtablissement, Boolean intermediaire, Boolean ministraire, Boolean drs,
			String libelle) {
		super();
		IdEtablissement = UUID.randomUUID().toString();
		NomEtablissement = nomEtablissement;
		Intermediaire = intermediaire;
		this.ministraire = ministraire;
		this.drs = drs;
		this.libelle = libelle;
	}

	public Etablisement() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	@OneToOne
	//@JoinTable(name = "T_ETABLISSEMENT_ADRESSE", joinColumns = @JoinColumn(name = "IdEtablissement"), inverseJoinColumns = @JoinColumn(name = "idAdresse"))
	private Adresse adresse;

	@OneToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	//@JoinTable(name = "T_TELEPHONE_ETABLISSEMENT", joinColumns = @JoinColumn(name = "IdEtablissement"), inverseJoinColumns = @JoinColumn(name = "IdTel"))
	private Collection<Telephone> telephones;

	@OneToMany(mappedBy = "etablissement")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Utilisateur> utilisateurs;

	@OneToMany(mappedBy="etablisement")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Besoin> besoins;
	
	@OneToMany(mappedBy="etablissement")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Don> dons;
	
	
	public String getNomEtablissement() {
		return NomEtablissement;
	}

	public void setNomEtablissement(String nomEtablissement) {
		NomEtablissement = nomEtablissement;
	}

	public Boolean getIntermediaire() {
		return Intermediaire;
	}

	public void setIntermediaire(Boolean intermediaire) {
		Intermediaire = intermediaire;
	}

	public Boolean getMinistraire() {
		return ministraire;
	}

	public void setMinistraire(Boolean ministraire) {
		this.ministraire = ministraire;
	}

	public Boolean getDrs() {
		return drs;
	}

	public void setDrs(Boolean drs) {
		this.drs = drs;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Don> getDons() {
		return dons;
	}

	public void setDons(List<Don> dons) {
		this.dons = dons;
	}

	public List<Besoin> getBesoins() {
		return besoins;
	}

	   public void addBesoin(Besoin besoin) {
	        besoins.add(besoin);
	        besoin.setEtablisement(this);
	    }

	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public void setBesoins(List<Besoin> besoins) {
		this.besoins = besoins;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Etablisement [NomEtablissement=" + NomEtablissement + ", Intermediaire=" + Intermediaire
				+ ", ministraire=" + ministraire + ", hospital=" + hospital + ", drs=" + drs + ", libelle=" + libelle
				+ ", adresse=" + adresse + "]";
	}
	
	
}