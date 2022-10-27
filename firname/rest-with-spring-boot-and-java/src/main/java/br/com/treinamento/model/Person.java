package br.com.treinamento.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Person implements Serializable{
  
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String firnName;
	private String lastName;
	private String address;
	private String genter;

	public Person() {}

	public long getId() {
		return id;
	}

	public String getFirnName() {
		return firnName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getGenter() {
		return genter;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setFirnName(String firnName) {
		this.firnName = firnName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setGenter(String genter) {
		this.genter = genter;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, firnName, genter, id, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(address, other.address) && Objects.equals(firnName, other.firnName)
				&& Objects.equals(genter, other.genter) && id == other.id && Objects.equals(lastName, other.lastName);
	}

	
	

	
}
