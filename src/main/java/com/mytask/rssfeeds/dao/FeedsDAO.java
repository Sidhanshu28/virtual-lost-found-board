package com.mytask.rssfeeds.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import com.mytask.rssfeeds.model.Entries;


public class FeedsDAO  {
	
	
	JdbcTemplate template;  
	 
	
	/** setter function for JDBC connection template
	returns null */
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;
//	    getEntries();
	}

	/** save function to save values in feeds table
	returns null */
	public void save(Entries f, String type) throws Exception {
		String sql = "";
		if(type=="lost") {sql="INSERT INTO lost_table(cat_lt,desc_lt,location_lt,date_lt,prize_lt) values ('"+f.getCategory()+"','"+f.getDesc()+"','"+f.getLocation()+"','"+f.getDate()+"','"+f.getPrize()+"')";
	    }
		else {sql="INSERT INTO found_table(cat_ft,desc_ft,location_ft,date_ft) values ('"+f.getCategory()+"','"+f.getDesc()+"','"+f.getLocation()+"','"+f.getDate()+"')";
	    }
		 template.update(sql);
//	     saveItem(f); /** calling function to store details of items in that XML after parsing it. */
	}
	
	
	
	/** getAllFeeds function to get all RSS feeds from database and binding the list in table
	returns list (array) */
	public List<Entries> getEntries(String type) {
		String query = "";
		if(type=="lost") { query = "select * from lost_table order by date_lt desc limit 8";}
		else if(type=="found") { query = "select * from found_table order by date_ft desc limit 8"; }
		else { query = "select * from claim_table order by date_ct desc limit 8";}
		
		return template.query(query,new ResultSetExtractor<List<Entries>>(){  
		    
		     public List<Entries> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		    	 
		    	List<Entries> lost_list=new ArrayList<Entries>();  
		        while(rs.next()){ 
		        	/** using setters to set the values */
		        	Entries e=new Entries();  
		        e.setId(rs.getInt(1));  
		        e.setCategory(rs.getString(2));
		        e.setDesc(rs.getString(3).split("\\s").length > 1 ? rs.getString(3).split("\\s")[0] + " " + rs.getString(3).split("\\s")[1] +  "..." : rs.getString(3) + "...");  
		        e.setLocation(rs.getString(4));
		        e.setDate(rs.getString(5));
//		        e.setPrize(rs.getString(6));
		        lost_list.add(e);  
		        }  
		        return lost_list;  /** returning list which will bind data to table through foreach in table rows */
		        }  
		    });  
		  
		  }
	
	/** getAllFeeds function to get all RSS feeds from database and binding the list in table
	returns list (array) */
	public List<Entries> getAllEntries(String type) {
		String query = "";
		if(type=="lost") { query = "select * from lost_table";}
		else if(type=="found") { query = "select * from found_table"; }
		else { query = "select * from claim_table"; }
		
		return template.query(query,new ResultSetExtractor<List<Entries>>(){  
		    
		     public List<Entries> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		    	 
		    	List<Entries> lost_list=new ArrayList<Entries>();  
		        while(rs.next()){ 
		        	/** using setters to set the values */
		        	Entries e=new Entries();  
		        e.setId(rs.getInt(1));  
		        e.setCategory(rs.getString(2));
		        e.setDesc(rs.getString(3)); 
		        e.setLocation(rs.getString(4));
		        e.setDate(rs.getString(5));
//		        e.setPrize(rs.getString(6));
		        lost_list.add(e);  
		        }  
		        return lost_list;  /** returning list which will bind data to table through foreach in table rows */
		        }  
		    });  
		  
		  }
	
}
