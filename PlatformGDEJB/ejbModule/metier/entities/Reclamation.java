package metier.entities;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reclamation implements Serializable {
	@Id
	//UUID uuid = UUID.randomUUID();
	//private String codeReclamation=uuid.toString();
	private String codeReclamation=UUID.randomUUID().toString();
	public String getCodeReclamation() {
		return codeReclamation;
	}
	public void setCodeReclamation(String codeReclamation) {
		this.codeReclamation = codeReclamation;
	}
	public Reclamation( String reclamation, boolean estTraitee) {
		super();
		this.codeReclamation = UUID.randomUUID().toString();
		this.reclamation = reclamation;
		this.estTraitee = estTraitee;
	}
	public Reclamation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getReclamation() {
		return reclamation;
	}
	public void setReclamation(String reclamation) {
		this.reclamation = reclamation;
	}
	public boolean isEstTraitee() {
		return estTraitee;
	}
	public void setEstTraitee(boolean estTraitee) {
		this.estTraitee = estTraitee;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	private String reclamation;
	private boolean estTraitee;
	@ManyToOne 
	//@JoinColumn(name="idut", nullable=false)
	private Utilisateur utilisateur;
}
