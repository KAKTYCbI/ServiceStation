package sjc.sample.app.web;

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
import sjc.example.domain.model.Detail;
import sjc.example.domain.model.Director;
import sjc.example.domain.model.Mechanic;
import sjc.example.domain.model.Rent;
import sjc.example.domain.model.Service;
import sjc.example.domain.model.Sto;
import sjc.example.domain.model.UserPrincipal;
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
	private UserService userService;
	
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/getapplication", method = RequestMethod.GET)
	public ModelAndView  getapplicationlist(HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
        mav.addObject("user", user);
		mav.setViewName("director.applicationlist");
		return mav;
	};
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/getmechanics", method = RequestMethod.GET)
	public ModelAndView  getmechaniclist(HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
        mav.addObject("user", user);
		mav.setViewName("director.mechanicslist");
		return mav;
	};
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/getsto", method = RequestMethod.GET)
	public ModelAndView  getstolist(HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
        mav.addObject("user", user);
		mav.setViewName("director.stolist");
		return mav;
	};
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/mechaniclistbysto", method = RequestMethod.GET)
	public ModelAndView  getmechaniclistbysto(HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
        mav.addObject("user", user);
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
		mav.setViewName("director.addrent");
		return mav;
	};
	
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
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/addmechanic", method = RequestMethod.GET)
	public ModelAndView  addmechanic(HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
        mav.addObject("user", user);
        mav.addObject("mechanic", new Mechanic());
		mav.setViewName("director.addmechanic");
		return mav;
	};
	
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
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/{id}/listOrderDetail", method = RequestMethod.GET)
	public String getListDetails(@PathVariable("id") Director director,
			HttpSession session, Model model){
		model.addAttribute("listOrderDetail",directorService.getApplicationDetail());
		return "director.listOrderDetail";
	};
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/{id}/addDetail", method = RequestMethod.GET)
	public String addDetail(@PathVariable("id") Director director,@ModelAttribute Detail detail,
			HttpSession session, Model model){
		directorService.addDetail(detail);
		return "director.addDetail";
	};
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/{id}/addRent", method = RequestMethod.GET)
	public String addRent(@PathVariable("id") Director director,@ModelAttribute Rent rent,
			HttpSession session, Model model){
		directorService.addRent(rent);
		return "director.addRent";
	};
	
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/{id}/addMechanic", method = RequestMethod.GET)
	public String addMechanic(@PathVariable("id") Director director,@ModelAttribute Mechanic mechanic,
			HttpSession session, Model model){
		directorService.saveOrUpdateMechanic(mechanic);
		return "director.addMechanic";
	};
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/{id}/listMechanic", method = RequestMethod.GET)
	public String getListMechanic(@PathVariable("id") Director director,
			HttpSession session, Model model){
		model.addAttribute("listMechanic",directorService.getMechanics());
		return "director.listMechanic";
	};
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/{id}/listSto", method = RequestMethod.GET)
	public String getListSto(@PathVariable("id") Director director,
			HttpSession session, Model model){
		model.addAttribute("listSto",directorService.getSto());
		return "director.listSto";
	};
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/{id}/listMechanicOnSto", method = RequestMethod.GET)
	public String getListMechanicOnSto(@PathVariable("id") Director director,@ModelAttribute Sto sto,
			HttpSession session, Model model){
		directorService.getMechanicsOnSto(sto);
		return "director.addListMechanicOnSto";
	};
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/{id}/addServise", method = RequestMethod.GET)
	public String addService(@PathVariable("id") Director director,@ModelAttribute Service service,
			HttpSession session, Model model){
		directorService.addService(service);
		return "director.addListMechanicOnSto";
	};
}
