package com.test.entity;

import javax.persistence.Embeddable;

                                                                                                                
public class Country {

	private String countryName;
	private String continent;

	public Country(String countryName, String continent) {
		super();
		this.countryName = countryName;
		this.continent = continent;
	}

	public Country() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Country [countryName=" + countryName + ", continent=" + continent + "]";
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

}
