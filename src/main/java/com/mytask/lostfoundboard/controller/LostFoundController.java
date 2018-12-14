package com.mytask.lostfoundboard.controller;

//import java.awt.List;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mytask.lostfoundboard.model.Entries;
import com.mytask.lostfoundboard.dao.LostFoundDAO;

@Controller

public class LostFoundController {
	
	 @Autowired
	private LostFoundDAO lostfoundDao;
	 
	 /** object to get web context loader */
	 WebApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();
	 
	 @RequestMapping("/home")  
	    public ModelAndView viewdashboard(RedirectAttributes redirectAttributes){ 
		 return new ModelAndView("home");  
	    }
		
	 @RequestMapping("/signup")  
	    public ModelAndView signupPage(ModelMap model, RedirectAttributes redirectAttributes){
		 	Entries entries = new Entries();
			model.addAttribute("signup-entries", entries);
		 	return new ModelAndView("signup"); 
	    }
	 
	 @RequestMapping("/signupentry")  
	    public String signupentry(Entries e, ModelMap model, RedirectAttributes redirectAttributes){
		 	lostfoundDao.signup(e);
		 	return "redirect:/login";
	    }
	 
	 @RequestMapping("/login")  
	    public ModelAndView loginPage(Entries e, ModelMap model, RedirectAttributes redirectAttributes){
			model.addAttribute("login-entries", e);
		 	return new ModelAndView("loginPage"); 
	    }
	 @RequestMapping("/login/error")  
	    public ModelAndView loginPageError(Entries e, ModelMap model, RedirectAttributes redirectAttributes){
			model.addAttribute("login-entries", e);
			model.addAttribute("error","incorrect username or password");
		 	return new ModelAndView("loginPage"); 
	    }
	
	 @RequestMapping("/logout")  
	    public String logout(RedirectAttributes redirectAttributes){
		 	return "redirect:/home";
	    }
	 
	 @RequestMapping("/loginCheck")  
	    public String loginEntry(Entries e, ModelMap model, RedirectAttributes redirectAttributes){
//			model.addAttribute("login-entries", e);
			List<Entries> list = lostfoundDao.checkLoginParams(e);
			if(list.size() > 0) {
//				model.addAttribute("uname", list);
				return "redirect:/dashboard/username="+e.getUserName();
				}
			else {
				e.setError("Incorrect username or password");
				return "redirect:/login/error";} 
	    }
	 
	 @RequestMapping(value ="/filter-entry-found",method = RequestMethod.POST)
	 public String savingFoundFeed(@Valid Entries entries,
				BindingResult result, ModelMap model,RedirectAttributes redirectAttributes) throws Exception {
			boolean filter = lostfoundDao.isThereAnyMatch(entries, "found");
			if(filter) {
				lostfoundDao.saveTemp(entries,"found");
				List<Entries> entries_list=lostfoundDao.getFilterEntries(entries, "found");
				 model.addAttribute("entries_list",entries_list);
				return "redirect:/filter-entries-found";
			}
			else {
				lostfoundDao.save(entries,"found");
				return "redirect:/dashboard";
				}
		}
	 
	 @RequestMapping(value ="/filter-entry-lost",method = RequestMethod.POST)
	 public String savingLostFeed(@Valid Entries entries,
				BindingResult result, ModelMap model,RedirectAttributes redirectAttributes) throws Exception {
			boolean filter = lostfoundDao.isThereAnyMatch(entries, "lost");
			if(filter) {
				lostfoundDao.saveTemp(entries,"lost");
				 List<Entries> entries_list=lostfoundDao.getFilterEntries(entries, "lost");
				 model.addAttribute("entries_list",entries_list);
				 return "redirect:/filter-entries-lost";
			}
			else {
				lostfoundDao.save(entries,"lost");	
				return "redirect:/dashboard";
				}
		}
	 
		@RequestMapping(value ="/filter-entries-lost")
	public ModelAndView filterLostEntriesView(Entries entries, ModelMap model) {
		 List<Entries> entries_list=lostfoundDao.getFilterEntries(entries, "lost");
		 model.addAttribute("entries_list",entries_list);
	        return new ModelAndView("filterl");   
	}
	
	@RequestMapping(value ="/filter-entries-found")
	public ModelAndView filterFoundEntriesView(Entries entries, ModelMap model) {
		 List<Entries> entries_list=lostfoundDao.getFilterEntries(entries, "found");
		 model.addAttribute("entries_list",entries_list);
	        return new ModelAndView("filterf");   
	}

		@RequestMapping(value ="/save-lost-entry")
	public String savingLFeed(@Valid Entries entries,
			BindingResult result, ModelMap model,RedirectAttributes redirectAttributes) throws Exception {
		lostfoundDao.saveFinal("found");		
		return "redirect:/dashboard";
	}
	
	 	@RequestMapping(value ="/save-found-entry")
		public String savingFFeed(@Valid Entries entries,
				BindingResult result, ModelMap model,RedirectAttributes redirectAttributes) throws Exception {
			lostfoundDao.saveFinal("found");		
			return "redirect:/dashboard";
		}
	

	@RequestMapping("/dashboard")  
    public ModelAndView viewentries(ModelMap model, Entries e){  
        List<Entries> lost_list=lostfoundDao.getEntries("lost");
        List<Entries> claim_list=lostfoundDao.getEntries("claim");
        List<Entries> found_list=lostfoundDao.getEntries("found");
		model.addAttribute("found_list", found_list);
		model.addAttribute("lost_list", lost_list);
		model.addAttribute("claim_list", claim_list);
//		model.addAttribute("uname",e.getUserName());
//		System.out.println(e.getUserName());
        return new ModelAndView("dashboard");  
    }
	
	@RequestMapping("/dashboard/username={username}")  
    public ModelAndView viewentriesUsername(ModelMap model, Entries e , @PathVariable String username){  
        List<Entries> lost_list=lostfoundDao.getEntries("lost");
        List<Entries> claim_list=lostfoundDao.getEntries("claim");
        List<Entries> found_list=lostfoundDao.getEntries("found");
		model.addAttribute("found_list", found_list);
		model.addAttribute("lost_list", lost_list);
		model.addAttribute("claim_list", claim_list);
		model.addAttribute("uname",username);
		System.out.println(username);
        return new ModelAndView("dashboard");  
    }
	
	
	@RequestMapping("/lostentry")  
    public ModelAndView lostEntry(ModelMap model){  
        Entries entries = new Entries();
		model.addAttribute("lost-entries", entries);
        return new ModelAndView("lostentry");  
    } 
	
	
	@RequestMapping("/foundentry")  
    public ModelAndView foundEntry(ModelMap model){  
        Entries entries = new Entries();
		model.addAttribute("found-entries", entries);
        return new ModelAndView("foundentry");  
    } 
	
	
	@RequestMapping("/viewallentries/lost")  
    public ModelAndView lostEntries(ModelMap model){  
		List<Entries> entries_list=lostfoundDao.getAllEntries("lost");
		model.addAttribute("entries_list", entries_list);
        return new ModelAndView("viewallentriesL");  
    } 
	
	@RequestMapping("/viewallentries/claim")  
    public ModelAndView claimEntries(ModelMap model){  
		List<Entries> entries_list=lostfoundDao.getAllEntries("claim");
		model.addAttribute("entries_list",entries_list);
        return new ModelAndView("viewallentriesC");   
    } 
	
	@RequestMapping("/viewallentries/found")  
    public ModelAndView foundEntries(ModelMap model){  
		List<Entries> entries_list=lostfoundDao.getAllEntries("found");
		model.addAttribute("entries_list",entries_list);
        return new ModelAndView("viewallentriesF"); 
    } 

	@RequestMapping("/viewentry/lost/{id}")  
    public ModelAndView viewfeedByIdL(ModelMap model,@PathVariable int id){  
        List<Entries> list=lostfoundDao.getEntryById(id, "lost");
        return new ModelAndView("viewentryByIdL","list",list);  
    }
	@RequestMapping("/viewentry/found/{id}")  
    public ModelAndView viewfeedByIdF(ModelMap model,@PathVariable int id){  
        List<Entries> list=lostfoundDao.getEntryById(id, "found");
        return new ModelAndView("viewentryByIdF","list",list);  
    } 
	@RequestMapping("/viewentry/claim/{id}")  
    public ModelAndView viewfeedByIdC(ModelMap model,@PathVariable int id){  
        List<Entries> list=lostfoundDao.getEntryById(id, "claim");
        return new ModelAndView("viewentryByIdC","list",list);  
    } 
	
	@RequestMapping("/claimentrylost/id={id}")  
    public ModelAndView claimlostEntry(ModelMap model, @PathVariable int id){  
        Entries entries = new Entries();
		model.addAttribute("lost-claim-entries", entries);
		model.addAttribute("id", id);
        return new ModelAndView("claimentrylost");  
    } 
	
	
	@RequestMapping("/claimentryfound/id={id}")  
    public ModelAndView claimfoundEntry(ModelMap model,@PathVariable int id){  
        Entries entries = new Entries();
		model.addAttribute("found-claim-entries", entries);
		model.addAttribute("id", id);
        return new ModelAndView("claimentryfound");  
    } 
	
	@RequestMapping(value="/submit-claim-lost/{id}",method = RequestMethod.POST)  
    public String submitLostClaim(Entries entries,@PathVariable int id,
			BindingResult result, ModelMap model,RedirectAttributes redirectAttributes) throws Exception{  
        lostfoundDao.saveClaim(entries,id,"lost");
        return "redirect:/dashboard";  
    } 
	
	
	@RequestMapping(value="/submit-claim-found/{id}",method = RequestMethod.POST)  
    public String submitFoundClaim(Entries entries,@PathVariable int id,
			BindingResult result, ModelMap model,RedirectAttributes redirectAttributes) throws Exception{  
		lostfoundDao.saveClaim(entries,id,"found");
		return "redirect:/dashboard"; 
    } 
	

	@RequestMapping("/lostentrydelete/id={id}")  
    public String lostEntryDelete(RedirectAttributes redirectAttributes, @PathVariable int id){  
		lostfoundDao.deletePrevious(id,"lost");
		return "redirect:/dashboard"; 
    } 
	
	
	@RequestMapping("/foundentrydelete/id={id}")  
    public String foundEntryDelete(RedirectAttributes redirectAttributes,@PathVariable int id){  
		lostfoundDao.deletePrevious(id,"found");
		return "redirect:/dashboard";
    } 
	
	
	@RequestMapping("/claimentrydelete/id={id}")  
    public String claimEntryDelete(RedirectAttributes redirectAttributes,@PathVariable int id){  
		lostfoundDao.deletePrevious(id,"claim");
		return "redirect:/dashboard";
    } 
	
	@RequestMapping("/updatefound/id={id}")  
	 public ModelAndView updateFound(Entries entries, ModelMap model, RedirectAttributes redirectAttributes,@PathVariable int id){  
		List<Entries> list=lostfoundDao.getEntryById(id, "found");
		model.addAttribute("found-entries", entries);
		return new ModelAndView("updateFound","list",list); 
    } 
	
	
	@RequestMapping("/updatelost/id={id}")  
    public ModelAndView updateLost(Entries entries, ModelMap model, RedirectAttributes redirectAttributes,@PathVariable int id){  
		List<Entries> list=lostfoundDao.getEntryById(id, "lost");
		model.addAttribute("lost-entries", entries);
		return new ModelAndView("updateLost","list",list); 
    } 
	
	@RequestMapping("/foundentryupdated/id={id}")  
    public String foundEntryUpdated(Entries entries, RedirectAttributes redirectAttributes,@PathVariable int id){  
		lostfoundDao.updateEntry(entries, id,"found");
		return "redirect:/viewentry/found/{id}";
    } 
	
	
	@RequestMapping("/lostentryupdated/id={id}")  
    public String claimEntryUpdated(Entries entries, RedirectAttributes redirectAttributes,@PathVariable int id){  
		lostfoundDao.updateEntry(entries, id,"lost");
		return "redirect:/viewentry/lost/{id}";
    } 

}
