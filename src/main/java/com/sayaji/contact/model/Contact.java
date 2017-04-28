package com.sayaji.contact.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column
	String firstName;
	
	@Column
	String lastName;
	
	@Column
	String address;

	public Contact() {} // for JPA

	public Contact(String firstName, String lastName, String address)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	@Override
	public String toString()
	{
		return "Contact [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", address=" + address + "]";
	}
}
