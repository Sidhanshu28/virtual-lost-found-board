package com.mytask.rssfeeds.controller;

//import java.awt.List;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mytask.rssfeeds.model.Entries;
import com.mytask.rssfeeds.dao.FeedsDAO;

@Controller

public class FeedsController {
	
	 @Autowired
	private FeedsDAO feedsDao;
	 
	 /** object to get web context loader */
	 WebApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();
	 
	 
	 /**calling save function to post values provided by user to the database  and redirects to /viewFeeds */ 
	@RequestMapping(value ="/save-lost-entry",method = RequestMethod.POST)
	public String savingLostFeed(@Valid Entries entries,
			BindingResult result, ModelMap model,RedirectAttributes redirectAttributes) throws Exception {
		feedsDao.save(entries,"lost");		
		return "redirect:/dashboard";
	}
	
	 /**calling save function to post values provided by user to the database  and redirects to /viewFeeds */ 
		@RequestMapping(value ="/save-found-entry",method = RequestMethod.POST)
		public String savingFoundFeed(@Valid Entries entries,
				BindingResult result, ModelMap model,RedirectAttributes redirectAttributes) throws Exception {
			feedsDao.save(entries,"found");		
			return "redirect:/dashboard";
		}
	
	/** calling function to get list of feeds to display them on viewfeeds model */
	@RequestMapping("/dashboard")  
    public ModelAndView viewentries(ModelMap model){  
        List<Entries> lost_list=feedsDao.getLostEntries();
//        List<Entries> lost_list=feedsDao.getClaimEntries();
        List<Entries> found_list=feedsDao.getFoundEntries();
		model.addAttribute("found_list", found_list);
		model.addAttribute("lost_list", lost_list);
        return new ModelAndView("dashboard");  
    }
	
	/** calling function to get list of feeds to display them on viewfeeds model */
	@RequestMapping("/lostentry")  
    public ModelAndView lostEntry(ModelMap model){  
        Entries entries = new Entries();
		model.addAttribute("lost-entries", entries);
        return new ModelAndView("lostentry");  
    } 
	
	/** calling function to get list of feeds to display them on viewfeeds model */
	@RequestMapping("/foundentry")  
    public ModelAndView foundEntry(ModelMap model){  
        Entries entries = new Entries();
		model.addAttribute("found-entries", entries);
        return new ModelAndView("foundentry");  
    } 
	
	

//	 
//	/** It deletes record for the given id  and redirects to /viewFeeds  */
//	    @RequestMapping(value="/deletefeed/{id}",method = RequestMethod.GET)  
//	    public ModelAndView delete(@PathVariable int id){  
//	    	feedsDao.delete(id);  
//	        return new ModelAndView("redirect:/viewFeeds");  
//	    }  
//	     
	

}
