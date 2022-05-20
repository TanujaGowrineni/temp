package com.revature.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Home implements Serializable{
	@Id
	private String homeName;
	private String addrStreetNum;
	private String addrStreetName;
	private String addrCity;
	private String addrRegion;
	private String addrPostCode;
	private String addrCountry;
	
	public Home(String homeName, String addrStreetNum, String addrStreetName, String addrCity, String addrRegion,
			String addrPostCode, String addrCountry) {
		super();
		this.homeName = homeName;
		this.addrStreetNum = addrStreetNum;
		this.addrStreetName = addrStreetName;
		this.addrCity = addrCity;
		this.addrRegion = addrRegion;
		this.addrPostCode = addrPostCode;
		this.addrCountry = addrCountry;
	}

	public Home() {
		super();
	}

	public String getHomeName() {
		return homeName;
	}

	public void setHomeName(String homeName) {
		this.homeName = homeName;
	}

	public String getAddrStreetNum() {
		return addrStreetNum;
	}

	public void setAddrStreetNum(String addrStreetNum) {
		this.addrStreetNum = addrStreetNum;
	}

	public String getAddrStreetName() {
		return addrStreetName;
	}

	public void setAddrStreetName(String addrStreetName) {
		this.addrStreetName = addrStreetName;
	}

	public String getAddrCity() {
		return addrCity;
	}

	public void setAddrCity(String addrCity) {
		this.addrCity = addrCity;
	}

	public String getAddrRegion() {
		return addrRegion;
	}

	public void setAddrRegion(String addrRegion) {
		this.addrRegion = addrRegion;
	}

	public String getAddrPostCode() {
		return addrPostCode;
	}

	public void setAddrPostCode(String addrPostCode) {
		this.addrPostCode = addrPostCode;
	}

	public String getAddrCountry() {
		return addrCountry;
	}

	public void setAddrCountry(String addrCountry) {
		this.addrCountry = addrCountry;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addrCity == null) ? 0 : addrCity.hashCode());
		result = prime * result + ((addrCountry == null) ? 0 : addrCountry.hashCode());
		result = prime * result + ((addrPostCode == null) ? 0 : addrPostCode.hashCode());
		result = prime * result + ((addrRegion == null) ? 0 : addrRegion.hashCode());
		result = prime * result + ((addrStreetName == null) ? 0 : addrStreetName.hashCode());
		result = prime * result + ((addrStreetNum == null) ? 0 : addrStreetNum.hashCode());
		result = prime * result + ((homeName == null) ? 0 : homeName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Home other = (Home) obj;
		if (addrCity == null) {
			if (other.addrCity != null)
				return false;
		} else if (!addrCity.equals(other.addrCity))
			return false;
		if (addrCountry == null) {
			if (other.addrCountry != null)
				return false;
		} else if (!addrCountry.equals(other.addrCountry))
			return false;
		if (addrPostCode == null) {
			if (other.addrPostCode != null)
				return false;
		} else if (!addrPostCode.equals(other.addrPostCode))
			return false;
		if (addrRegion == null) {
			if (other.addrRegion != null)
				return false;
		} else if (!addrRegion.equals(other.addrRegion))
			return false;
		if (addrStreetName == null) {
			if (other.addrStreetName != null)
				return false;
		} else if (!addrStreetName.equals(other.addrStreetName))
			return false;
		if (addrStreetNum == null) {
			if (other.addrStreetNum != null)
				return false;
		} else if (!addrStreetNum.equals(other.addrStreetNum))
			return false;
		if (homeName == null) {
			if (other.homeName != null)
				return false;
		} else if (!homeName.equals(other.homeName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Home [homeName=" + homeName + ", addrStreetNum=" + addrStreetNum + ", addrStreetName=" + addrStreetName
				+ ", addrCity=" + addrCity + ", addrRegion=" + addrRegion + ", addrPostCode=" + addrPostCode
				+ ", addrCountry=" + addrCountry + "]";
	}
	
	
}
