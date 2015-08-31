package sjc.sample.app.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
import sjc.example.domain.model.Salary;
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
	
	@InitBinder
    public void initBinder(WebDataBinder binder) 
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
       
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, true));
    }
	
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
        rent.setPrice(rent.getSto().getPrice());
	    directorService.addRent(rent);
        
	    return "redirect:/home";
	}
	
	@RequestMapping(value = { "/addsalary/{id}" }, method = { RequestMethod.GET })
	public String addsalaryByMechanic(@PathVariable Long id,  Model model, HttpSession session) {
        Mechanic mechanic = directorService.getMechanicById(id);
        Salary salary= new Salary();
        salary.setMechanic(mechanic);
        salary.setSumma(new Float(mechanic.getSalary()));
        salary.setDate(new Date());
        directorService.addSalary(salary);
	    return "redirect:/home";
	}
	
	@RequestMapping(value = { "/deletemechanic/{id}" }, method = { RequestMethod.GET })
	public String deleteMechanic(@PathVariable Long id,  Model model, HttpSession session) {
        Mechanic mechanic = directorService.getMechanicById(id);
        directorService.deleteMechanic(mechanic);
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
	@RequestMapping(value = "/addsto", method = RequestMethod.GET)
	public ModelAndView  addsto(HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
        mav.addObject("user", user);
        mav.addObject("sto", new Sto());
		mav.setViewName("director.addsto");
		return mav;
	};
	
	@RequestMapping(value = { "/addsto" }, method = { RequestMethod.POST })
	public String addsto(@ModelAttribute("sto") Sto sto,  Model model, HttpSession session) {
        sto.setRating((float)0);
	    directorService.addSto(sto);
	    return "redirect:/home";
	}
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/updatesto/{id}", method = RequestMethod.GET)
	public ModelAndView  updatesto(@PathVariable Long id, HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
        mav.addObject("user", user);
        mav.addObject("sto", directorService.getStoById(id));
		mav.setViewName("director.updatesto");
		return mav;
	};
	
	@RequestMapping(value = { "/updatesto/{id}" }, method = { RequestMethod.POST })
	public String updatesto(@PathVariable Long id,@ModelAttribute("sto") Sto sto,  Model model, HttpSession session) {
        Sto sto1 = directorService.getStoById(id);
        sto1.setName(sto.getName());
        sto1.setPrice(sto.getPrice());
	    directorService.addSto(sto1);
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
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/updatemechanic/{id}", method = RequestMethod.GET)
	public ModelAndView  updatemechanic(@PathVariable Long id, HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
        mav.addObject("user", user);
        mav.addObject("mechanic", directorService.getMechanicById(id));
        mav.addObject("stos", directorService.getSto());
		mav.setViewName("director.updatemechanic");
		return mav;
	};
	
	@RequestMapping(value = { "/updatemechanic/{id}" }, method = { RequestMethod.POST })
	public String updatemechanic(@ModelAttribute("mechanic") Mechanic mechanic,  Model model, HttpSession session) {
        
		System.out.println("test test test name mechanic  =  " + mechanic.getName());
		System.out.println("test test test name sto  =  " + mechanic.getSto().getName());
		Mechanic mechanic1 = directorService.getMechanicById(mechanic.getUserId());
		mechanic.setLogin(mechanic.getName());
		mechanic.setRating(mechanic1.getRating());
		mechanic.setRole(UserRole.MECHANIC);
	    directorService.saveOrUpdateMechanic(mechanic);
        
	    return "redirect:/home";
	}
	
	@RequestMapping(value = { "/addmechanic" }, method = { RequestMethod.POST })
	public String addmechanic(@ModelAttribute("mechanic") Mechanic mechanic,  Model model, HttpSession session) {
        
		System.out.println("test test test name mechanic  =  " + mechanic.getName());
		System.out.println("test test test name sto  =  " + mechanic.getSto().getName());
		mechanic.setLogin(mechanic.getName());
		mechanic.setRating((float)0);
		mechanic.setRole(UserRole.MECHANIC);
	    directorService.saveOrUpdateMechanic(mechanic);
        
	    return "redirect:/home";
	}
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/getapplicationdetail", method = RequestMethod.GET)
	public ModelAndView  getapplicationdetail(HttpSession session, Authentication auth, Model model){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
        mav.addObject("user", user);
        mav.addObject("applicationdetail", directorService.getApplicationDetail());
		mav.setViewName("director.applicationdetail");
		return mav;
	};
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/updateapplicationdetail/{id}", method = RequestMethod.GET)
	public ModelAndView  updateapplicationdetail(@PathVariable Long id, HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
		mav.addObject("statuss", directorService.getStatus());
		mav.addObject("applicationdetail", directorService.getApplicationDetailById(id));
        mav.addObject("user", user);
		mav.setViewName("director.updateapplicationdetail");
		return mav;
	};
	
	@RequestMapping(value = { "/updateapplicationdetail/{id}" }, method = { RequestMethod.POST })
	public String updateapplicationdetail(@ModelAttribute("applicationdetails") ApplicationDetail applicationDetail,  Model model, HttpSession session) {
        ApplicationDetail applicationDetail1= directorService.getApplicationDetailById(applicationDetail.getId());
        applicationDetail1.setStatus(applicationDetail.getStatus());
        applicationDetail1.setDateDelivery(applicationDetail.getDateDelivery());
       // applicationDetail.setId(1l);
	    directorService.saveApplicationDetail(applicationDetail1);
        
	    return "redirect:/home";
	}
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/updateapplication/{id}", method = RequestMethod.GET)
	public ModelAndView  updateapplication(@PathVariable Long id, HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
		Application application = mechanicService.getApplicationById(id);
		mav.addObject("application", application);
		mav.addObject("statuss", directorService.getStatus());
		mav.addObject("mechanics", directorService.getMechanicsOnSto(application.getSto()));
        mav.addObject("user", user);
		mav.setViewName("director.updateapplication");
		return mav;
	};
	
	@RequestMapping(value = { "/updateapplication/{id}" }, method = { RequestMethod.POST })
	public String updateapplication(@ModelAttribute("application") Application application,  Model model, HttpSession session) {
        Application application1 = mechanicService.getApplicationById(application.getId());
       // System.out.println("test test tes"+application.getId());
        application1.setMechanic(application.getMechanic());
        application1.setStatus(application.getStatus());
	    clientService.addOrUpdateApplication(application1);
        
	    return "redirect:/home";
	}
	
	}
