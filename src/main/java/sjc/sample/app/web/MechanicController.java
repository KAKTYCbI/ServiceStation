package sjc.sample.app.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
import sjc.sample.app.repository.entity.validation.ApplicationDetailValidator;
import sjc.sample.app.repository.entity.validation.ApplicationValidator;

@Controller
@RequestMapping("/mechanic")
public class MechanicController {
	private static final Logger logger = LoggerFactory.getLogger(MechanicController.class);
	@Autowired
	private ApplicationValidator applicationValidator;
	
	@Autowired
	private ApplicationDetailValidator applicationDetailValidator;
	
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
	
	/*@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView mechanicHome(HttpSession session, Model model) {

		ModelAndView mav = new ModelAndView();
		mav.addObject("reviews", userService.getReview());
		mav.setViewName("review.list");
		return mav;
		
	}*/
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/getapplication", method = RequestMethod.GET)
	public ModelAndView  getapplicationlist(@RequestParam(value = "page", required = false) Integer page,HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
		Mechanic mechanic = directorService.getMechanicByName(auth.getName());
		if(page==null) page = 1;
		Integer pageSize = 3;
		Integer startPage = page;
		Integer endPage = page + 5;

		Number size1 = mechanicService.getSizeApplicationByMechanic(mechanic);
		int size = Integer.parseInt(size1.toString());
		
		Integer lastPage = (size+(pageSize-1)) / pageSize;
		
		if(endPage >= lastPage) endPage = lastPage;
		if(endPage >= 5 && (endPage - startPage) < 5) startPage = endPage -5;
		
		mav.addObject("page", page);
		mav.addObject("startpage", startPage);
		mav.addObject("endpage", endPage);

        mav.addObject("user", user);
        mav.addObject("application", mechanicService.getCurrentApplication(mechanic, (page-1)*pageSize,pageSize));
		mav.setViewName("mechanic.applicationlist");
		return mav;
	};
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/getapplicationdetail", method = RequestMethod.GET)
	public ModelAndView  getapplicationdetail(@RequestParam(value = "page", required = false) Integer page,HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
		//Mechanic mechanic = directorService.getMechanicByName(auth.getName());
		if(page==null) page = 1;
		Integer pageSize = 4;
		Integer startPage = page;
		Integer endPage = page + 5;

		Number size1 = directorService.getSizeAllApplicationDetail();
		int size = Integer.parseInt(size1.toString());
		
		Integer lastPage = (size+(pageSize-1)) / pageSize;
		
		if(endPage >= lastPage) endPage = lastPage;
		if(endPage >= 5 && (endPage - startPage) < 5) startPage = endPage -5;
		
		mav.addObject("page", page);
		mav.addObject("startpage", startPage);
		mav.addObject("endpage", endPage);

        mav.addObject("user", user);  
        mav.addObject("applicationdetail", directorService.getApplicationDetail((page-1)*pageSize,pageSize));
       
		mav.setViewName("mechanic.applicationdetail");
		return mav;
	};
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/addapplicationdetail", method = RequestMethod.GET)
	public ModelAndView  addapplicationdetail(HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
		Status status =clientService.getStatusByName("net nuznych detaley");
		Number size1 = directorService.getSizeApplicationByStatus(status);
		int size = Integer.parseInt(size1.toString());
		mav.addObject("applications", directorService.getApplicationByStatus(status, 0, size));
		mav.addObject("applicationdetail", new ApplicationDetail());
        mav.addObject("user", user);
		mav.setViewName("mechanic.addapplicationdetail");
		return mav;
	};
	
	@RequestMapping(value = { "/addapplicationdetail" }, method = { RequestMethod.POST })
	public ModelAndView addapplicationdetail(@ModelAttribute("applicationdetail") ApplicationDetail applicationDetail,Authentication auth,
			BindingResult bindingResult, Model model, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		applicationDetailValidator.validate(applicationDetail,bindingResult);
		if (bindingResult.hasErrors()){
	    	logger.info("Returning addapplicationdetail.jsp page");
	    	UserPrincipal user = userService.getUserByName(auth.getName());
	    	Status status =clientService.getStatusByName("net nuznych detaley");
	    	Number size1 = directorService.getSizeApplicationByStatus(status);
			int size = Integer.parseInt(size1.toString());
			//mav.addObject("applicationdetail", new ApplicationDetail());
			mav.addObject("applications", directorService.getApplicationByStatus(status, 0, size));
		    mav.addObject("user", user);
			mav.setViewName("mechanic.addapplicationdetail");
			return mav;
		};
        
        applicationDetail.setDateOrder(new Date());
        Status status = clientService.getStatusByName("ozhidaetsia obrobotki directora");
        applicationDetail.setStatus(status);
       // applicationDetail.setId(1l);
	    directorService.saveApplicationDetail(applicationDetail);
	    mav.setViewName("home");
        
	    return mav;
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
	public ModelAndView updateapplication(@PathVariable Long id,@ModelAttribute("application") Application application,  Model model, HttpSession session,
			Authentication auth,BindingResult bindingResult) {
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
		applicationValidator.validate(application,bindingResult);
		if (bindingResult.hasErrors()){
	    	logger.info("Returning addapplication.jsp page");
	    	mav.addObject("application", mechanicService.getApplicationById(id));
			mav.addObject("statuss", directorService.getStatus());
			mav.addObject("detail", clientService.getDetail());
	        mav.addObject("user", user);
			mav.setViewName("mechanic.updateapplication");
			return mav;
		};
	    
		
		
        Application application1 = mechanicService.getApplicationById(application.getId());
       // System.out.println("test test tes"+application.getId());
        application1.setDateCompletion(application.getDateCompletion());
        application1.setDetails(application.getDetails());
        application1.setStatus(application.getStatus());
	    clientService.addOrUpdateApplication(application1);
	    mav.setViewName("mechanic.updateapplication");
	    return mav;
	}
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/getreviewbymechanic", method = RequestMethod.GET)
	public ModelAndView  getreviewbymechanic(@RequestParam(value = "page", required = false) Integer page,HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
		Mechanic mechanic = directorService.getMechanicById(user.getUserId());
        System.out.println("test test test"+ mechanic.getName());
        if(page==null) page = 1;
		Integer pageSize = 4;
		Integer startPage = page;
		Integer endPage = page + 5;

		Number size1 = mechanicService.getSizeReviewByMechanic(mechanic);
		int size = Integer.parseInt(size1.toString());
		
		Integer lastPage = (size+(pageSize-1)) / pageSize;
		
		if(endPage >= lastPage) endPage = lastPage;
		if(endPage >= 5 && (endPage - startPage) < 5) startPage = endPage -5;
		
		mav.addObject("page", page);
		mav.addObject("startpage", startPage);
		mav.addObject("endpage", endPage);

		mav.addObject("user", user);
        mav.addObject("reviews", mechanicService.getReviewByMechanic(mechanic, (page-1)*pageSize,pageSize));
		mav.setViewName("mechanic.reviewbymechanic");
		return mav;
	};
		
}
