package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Alien {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	int aId;
	@Column
	String aName;
	@Column
	String aColour;
	
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public String getaName() {
		return aName;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}
	public String getaColour() {
		return aColour;
	}
	public void setaColour(String aColour) {
		this.aColour = aColour;
	}
	
}
