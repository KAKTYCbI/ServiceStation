package sjc.sample.app.web;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.seaf.util.convert.simple.ConverterToInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sjc.example.domain.service.ClientService;
import sjc.example.domain.service.DirectorService;
import sjc.example.domain.service.MechanicService;
import sjc.example.domain.service.UserService;
import sjc.example.domain.model.Application;
import sjc.example.domain.model.Client;
import sjc.example.domain.model.Detail;
import sjc.example.domain.model.Guest;
import sjc.example.domain.model.Mechanic;
import sjc.example.domain.model.Message;
import sjc.example.domain.model.Rent;
import sjc.example.domain.model.Review;
import sjc.example.domain.model.Status;
import sjc.example.domain.model.Sto;
import sjc.example.domain.model.UserPrincipal;
import sjc.sample.app.repository.entity.MechanicEntity;
import sjc.sample.app.repository.entity.validation.ApplicationValidator;
import sjc.sample.app.repository.entity.validation.ReviewValidator;
import sjc.sample.app.repository.entity.validation.addApplicationValidator;

@Controller
@RequestMapping("/client")
public class ClientController {
	private static final Logger logger = LoggerFactory.getLogger(DirectorController.class);
	@Autowired
	private ReviewValidator reviewValidator;

	
	@Autowired
	private addApplicationValidator applicationValidator;

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
	public ModelAndView adddetail(@ModelAttribute("application") Application application, BindingResult bindingResult,
			Model model, HttpSession session, Authentication auth) {
		ModelAndView mav = new ModelAndView();
		applicationValidator.validate(application, bindingResult);
	    if (bindingResult.hasErrors()){
	    	logger.info("Returning addapplication.jsp page");
	    	
			UserPrincipal user = userService.getUserByName(auth.getName());
			mav.addObject("service", clientService.getService());
			mav.addObject("stos",directorService.getSto());
	        mav.addObject("user", user);
	        mav.setViewName("client.addapplication");
	    	return mav;
	    }

		
       application.setDateOrder(new java.util.Date());
       UserPrincipal user = userService.getUserByName(auth.getName());
       Client client = clientService.getCilentById(user.getUserId());
       application.setClient(client);
       Status status = clientService.getStatusByName("zajavka ozhidaet obrabotku");
        System.out.println("òåñò òåñò òåñò " + status.getStatus());
        application.setStatus(status);
        clientService.addOrUpdateApplication(application);
        mav.setViewName("redirect:/home");
    	return mav;
	   
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
	public ModelAndView addreview(@PathVariable Long id,@ModelAttribute("review") Review review, BindingResult bindingResult,
			Model model, HttpSession session, Authentication auth) {
		ModelAndView mav = new ModelAndView();
		reviewValidator.validate(review, bindingResult);
	    if (bindingResult.hasErrors()){
	    	logger.info("Returning addreview.jsp page");
	    	ModelAndView mave = new ModelAndView();
			UserPrincipal user = userService.getUserByName(auth.getName());
			Application application = mechanicService.getApplicationById(id);
			mave.addObject("application", application);
	        mave.addObject("user", user);
	        mave.setViewName("client.addreview");
			return mave;
		}
	    
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
        if (review.getWhom().equals("mechanic"))
        {
		
        	Mechanic mechanic = review.getMechanic();
        	Number size1 = mechanicService.getSizeReviewByMechanic(mechanic);
        	int size = Integer.parseInt(size1.toString());
        	List<Review> reviews = mechanicService.getReviewByMechanic(mechanic, 0, size);
        	
        	Float sum = (float)0;
        	
        	for(Review review1:reviews)
        	{
        	  sum+=review1.getRating();	
        	}
        	Float rating = sum/reviews.size();
        	mechanic.setRating(rating);
        	directorService.saveOrUpdateMechanic(mechanic);
		}else
		{
			Sto sto = review.getSto();
			Number size1 = mechanicService.getSizeReviewBySto(sto);
			int size = Integer.parseInt(size1.toString());
			List<Review> reviews=mechanicService.getReviewBySto(sto, 0, size);
            Float sum = (float)0;
        	
        	for(Review review1:reviews)
        	{
        	  sum+=review1.getRating();	
        	}
        	Float rating = sum/reviews.size();
			sto.setRating(rating);
			directorService.addSto(sto);
		}
        
        mav.setViewName("redirect:/home");
	    return mav;
	}
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/messages", method = RequestMethod.GET)
	public ModelAndView  getmessage(@RequestParam(value = "page", required = false) Integer page, HttpSession session, Authentication auth){
				
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
		Client client = clientService.getCilentById(user.getUserId());
		
		if(page==null) page = 1;
		Integer pageSize = 4;
		Integer startPage = page;
		Integer endPage = page + 5;

		Number size1 = clientService.getSizeMessageBYClient(client);
		int size = Integer.parseInt(size1.toString());
		
		Integer lastPage = (size+(pageSize-1)) / pageSize;
		
		if(endPage >= lastPage) endPage = lastPage;
		if(endPage >= 5 && (endPage - startPage) < 5) startPage = endPage -5;
		
		mav.addObject("page", page);
		mav.addObject("startpage", startPage);
		mav.addObject("endpage", endPage);
        mav.addObject("user", user);
        List<Message> messages1 = clientService.getMessageByClientToPage(client, (page-1)*pageSize,pageSize);
		mav.addObject("message", messages1);
		mav.setViewName("client.messages");
		
		return mav;
	};
	

	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/getsto", method = RequestMethod.GET)
	public ModelAndView  getsto(@RequestParam(value = "page", required = false) Integer page,HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
		if(page==null) page = 1;
		Integer pageSize = 5;
		Integer startPage = page;
		Integer endPage = page + 5;

		Number size1 = directorService.getSizeAllSto();
		int size = Integer.parseInt(size1.toString());
		
		Integer lastPage = (size+(pageSize-1)) / pageSize;
		
		if(endPage >= lastPage) endPage = lastPage;
		if(endPage >= 5 && (endPage - startPage) < 5) startPage = endPage -5;
		
		mav.addObject("page", page);
		mav.addObject("startpage", startPage);
		mav.addObject("endpage", endPage);

		
		mav.addObject("user", user);
        mav.addObject("sto", clientService.getAllSto((page-1)*pageSize,pageSize));
		mav.setViewName("client.stolist");
		//Client client = clientService.getCilentById(3l);
		//System.out.println("client client client: " + client.getLogin());
		return mav;
	};
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/getapplication", method = RequestMethod.GET)
	public ModelAndView  getapplicationlist(@RequestParam(value = "page", required = false) Integer page,HttpSession session, Authentication auth, Model model){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());

        Client client = clientService.getCilentById(user.getUserId());
		if(page==null) page = 1;
		Integer pageSize = 3;
		Integer startPage = page;
		Integer endPage = page + 5;

		Number size1 = clientService.getSizeApplicationByClient(client);
		int size = Integer.parseInt(size1.toString());
		
		Integer lastPage = (size+(pageSize-1)) / pageSize;
		
		if(endPage >= lastPage) endPage = lastPage;
		if(endPage >= 5 && (endPage - startPage) < 5) startPage = endPage -5;
		
		mav.addObject("page", page);
		mav.addObject("startpage", startPage);
		mav.addObject("endpage", endPage);
		
        mav.addObject("user", user);;
       
        
        mav.addObject("application", clientService.getApplication(client, (page-1)*pageSize,pageSize));
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