package sjc.sample.app.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.util.concurrent.Service;

import sjc.example.domain.model.Client;
import sjc.example.domain.model.Review;
import sjc.example.domain.model.Status;
import sjc.example.domain.model.UserPrincipal;
import sjc.example.domain.model.UserRole;
import sjc.example.domain.service.ClientService;
import sjc.example.domain.service.DirectorService;
import sjc.example.domain.service.UserService;

@Controller
@RequestMapping("")
public class LoginController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private DirectorService directorService;

	@RequestMapping(value = { "", "/", "/login" }, method = { RequestMethod.GET })
	public String login() {
		/*UserPrincipal user = userService.getUserByName("user");
		System.out.println("user: " + user.getClass().getCanonicalName());
		System.out.println("role: " + user.getRole().toString());*/
		return "login";
	}

	@RequestMapping(value = { "/access-denied" }, method = { RequestMethod.GET })
	public String denied() {
		return "denied";
	}
	
	@RequestMapping(value = { "/registration" }, method = { RequestMethod.GET })
	public String registration(Model model) {
		model.addAttribute("client", new Client());
		return "registration";
	}
	
	@RequestMapping(value = { "/registration" }, method = { RequestMethod.POST })
	public String registration(@ModelAttribute("client") Client user,  Model model, HttpSession session) {

	    //userService.getUserByID(1l);
		UserPrincipal user2 = userService.getUserByName(user.getName());
        if (user2 == null){
        user.setRole(UserRole.CLIENT);	
		clientService.saveClient(user);
        }
	    return "login";
	}

	@RequestMapping(value = "/login/failure", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {

		model.addAttribute("error", "dsjkfhdskjfhdskjfhjds");
		return "login";

	}

	@RequestMapping(value = "/login", method = { RequestMethod.POST })
	public ModelAndView login(
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password,
			HttpServletRequest request, HttpSession session) {

		ModelAndView mav = new ModelAndView();

		UserPrincipal user = userService.getUserByName(username);

		System.out.println("user: " + user.getClass().getCanonicalName());
		System.out.println("role: " + user.getRole().toString());

		session.setAttribute("user", user);
		mav.addObject("user", user);
		mav.setViewName("client.home");

		return mav;
	}

	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpSession session) {

		ModelAndView model = new ModelAndView();
		model.setViewName("login");

		session.setAttribute("user", null);
		session.invalidate();

		return model;
	}

	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView  getHome(HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
		List<Review> reviews = userService.getReview();
		//Review review = reviews.get(0);
		//System.out.println("Review review sto name  =  "+review.getSto().getName()); 
		mav.addObject("reviews", reviews);
		mav.addObject("user",user);
		mav.setViewName("home");
		return mav;
	};
}