package com.test.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Generated;

@Entity
@Table(name = "Employee_Table")

// fakt address karayacha ahe tar id user ne dileli id ani db madhali id equal ahe kay
// name  user ne dileli object madhil name ani db madhali name  equal ahe kay.
// mag  user ne dileli object madhil address ani db madhali address  diffrent tar db madhil address update.
//eka address column sathi bakihe check karayachi garaj ahe noooo. so use dirty checking @DynamicUpdate use kara....
@DynamicUpdate
public class Employee implements Serializable {

	@Id
	@Column(name = "id", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY) // identity means seprate Table tayara karat nahi for id. other
														// similar to AUTO.
	private int id;

	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@Column(name = "address", length = 100, nullable = false)
	private String address;

	@Embedded
	private Country country;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String name, String address, Country country) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", country=" + country + "]";
	}

}
