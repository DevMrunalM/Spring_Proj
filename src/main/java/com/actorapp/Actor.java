package com.actorapp;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="actors_tb")
public class Actor {

	@Id 
	@GeneratedValue
	private Long s1;
	
	
	public Long getS1() {
		return s1;
	}

	public void setS1(Long s1) {
		this.s1 = s1;
	}

	private String name;
	
	private String famousD;
	
	private String dob;
	
	private String gender;

	public Actor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Actor(String name, String famousD, String dob, String gender) {
		super();
		this.name = name;
		this.famousD = famousD;
		this.dob = dob;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFamousD() {
		return famousD;
	}

	public void setFamousD(String famousD) {
		this.famousD = famousD;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Actor [name=" + name + ", famousD=" + famousD + ", dob=" + dob + ", gender=" + gender + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dob, famousD, gender, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actor other = (Actor) obj;
		return Objects.equals(dob, other.dob) && Objects.equals(famousD, other.famousD)
				&& Objects.equals(gender, other.gender) && Objects.equals(name, other.name);
	}
	
	
	
}
