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
import sjc.example.domain.model.Mechanic;
import sjc.example.domain.model.Status;
import sjc.example.domain.model.UserPrincipal;
import sjc.example.domain.service.ClientService;
import sjc.example.domain.service.DirectorService;
import sjc.example.domain.service.MechanicService;
import sjc.example.domain.service.UserService;

@Controller
@RequestMapping("/mechanic")
public class MechanicController {
	
	@Autowired
	private MechanicService mechanicService;
	
	@Autowired
	private DirectorService directorService;
	
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
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView mechanicHome(HttpSession session, Model model) {

		ModelAndView mav = new ModelAndView();
		mav.addObject("reviews", userService.getReview());
		mav.setViewName("review.list");
		return mav;
		
	}
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/getapplication", method = RequestMethod.GET)
	public ModelAndView  getapplicationlist(HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
		Mechanic mechanic = directorService.getMechanicByName(auth.getName());
        mav.addObject("user", user);
        mav.addObject("application", mechanicService.getCurrentApplication(mechanic));
		mav.setViewName("mechanic.applicationlist");
		return mav;
	};
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/getapplicationdetail", method = RequestMethod.GET)
	public ModelAndView  getapplicationdetail(HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
		//Mechanic mechanic = directorService.getMechanicByName(auth.getName());
        mav.addObject("user", user);  
        mav.addObject("applicationdetail", directorService.getApplicationDetail());
       
		mav.setViewName("mechanic.applicationdetail");
		return mav;
	};
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/addapplicationdetail", method = RequestMethod.GET)
	public ModelAndView  addapplicationdetail(HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
		Status status =clientService.getStatusByName("net nuznych detaley");
		mav.addObject("applications", directorService.getApplicationByStatus(status));
		mav.addObject("applicationdetail", new ApplicationDetail());
        mav.addObject("user", user);
		mav.setViewName("mechanic.addapplicationdetail");
		return mav;
	};
	
	@RequestMapping(value = { "/addapplicationdetail" }, method = { RequestMethod.POST })
	public String addapplicationdetail(@ModelAttribute("applicationdetails") ApplicationDetail applicationDetail,  Model model, HttpSession session) {
        
        applicationDetail.setDateOrder(new Date());
        Status status = clientService.getStatusByName("ozhidaetsia obrobotki directora");
        applicationDetail.setStatus(status);
       // applicationDetail.setId(1l);
	    directorService.saveApplicationDetail(applicationDetail);
        
	    return "redirect:/home";
	}
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/updateapplication/{id}", method = RequestMethod.GET)
	public ModelAndView  updateapplication(@PathVariable Long id, HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
		mav.addObject("application", mechanicService.getApplicationById(id));
		mav.addObject("statuss", directorService.getStatus());
		mav.addObject("detail", clientService.getDetail());
        mav.addObject("user", user);
		mav.setViewName("mechanic.updateapplication");
		return mav;
	};
	
	@RequestMapping(value = { "/updateapplication/{id}" }, method = { RequestMethod.POST })
	public String updateapplication(@ModelAttribute("application") Application application,  Model model, HttpSession session) {
        Application application1 = mechanicService.getApplicationById(application.getId());
       // System.out.println("test test tes"+application.getId());
        application1.setDateCompletion(application.getDateCompletion());
        application1.setDetails(application.getDetails());
        application1.setStatus(application.getStatus());
	    clientService.addOrUpdateApplication(application1);
        
	    return "redirect:/home";
	}
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/getreviewbymechanic", method = RequestMethod.GET)
	public ModelAndView  getreviewbymechanic(HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
		Mechanic mechanic = directorService.getMechanicById(user.getUserId());
        System.out.println("test test test"+ mechanic.getName());
		mav.addObject("user", user);
        mav.addObject("reviews", mechanicService.getReviewByMechanic(mechanic));
		mav.setViewName("mechanic.reviewbymechanic");
		return mav;
	};
		
}
