package com.revature.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Avenger implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String heroName;
	private String power;
	private String fName;
	private String lName;
	private int powerLevel;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="homeName")
	private Home home;
	
	public Avenger(int id, String heroName, String power, String fName, String lName, int powerLevel, Home home) {
		super();
		this.id = id;
		this.heroName = heroName;
		this.power = power;
		this.fName = fName;
		this.lName = lName;
		this.powerLevel = powerLevel;
		this.home = home;
	}

	public Avenger(String heroName, String power, String fName, String lName, int powerLevel, Home home) {
		super();
		this.heroName = heroName;
		this.power = power;
		this.fName = fName;
		this.lName = lName;
		this.powerLevel = powerLevel;
		this.home = home;
	}

	public Avenger() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHeroName() {
		return heroName;
	}

	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public int getPowerLevel() {
		return powerLevel;
	}

	public void setPowerLevel(int powerLevel) {
		this.powerLevel = powerLevel;
	}

	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fName, heroName, home, id, lName, power, powerLevel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Avenger other = (Avenger) obj;
		return Objects.equals(fName, other.fName) && Objects.equals(heroName, other.heroName)
				&& Objects.equals(home, other.home) && id == other.id && Objects.equals(lName, other.lName)
				&& Objects.equals(power, other.power) && powerLevel == other.powerLevel;
	}

	@Override
	public String toString() {
		return "Avenger [id=" + id + ", heroName=" + heroName + ", power=" + power + ", fName=" + fName + ", lName="
				+ lName + ", powerLevel=" + powerLevel + ", home=" + home + "]";
	}
	
	

}
