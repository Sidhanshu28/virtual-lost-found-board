package com.mytask.lostfoundboard.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;



/**
 * The persistent class for the feeds database table.
 * 
 */
@Entity
@NamedQuery(name="Entries.findAll", query="SELECT e FROM Entries e")
public class Entries implements Serializable {
	private static final long serialVersionUID = 1L;

	/**  lost table variables */
	
	@Id
	private int id;
	
	@Size(min=3, max=20)
	private String category;
	
	@NotEmpty
	private String desc;

	@NotEmpty
	private String location;

	@NotEmpty
	private String date;

	@NotEmpty
	private String prize;
	
	@NotEmpty
	private String name;
	 
	@NotEmpty
	private String email;
	
	@NotEmpty @Size(min=10, max=10)
	private String contact;
	
	@NotEmpty
	private String firstname;
	
	@NotEmpty
	private String lastname;
	 
	@NotEmpty
	private String username;
	 
	@NotEmpty
	private String useremail;
	
	@NotEmpty
	private String password;
	
	@NotEmpty
	private String error;


	public int getId() {
		return this.id;
	}
	
	public void setId(int lid) {
		this.id = lid;
	}
	
	public String getCategory() {
		return this.category;
	}

	public void setCategory(String lcat) {
		this.category = lcat;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String ldesc) {
		this.desc = ldesc;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String lloc) {
		this.location = lloc;
	}
 
	public String getDate() {
		return this.date;
	}

	public void setDate(String ldate) {
		this.date = ldate;
	}

	public String getPrize() {
		return this.prize;
	}

	public void setPrize(String lprize) {
		this.prize = lprize;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getFirstName() {
		return this.firstname;
	}

	public void setFirstName(String fname) {
		this.firstname = fname;
	}

	public String getLastName() {
		return this.lastname;
	}

	public void setLastName(String lname) {
		this.lastname = lname;
	}

	public String getUserName() {
		return this.username;
	}

	public void setUserName(String uname) {
		this.username = uname;
	}

	public String getUserEmail() {
		return this.useremail;
	}

	public void setUserEmail(String uemail) {
		this.useremail = uemail;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getError() {
		return this.password;
	}

	public void setError(String error) {
		this.error = error;
	}
}