package sjc.sample.app.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
import sjc.example.domain.model.Mechanic;
import sjc.example.domain.service.MechanicService;
import sjc.example.domain.service.UserService;

@Controller
@RequestMapping("/mechanic")
public class MechanicController {
	
	@Autowired
	private MechanicService mechanicService;
	
	@Autowired
	private UserService userService;
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView mechanicHome(HttpSession session, Model model) {

		ModelAndView mav = new ModelAndView();
		mav.addObject("reviews", userService.getReview());
		mav.setViewName("review.list");
		return mav;
		
	}
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/{id}/applicationlist", method = RequestMethod.GET)
	public ModelAndView getApplicationList(@PathVariable("id") Mechanic mechanic
			,HttpSession session, Model model) {
        
		ModelAndView mav = new ModelAndView();
		mav.addObject("application", mechanicService.getCurrentApplication(mechanic));
		mav.setViewName("application.list");
		return mav;
		
	}
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/application/{id}", method = RequestMethod.GET)
	public ModelAndView getApplicationId(@PathVariable Long id
			,HttpSession session, Model model) {
        
		ModelAndView mav = new ModelAndView();
		mav.addObject("application", mechanicService.getApplicationById(id));
		mav.setViewName("application.info");
		return mav;
		
	}
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/application/{id}", method = RequestMethod.POST)
	public ModelAndView getUpdateApplicationId(@PathVariable("id") Application application
			,HttpSession session, Model model) {
        
		ModelAndView mav = new ModelAndView();
		mechanicService.updateApplication(application);
		mav.addObject("application", mechanicService.getCurrentApplication(application.getMechanic()));
		mav.setViewName("application.list");
		return mav;
		
	}
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/{id}/applicationdetaillist", method = RequestMethod.GET)
	public ModelAndView getApplicationDetailList(@PathVariable("id") Mechanic mechanic
			,HttpSession session, Model model) {
        
		ModelAndView mav = new ModelAndView();
		mav.addObject("applicationdetail", mechanicService.getAllApplicationDetail(mechanic));
		mav.setViewName("applicationdetail.list");
		return mav;
		
	}
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/{id}/applicationdetaillist/new", method = RequestMethod.GET)
	public String getApplicationDetailNew( HttpSession session, Model model) {
		
		return "applicationdetail.new";
		
	}
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/{id}/applicationdetaillist/new", method = RequestMethod.POST)
	public String postApplicationDetailNew(@PathVariable("id") Mechanic mechanic,
			@ModelAttribute ApplicationDetail applicationDetail,
			HttpSession session, Model model) {
		mechanicService.orderDetail(applicationDetail);
		
		return "applicationdetail.list";
		
	}
	
	
	

	
}
