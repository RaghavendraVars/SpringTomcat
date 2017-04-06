package com.raghav.company;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import org.springframework.stereotype.Component;

@Component
@Entity
public class Phone {

	@Id
	@GeneratedValue
	private long ID;
	private String Type;
	private int Area_Code;
	private int P_Number;
	private int Ower_Id;
	
	@ManyToOne
	private Employee employee;
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public int getArea_Code() {
		return Area_Code;
	}
	public void setArea_Code(int area_Code) {
		Area_Code = area_Code;
	}
	public int getP_Number() {
		return P_Number;
	}
	public void setP_Number(int p_Number) {
		P_Number = p_Number;
	}
	public int getOwer_Id() {
		return Ower_Id;
	}
	public void setOwer_Id(int ower_Id) {
		Ower_Id = ower_Id;
	}
	
	
	
}
