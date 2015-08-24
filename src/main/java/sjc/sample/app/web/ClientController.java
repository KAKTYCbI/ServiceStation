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
import sjc.example.domain.service.UserService;
import sjc.example.domain.model.Application;
import sjc.example.domain.model.Client;
import sjc.example.domain.model.Guest;
import sjc.example.domain.model.Review;
import sjc.example.domain.model.UserPrincipal;

@Controller
@RequestMapping("/client")
public class ClientController {


	@Autowired
	private ClientService clientService;
		
	@Autowired
	private UserService userService;
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/{id}/review", method = RequestMethod.GET)
	public String getReview( HttpSession session, Model model){
		model.addAttribute("reviews",userService.getReview());
		return "client.reviews";
	};
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/{id}/setOrder", method = RequestMethod.GET)
	public String setOrder(@PathVariable("id") Client client, @ModelAttribute Application application,
			HttpSession session, Model model){
		clientService.addOrUpdateApplication(application);
		return "client.order";
	};
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView  getHome(HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
		List<Review> reviews = new ArrayList<Review>();
		Review review = new Review();
		review.setDate(new java.util.Date());
		review.setText("это и есть отзыв");
		reviews.add(review);
		reviews.add(review);
		mav.addObject("reviews", reviews);
		mav.addObject("user",user);
		mav.setViewName("client.home");
		return mav;
	};
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/{id}/notice", method = RequestMethod.GET)
	public String notice(@PathVariable("id") Client client,
			HttpSession session, Model model){
		model.addAttribute("notice",clientService.getMessageByClient(client));
		return "client.notice";
	};
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/{id}/setreview", method = RequestMethod.GET)
	public String setReview(@PathVariable("id") Client client,@ModelAttribute Review review,
			HttpSession session, Model model){
		clientService.addReview(review);
		return "client.setreview";
	};
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/{id}/listorder", method = RequestMethod.GET)
	public String listOrder(@PathVariable("id") Client client,
			HttpSession session, Model model){
		model.addAttribute(clientService.getApplication(client));
		return "client.listorder";
	};
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/{id}/liststo", method = RequestMethod.GET)
	public String liststo(@PathVariable("id") Client client,
			HttpSession session, Model model){
		model.addAttribute(clientService.getAllSto());
		return "client.listorder";
	};
	
	@RequestMapping(value = "/guest", method = RequestMethod.GET)
	public String setOrder(Guest guest, @ModelAttribute Application application,
			HttpSession session, Model model){
		clientService.addOrUpdateApplication(application);
		return "guest.order";
	};
}
