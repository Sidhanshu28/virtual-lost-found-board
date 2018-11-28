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

	private String location;

	private String date;

	private String prize;

	
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
//
//	public int getFoundId() {
//		return this.found_id;
//	}
//	
//	public void setFoundId(int fid) {
//		this.found_id = fid;
//	}
//	
//	public String getFoundCategory() {
//		return this.found_category;
//	}
//
//	public void setFoundCategory(String fcat) {
//		this.found_category = fcat;
//	}
//
//	public String getFoundDesc() {
//		return this.found_desc;
//	}
//
//	public void setFoundDesc(String fdesc) {
//		this.found_desc = fdesc;
//	}
//
//	public String getFoundLocation() {
//		return this.found_location;
//	}
//
//	public void setFoundLocation(String floc) {
//		this.found_location = floc;
//	}
// 
//	public String getFoundDate() {
//		return this.found_date;
//	}
//
//	public void setFoundDate(String fdate) {
//		this.found_date = fdate;
//	}


}