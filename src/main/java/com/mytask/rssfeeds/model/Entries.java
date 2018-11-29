package com.mytask.rssfeeds.model;

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

	
//	/**  found table variables */
//	@Id
//	private int found_id;
//	
//	@Size(min=3, max=20)
//	private String found_category;
//	
//	@NotEmpty
//	private String found_desc;
//
//	private String found_location;
//
//	private String found_date;

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
}