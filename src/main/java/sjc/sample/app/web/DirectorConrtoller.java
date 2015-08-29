package sjc.sample.app.web;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sjc.example.domain.model.Application;
import sjc.example.domain.model.ApplicationDetail;
import sjc.example.domain.model.Client;
import sjc.example.domain.model.Detail;
import sjc.example.domain.model.Director;
import sjc.example.domain.model.Mechanic;
import sjc.example.domain.model.Rent;
import sjc.example.domain.model.Service;
import sjc.example.domain.model.Status;
import sjc.example.domain.model.Sto;
import sjc.example.domain.model.UserPrincipal;
import sjc.example.domain.model.UserRole;
import sjc.example.domain.service.ClientService;
import sjc.example.domain.service.DirectorService;
import sjc.example.domain.service.MechanicService;
import sjc.example.domain.service.UserService;

@Controller
@RequestMapping("/director")
public class DirectorConrtoller {
	
	@Autowired
	private DirectorService directorService;
	
	@Autowired
	private MechanicService mechanicService;

	@Autowired
	private ClientService clientService;
	
	@Autowired
	private UserService userService;
	
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/getapplication", method = RequestMethod.GET)
	public ModelAndView  getapplicationlist(HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
		Status status = clientService.getStatusByName("zajavka ozhidaet obrabotku");
        mav.addObject("user", user);
        mav.addObject("application", directorService.getApplicationByStatus(status));
		mav.setViewName("director.applicationlist");
		return mav;
	};
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/getmechanics", method = RequestMethod.GET)
	public ModelAndView  getmechaniclist(HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
        mav.addObject("user", user);
        mav.addObject("mechanic", directorService.getMechanics());
		mav.setViewName("director.mechanicslist");
		return mav;
	};
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/getsto", method = RequestMethod.GET)
	public ModelAndView  getstolist(HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
        mav.addObject("user", user);
        mav.addObject("sto", directorService.getSto());
		mav.setViewName("director.stolist");
		return mav;
	};
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/mechaniclistbysto/{id}", method = RequestMethod.GET)
	public ModelAndView  getmechaniclistbysto(@PathVariable Long id,  HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
		Sto sto = directorService.getStoById(id);
		
		System.out.println("Test test test"+sto.getName());
        mav.addObject("user", user);
        mav.addObject("mechanic", directorService.getMechanicsOnSto(sto));
		mav.setViewName("director.mechaniclistbysto");
		return mav;
	};
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/addrent", method = RequestMethod.GET)
	public ModelAndView  addrent(HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
        mav.addObject("user", user);
        mav.addObject("rent", new Rent());
        mav.addObject("stos", directorService.getSto());
		mav.setViewName("director.addrent");
		return mav;
	};
	
	@RequestMapping(value = { "/addrent" }, method = { RequestMethod.POST })
	public String addrent(@ModelAttribute("rent") Rent rent,  Model model, HttpSession session) {
        rent.setDateStart(new Date());
	    directorService.addRent(rent);
        
	    return "redirect:/home";
	}
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/adddetail", method = RequestMethod.GET)
	public ModelAndView  adddetail(HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
        mav.addObject("user", user);
        mav.addObject("detail", new Detail());
		mav.setViewName("director.adddetail");
		return mav;
	};
	
	@RequestMapping(value = { "/adddetail" }, method = { RequestMethod.POST })
	public String adddetail(@ModelAttribute("service") Detail detail,  Model model, HttpSession session) {

	    directorService.addDetail(detail);
        
	    return "redirect:/home";
	}
	
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/addservice", method = RequestMethod.GET)
	public ModelAndView  addservice(HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
        mav.addObject("user", user);
        mav.addObject("service", new Service());
		mav.setViewName("director.addservice");
		return mav;
	};
	
	@RequestMapping(value = { "/addservice" }, method = { RequestMethod.POST })
	public String addservice(@ModelAttribute("service") Service service,  Model model, HttpSession session) {

	    directorService.addService(service);
        
	    return "redirect:/home";
	}
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/addmechanic", method = RequestMethod.GET)
	public ModelAndView  addmechanic(HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
        mav.addObject("user", user);
        mav.addObject("mechanic", new Mechanic());
        mav.addObject("stos", directorService.getSto());
		mav.setViewName("director.addmechanic");
		return mav;
	};
	
	@RequestMapping(value = { "/addmechanic" }, method = { RequestMethod.POST })
	public String addmechanic(@ModelAttribute("mechanic") Mechanic mechanic,  Model model, HttpSession session) {
        
		System.out.println("test test test name mechanic  =  " + mechanic.getName());
		System.out.println("test test test name sto  =  " + mechanic.getSto().getName());
		mechanic.setLogin(mechanic.getName());
		mechanic.setRating(0.0);
		mechanic.setRole(UserRole.MECHANIC);
	    directorService.saveOrUpdateMechanic(mechanic);
        
	    return "redirect:/home";
	}
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/getapplicationdetail", method = RequestMethod.GET)
	public ModelAndView  getapplicationdetail(HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
        mav.addObject("user", user);
        mav.addObject("applicationdetail", new ApplicationDetail());
		mav.setViewName("director.updateapplicationdetail");
		return mav;
	};
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/updateapplication", method = RequestMethod.GET)
	public ModelAndView  updateapplication(HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
		mav.addObject("application", new Application());
        mav.addObject("user", user);
		mav.setViewName("director.updateapplication");
		return mav;
	};
	
	}
