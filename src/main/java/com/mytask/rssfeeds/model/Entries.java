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
	private int lost_id;
	
	@Size(min=3, max=20)
	private String lost_category;
	
	@NotEmpty
	private String lost_desc;

	private String lost_location;

	private String lost_date;

	private String lost_prize;

	
	/**  found table variables */
	@Id
	private int found_id;
	
	@Size(min=3, max=20)
	private String found_category;
	
	@NotEmpty
	private String found_desc;

	private String found_location;

	private String found_date;

	public int getLostId() {
		return this.lost_id;
	}
	
	public void setLostId(int lid) {
		this.lost_id = lid;
	}
	
	public String getLostCategory() {
		return this.lost_category;
	}

	public void setLostCategory(String lcat) {
		this.lost_category = lcat;
	}

	public String getLostDesc() {
		return this.lost_desc;
	}

	public void setLostDesc(String ldesc) {
		this.lost_desc = ldesc;
	}

	public String getLostLocation() {
		return this.lost_location;
	}

	public void setLostLocation(String lloc) {
		this.lost_location = lloc;
	}
 
	public String getLostDate() {
		return this.lost_date;
	}

	public void setLostDate(String ldate) {
		this.lost_date = ldate;
	}

	public String getLostPrize() {
		return this.lost_prize;
	}

	public void setLostPrize(String lprize) {
		this.lost_prize = lprize;
	}

	public int getFoundId() {
		return this.found_id;
	}
	
	public void setFoundId(int fid) {
		this.found_id = fid;
	}
	
	public String getFoundCategory() {
		return this.found_category;
	}

	public void setFoundCategory(String fcat) {
		this.found_category = fcat;
	}

	public String getFoundDesc() {
		return this.found_desc;
	}

	public void setFoundDesc(String fdesc) {
		this.found_desc = fdesc;
	}

	public String getFoundLocation() {
		return this.found_location;
	}

	public void setFoundLocation(String floc) {
		this.found_location = floc;
	}
 
	public String getFoundDate() {
		return this.found_date;
	}

	public void setFoundDate(String fdate) {
		this.found_date = fdate;
	}


}