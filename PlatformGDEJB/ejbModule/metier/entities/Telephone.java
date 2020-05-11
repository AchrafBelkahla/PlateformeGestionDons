package metier.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.UUID;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Telephone")
public class Telephone implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String IdTel=UUID.randomUUID().toString();
	private String numero;


	public String getIdTel() {
		return IdTel;
	}
	public void setIdTel(String idTel) {
		IdTel = idTel;
	}
	public Telephone(String numero) {
		super();
		IdTel = UUID.randomUUID().toString();
		this.numero = numero;
	}
	public Telephone() {
		super();
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
}
