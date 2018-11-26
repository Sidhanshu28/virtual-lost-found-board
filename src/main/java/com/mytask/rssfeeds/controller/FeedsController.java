package com.mytask.rssfeeds.controller;

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
	@RequestMapping(value ="/save",method = RequestMethod.POST)
	public String savingFeed(@Valid Entries entries,
			BindingResult result, ModelMap model,RedirectAttributes redirectAttributes) throws Exception {
		feedsDao.save(entries);		
		return "redirect:/viewFeeds";
	}
	
	/** calling function to get list of feeds to display them on viewfeeds model */
	@RequestMapping("/viewFeeds")  
    public ModelAndView viewfeeds(ModelMap model){  
        List<Entries> list=feedsDao.getAllFeeds();
        Entries entries = new Entries();
		model.addAttribute("entries", entries);
        return new ModelAndView("viewfeeds","list",list);  
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
