package com.test.entity;

import java.io.Serializable;

import javax.persistence.Column;
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
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "variable100") // generator is just reference name for sequence generator and 
	//when u use auto hibernate create usertable= Employee and for Index create table like hibernate_sequence (what is next indx that they contain...)
	//if we have 2 records then hibernate_sequence contain = 3. next index is 3 
	//we can change hibernate_sequnce table name by using @SequenceGenerator annotation sequenceName = "Employee_Id_Generator" new Table name Employee_Id_Generator.
	
	@SequenceGenerator(name = "variable100",sequenceName = "Employee_Index_generator")
	private int id;

	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@Column(name = "address", length = 100, nullable = false)
	private String address;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + "]";
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

}
