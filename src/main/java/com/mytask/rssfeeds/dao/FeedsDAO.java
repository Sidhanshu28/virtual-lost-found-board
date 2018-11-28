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
	    getLostEntries();
	    getFoundEntries();
	}

	/** save function to save values in feeds table
	returns null */
	public void save(Entries f, String type) throws Exception {
		String sql = "";
		if(type=="lost") {sql="INSERT INTO lost_table(cat_lt,desc_lt,location_lt,date_lt,prize_lt) values ('"+f.getLostCategory()+"','"+f.getLostDesc()+"','"+f.getLostLocation()+"','"+f.getLostDate()+"','"+f.getLostPrize()+"')";
	    }
		else {sql="INSERT INTO found_table(cat_ft,desc_ft,location_ft,date_ft) values ('"+f.getFoundCategory()+"','"+f.getFoundDesc()+"','"+f.getFoundLocation()+"','"+f.getFoundDate()+"')";
	    }
		 template.update(sql);
//	     saveItem(f); /** calling function to store details of items in that XML after parsing it. */
	}
	
	
	
	/** getAllFeeds function to get all RSS feeds from database and binding the list in table
	returns list (array) */
	public List<Entries> getLostEntries() {
		
		String query = "select * from lost_table order by date_lt desc limit 8";
		return template.query(query,new ResultSetExtractor<List<Entries>>(){  
		    
		     public List<Entries> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		    	 
		    	List<Entries> lost_list=new ArrayList<Entries>();  
		        while(rs.next()){ 
		        	/** using setters to set the values */
		        	Entries e=new Entries();  
		        e.setLostId(rs.getInt(1));  
		        e.setLostCategory(rs.getString(2));
		        e.setLostDesc(rs.getString(3).split("\\s").length > 1 ? rs.getString(3).split("\\s")[0] + " " + rs.getString(3).split("\\s")[1] +  "..." : rs.getString(3) + "...");  
		        e.setLostLocation(rs.getString(4));
		        e.setLostDate(rs.getString(5));
		        e.setLostPrize(rs.getString(6));
		        lost_list.add(e);  
		        }  
		        return lost_list;  /** returning list which will bind data to table through foreach in table rows */
		        }  
		    });  
		  
		  }
	
	/** getAllFeeds function to get all RSS feeds from database and binding the list in table
	returns list (array) */
	public List<Entries> getFoundEntries() {
		
		String query = "select * from found_table order by date_ft desc limit 8";
		return template.query(query,new ResultSetExtractor<List<Entries>>(){  
		    
		     public List<Entries> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		    	 
		    	List<Entries> found_list=new ArrayList<Entries>();  
		        while(rs.next()){ 
		        	/** using setters to set the values */
		        	Entries e=new Entries();  
		        e.setFoundId(rs.getInt(1));  
		        e.setFoundCategory(rs.getString(2));
		        e.setFoundDesc(rs.getString(3).split("\\s").length > 1 ? rs.getString(3).split("\\s")[0] + " " + rs.getString(3).split("\\s")[1] +  "..." : rs.getString(3) + "...");  
		        e.setFoundLocation(rs.getString(4));
		        e.setFoundDate(rs.getString(5));
//		        e.setFoundPrize(rs.getString(6));
		        found_list.add(e);  
		        }  
		        return found_list;  /** returning list which will bind data to table through foreach in table rows */
		        }  
		    });  
		  
		  }
	
}
