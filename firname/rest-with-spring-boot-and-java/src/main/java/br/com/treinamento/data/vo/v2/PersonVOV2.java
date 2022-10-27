package br.com.treinamento.data.vo.v2;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


public class PersonVOV2 implements Serializable{
  
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String firnName;
	private String lastName;
	private String address;
	private String genter;
	private Date birthday;
	
	
	public PersonVOV2() {}

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
	
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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
		PersonVOV2 other = (PersonVOV2) obj;
		return Objects.equals(address, other.address) && Objects.equals(firnName, other.firnName)
				&& Objects.equals(genter, other.genter) && id == other.id && Objects.equals(lastName, other.lastName);
	}

	
}
