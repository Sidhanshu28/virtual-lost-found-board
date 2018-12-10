package com.mytask.lostfoundboard.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import com.mytask.lostfoundboard.model.Entries;


public class LostFoundDAO  {
	
	
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
	
	/** save function to save values in feeds table
	returns null */
	public void saveTemp(Entries f, String type) throws Exception {
		String sql = "insert INTO temp_table (id, cat, descc, location, date) SELECT * FROM (SELECT '111','"+f.getCategory()+"','"+f.getDesc()+"','"+f.getLocation()+"','"+f.getDate()+"') AS tmp WHERE NOT EXISTS ( SELECT cat FROM temp_table WHERE id = 111) LIMIT 1;";
		System.out.println(sql);
		template.update(sql);
//	     saveItem(f); /** calling function to store details of items in that XML after parsing it. */
	}
	
	/** save function to save values in feeds table
	returns null */
	public void saveFinal(String type) throws Exception {
		String sql = "";
		if(type=="lost") {sql="INSERT INTO lost_table (`cat_lt`,`desc_lt`,`location_lt`,`date_lt`) SELECT `cat`,`descc`,`location`,`date` FROM temp_table WHERE id=111;";
	    }
		else {sql="INSERT INTO found_table (`cat_ft`,`desc_ft`,`location_ft`,`date_ft`) SELECT `cat`,`descc`,`location`,`date` FROM temp_table WHERE id=111;";
	    }
		 template.update(sql);
		 deleteTemp();
//	     saveItem(f); /** calling function to store details of items in that XML after parsing it. */
	}
	
	public void deleteTemp() {
		String sql = "DELETE FROM temp_table WHERE id=111;";
		template.update(sql);
	}
	
	/** getAllFeeds function to get all RSS feeds from database and binding the list in table
	returns list (array) */
	public List<Entries> getEntries(String type) {
		String query = "";
		if(type=="lost") { query = "select * from lost_table order by date_lt desc limit 7";}
		else if(type=="found") { query = "select * from found_table order by date_ft desc limit 7"; }
		else { query = "select * from claim_table order by date_ct desc limit 7";}
		
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
		        e.setDate(rs.getString(5).split("\\s")[0]);
//		        e.setPrize(rs.getString(6));
		        lost_list.add(e);  
		        }  
		        return lost_list;  /** returning list which will bind data to table through foreach in table rows */
		        }  
		    });  
		  
		  }
	
	public boolean isThereAnyMatch(Entries f,String type) {
		String query = "";
		if(type=="lost") { query = "select count(*) from found_table where cat_ft='" + f.getCategory() +"'";}
		else if(type=="found") { query = "select count(*) from lost_table where cat_lt='" + f.getCategory() +"'"; }
		else {  }
		int count = template.queryForObject(query,Integer.class);
		if(count > 0)return true;
		else return false;
	}
	
	public String getCategoryC() {
		String query = "select cat from temp_table where id=111";
		String category = template.queryForObject(query,String.class);
		return category;
	}
	
	public List<Entries> getFilterEntries(Entries f, String type){
		String query = "";
		if(type=="lost") { query = "select * from found_table where cat_ft='" + getCategoryC() +"'";}
		else if(type=="found") { query = "select * from lost_table where cat_lt='" + getCategoryC() +"'"; }
		else {  }
		
		return template.query(query,new ResultSetExtractor<List<Entries>>(){  
		    
		     public List<Entries> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		    	 
		    	List<Entries> list=new ArrayList<Entries>();  
		        while(rs.next()){ 
		        	/** using setters to set the values */
		        	Entries e=new Entries();  
		        e.setId(rs.getInt(1));  
		        e.setCategory(rs.getString(2));
		        e.setDesc(rs.getString(3)); 
		        e.setLocation(rs.getString(4));
		        e.setDate(rs.getString(5).split("\\s")[0]);
//		        e.setPrize(rs.getString(6));
		        list.add(e);  
		        }  
		        return list;  /** returning list which will bind data to table through foreach in table rows */
		        }  
		    });
	}
	
	public List<Entries> getEntryById(int id, String type){
		String query = "";
		if(type=="found") { query = "select * from found_table where found_id=" + id;}
		else if(type=="lost") { query = "select * from lost_table where lost_id=" + id; }
		else { query = "select * from claim_table where id=" + id; }
		
		return template.query(query,new ResultSetExtractor<List<Entries>>(){  
		    
		     public List<Entries> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		    	 
		    	List<Entries> list=new ArrayList<Entries>();  
		        while(rs.next()){ 
		        	/** using setters to set the values */
		        	Entries e=new Entries();  
		        e.setId(rs.getInt(1));  
		        e.setCategory(rs.getString(2));
		        e.setDesc(rs.getString(3)); 
		        e.setLocation(rs.getString(4));
		        e.setDate(rs.getString(5).split("\\s")[0]);
//		        e.setPrize(rs.getString(6));
		        list.add(e);  
		        }  
		        return list;  /** returning list which will bind data to table through foreach in table rows */
		        }  
		    });
	}
	
	/** save function to save values in feeds table
	returns null */
	public void saveClaim(Entries f,int id, String type) throws Exception {
		String sql = "";
		if(type=="lost") {sql="INSERT INTO claim_table (`cat_ct`,`desc_ct`,`location_ct`,`date_ct`) SELECT `cat_lt`,`desc_lt`,`location_lt`,`date_lt` FROM lost_table WHERE lost_id="+id+";";
	    }
		else {sql="INSERT INTO claim_table (`cat_ct`,`desc_ct`,`location_ct`,`date_ct`) SELECT `cat_ft`,`desc_ft`,`location_ft`,`date_ft` FROM found_table WHERE found_id="+id+";";
		}
		System.out.println(sql);
		template.update(sql);
		deletePrevious(id, type);
		saveContact(f,type);
//	     saveItem(f); /** calling function to store details of items in that XML after parsing it. */
		}
	
	public void deletePrevious(int id, String t) {
		String sql = "";
		if(t=="lost")sql = "DELETE FROM lost_table WHERE lost_id="+id+";";
		else if(t=="claim")sql = "DELETE FROM claim_table WHERE id="+id+";";
		else sql = "DELETE FROM found_table WHERE found_id="+id+";";
		template.update(sql);
	}
	
	public void saveContact(Entries e,String t) {
		String sql = "INSERT INTO contact_table(`name`,`email`,`contact`,`type`) values ('"+e.getName()+"','"+e.getEmail()+"','"+e.getContact()+"','"+t+"')";
		template.update(sql);
	}
	
}
