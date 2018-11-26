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
	    getAllFeeds();
	}

	/** save function to save values in feeds table
	returns null */
	public void save(Entries f) throws Exception {
		String sql="INSERT INTO lost_table(cat_lt,desc_lt,location_lt,date_lt,prize_lt) values ('"+f.getLostCategory()+"','"+f.getLostDesc()+"','"+f.getLostLocation()+"','"+f.getLostDate()+"','"+f.getLostPrize()+"')";
	     template.update(sql);
//	     saveItem(f); /** calling function to store details of items in that XML after parsing it. */
	}
	
	
	/** saveItem function to parse XML and then getting its required attributes and then storing in database
	returns null */
	public void saveItem(Entries f) throws Exception{
//		String xmlstring = convertXMLtoString(f.getFeedUrl()); /** getting XML from URL as a string */
//        Element element = getRootElementFromXML(xmlstring); /** converting XML string into a DOM element so as to read it's attributes. */
//        pushAllItems(element,f); /** calling function to read attributes and push them to database in a loop */
	}
	
	
	/** getAllFeeds function to get all RSS feeds from database and binding the list in table
	returns list (array) */
	public List<Entries> getAllFeeds() {
		
		String query = "select * from lost_table";
		return template.query(query,new ResultSetExtractor<List<Entries>>(){  
		    
		     public List<Entries> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		    	 
		    	List<Entries> list=new ArrayList<Entries>();  
		        while(rs.next()){ 
		        	/** using setters to set the values */
		        	Entries e=new Entries();  
		        e.setLostId(rs.getInt(1));  
		        e.setLostCategory(rs.getString(2));
		        e.setLostDesc(rs.getString(3));  
		        e.setLostLocation(rs.getString(4));
		        e.setLostDate(rs.getString(5));
		        e.setLostPrize(rs.getString(6));
		        list.add(e);  
		        }  
		        return list;  /** returning list which will bind data to table through foreach in table rows */
		        }  
		    });  
		  
		  }
	
}
