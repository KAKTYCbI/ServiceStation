package sjc.sample.app.web;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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

import sjc.example.domain.service.ClientService;
import sjc.example.domain.service.DirectorService;
import sjc.example.domain.service.MechanicService;
import sjc.example.domain.service.UserService;
import sjc.example.domain.model.Application;
import sjc.example.domain.model.Client;
import sjc.example.domain.model.Guest;
import sjc.example.domain.model.Mechanic;
import sjc.example.domain.model.Rent;
import sjc.example.domain.model.Review;
import sjc.example.domain.model.Status;
import sjc.example.domain.model.Sto;
import sjc.example.domain.model.UserPrincipal;

@Controller
@RequestMapping("/client")
public class ClientController {


	@Autowired
	private ClientService clientService;
	
	@Autowired
	private DirectorService directorService;
	
	@Autowired
	private MechanicService mechanicService;
	
	
	@Autowired
	private UserService userService;
	
	
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/addapplication", method = RequestMethod.GET)
	public ModelAndView  addapplication(HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
		mav.addObject("service", clientService.getService());
		mav.addObject("stos",directorService.getSto());
        mav.addObject("user", user);
        mav.addObject("application", new Application());
		mav.setViewName("client.addapplication");
		return mav;
	};
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = { "/addapplication" }, method = { RequestMethod.POST })
	public String addapplication(@ModelAttribute("application") Application application,  Model model, HttpSession session, Authentication auth) {
        application.setDateOrder(new java.util.Date());
        UserPrincipal user = userService.getUserByName(auth.getName());
        Client client = clientService.getCilentById(user.getUserId());
        application.setClient(client);
        Status status = clientService.getStatusByName("zajavka ozhidaet obrabotku");
        System.out.println("тест тест тест " + status.getStatus());
        application.setStatus(status);
        clientService.addOrUpdateApplication(application);
	    return "redirect:/home";
	}
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/addreview/{id}", method = RequestMethod.GET)
	public ModelAndView  addreview(@PathVariable Long id, HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
		Application application = mechanicService.getApplicationById(id);
		mav.addObject("application", application);
        mav.addObject("user", user);
        mav.addObject("review", new Review());
		mav.setViewName("client.addreview");
		return mav;
	};
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = { "/addreview/{id}" }, method = { RequestMethod.POST })
	public String addreview( @PathVariable Long id, @ModelAttribute("review") Review review,  Model model, HttpSession session, Authentication auth) {
        Application application = mechanicService.getApplicationById(id); 
        UserPrincipal user = userService.getUserByName(auth.getName());
        Client client =  application.getClient();
        review.setClient(client);
        review.setDate(new java.util.Date());
        review.setVisible(true);
        if (review.getWhom().equals("sto")){
        	Sto sto = application.getSto();
        	review.setSto(sto);
        }else{
        	Mechanic mechanic = application.getMechanic();
        	review.setMechanic(mechanic);
        }
        clientService.addReview(review);
	    return "redirect:/home";
	}
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/messages", method = RequestMethod.GET)
	public ModelAndView  getmessage(HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
		Client client = clientService.getCilentById(user.getUserId());
        mav.addObject("user", user);
		mav.setViewName("client.messages");
		mav.addObject("message", clientService.getMessageByClient(client));
		return mav;
	};
	

	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/getsto", method = RequestMethod.GET)
	public ModelAndView  getsto(HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
        mav.addObject("user", user);
        mav.addObject("sto", clientService.getAllSto());
		mav.setViewName("client.stolist");
		//Client client = clientService.getCilentById(3l);
		//System.out.println("client client client: " + client.getLogin());
		return mav;
	};
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/getapplication", method = RequestMethod.GET)
	public ModelAndView  getapplicationlist(HttpSession session, Authentication auth, Model model){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
        mav.addObject("user", user);
        Client client = clientService.getCilentById(user.getUserId());
        List<Application> application = clientService.getApplication(client);
        
        System.out.println("client client client: " + application.get(0).getId());
        mav.addObject("application", application);
		mav.setViewName("client.applicationlist");
		return mav;
	};
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/getapplicationinfo/{id}", method = RequestMethod.GET)
	public ModelAndView  getapplicationinfo(@PathVariable Long id, HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
		Application application = mechanicService.getApplicationById(id);
		System.out.println("client client client: " + application.getId());		
        mav.addObject("user", user);
        mav.addObject("application", application );
		mav.setViewName("client.applicationinfo");
		return mav;
	};
	
}
