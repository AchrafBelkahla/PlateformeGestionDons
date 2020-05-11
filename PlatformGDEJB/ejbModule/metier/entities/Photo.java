package metier.entities;

import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
public class Photo 
{
	@Id 
	private String idP;

	
	public String getIdP() {
		return idP;
	}

	public void setIdP(String idP) {
		this.idP = idP;
	}

	public Photo() {
		super();
		// TODO Auto-generated constructor stub
	}
}