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
import sjc.example.domain.model.Detail;
import sjc.example.domain.model.Director;
import sjc.example.domain.model.Mechanic;
import sjc.example.domain.model.Rent;
import sjc.example.domain.model.ReportInfo;
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
import sjc.sample.app.repository.entity.validation.ApplicationDetailValidator;
import sjc.sample.app.repository.entity.validation.ApplicationValidator;
import sjc.sample.app.repository.entity.validation.DetailValidator;
import sjc.sample.app.repository.entity.validation.MechanicValidator;
import sjc.sample.app.repository.entity.validation.RentValidator;
import sjc.sample.app.repository.entity.validation.ReportValidator;
import sjc.sample.app.repository.entity.validation.ServiceValidator;
import sjc.sample.app.repository.entity.validation.StoValidator;



@Controller
@RequestMapping("/director")
public class DirectorController {
	private static final Logger logger = LoggerFactory.getLogger(DirectorController.class);
	@Autowired
	private ReportValidator reportValidator;
	
	@Autowired
	private RentValidator rentValidator;
	
	@Autowired
	private StoValidator stoValidator;
	
	@Autowired
	private ApplicationDetailValidator applicationDetailValidator;

	@Autowired
	private ApplicationValidator applicationValidator;
	
	@Autowired
	private ServiceValidator serviceValidator;

	@Autowired
	private MechanicValidator mechanicValidator;
	
	@Autowired
	private DetailValidator detailValidator;
	
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
	public ModelAndView  getapplicationlist(@RequestParam(value = "page", required = false) Integer page,HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
		Status status = clientService.getStatusByName("zajavka ozhidaet obrabotku");
		if(page==null) page = 1;
		Integer pageSize = 3;
		Integer startPage = page;
		Integer endPage = page + 5;

		Number size1 = directorService.getSizeApplicationByStatus(status);
		int size = Integer.parseInt(size1.toString());
		
		Integer lastPage = (size+(pageSize-1)) / pageSize;
		
		if(endPage >= lastPage) endPage = lastPage;
		if(endPage >= 5 && (endPage - startPage) < 5) startPage = endPage -5;
		
		mav.addObject("page", page);
		mav.addObject("startpage", startPage);
		mav.addObject("endpage", endPage);

        mav.addObject("user", user);
        mav.addObject("application", directorService.getApplicationByStatus(status, (page-1)*pageSize,pageSize));
		mav.setViewName("director.applicationlist");
		return mav;
	};
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/getmechanics", method = RequestMethod.GET)
	public ModelAndView  getmechaniclist(@RequestParam(value = "page", required = false) Integer page,HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
		if(page==null) page = 1;
		Integer pageSize = 4;
		Integer startPage = page;
		Integer endPage = page + 5;

		Number size1 = directorService.getSizeAllMechanic();
		int size = Integer.parseInt(size1.toString());
		
		Integer lastPage = (size+(pageSize-1)) / pageSize;
		
		if(endPage >= lastPage) endPage = lastPage;
		if(endPage >= 5 && (endPage - startPage) < 5) startPage = endPage -5;
		
		mav.addObject("page", page);
		mav.addObject("startpage", startPage);
		mav.addObject("endpage", endPage);

        mav.addObject("user", user);
        mav.addObject("mechanic", directorService.getMechanicsToPage((page-1)*pageSize,pageSize));
		mav.setViewName("director.mechanicslist");
		return mav;
	};
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/getsto", method = RequestMethod.GET)
	public ModelAndView  getstolist(@RequestParam(value = "page", required = false) Integer page,HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
		if(page==null) page = 1;
		Integer pageSize = 3;
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
        mav.addObject("sto", directorService.getStoToPage((page-1)*pageSize,pageSize));
		mav.setViewName("director.stolist");
		return mav;
	};
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/mechaniclistbysto/{id}", method = RequestMethod.GET)
	public ModelAndView  getmechaniclistbysto(@RequestParam(value = "page", required = false) Integer page,@PathVariable Long id,  HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
		Sto sto = directorService.getStoById(id);
		Number size1 = directorService.getSizeMechanicOnSto(sto);
		int size = Integer.parseInt(size1.toString());
		System.out.println("Test test test"+sto.getName());
		if(page==null) page = 1;
		Integer pageSize = 3;
		Integer startPage = page;
		Integer endPage = page + 5;
		Integer lastPage = (size+(pageSize-1)) / pageSize;
		
		if(endPage >= lastPage) endPage = lastPage;
		if(endPage >= 5 && (endPage - startPage) < 5) startPage = endPage -5;
		
		mav.addObject("page", page);
		mav.addObject("startpage", startPage);
		mav.addObject("endpage", endPage);

        mav.addObject("user", user);
        mav.addObject("mechanic", directorService.getMechanicsOnSto(sto, (page-1)*pageSize,pageSize));
		mav.setViewName("director.mechaniclistbysto");
		return mav;
	};
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/getreport", method = RequestMethod.GET)
	public ModelAndView  getreport(HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
        mav.addObject("user", user);
        mav.addObject("reportinfo", new ReportInfo());
        mav.addObject("stos", directorService.getSto());
		mav.setViewName("director.getreport");
		return mav;
	};
	
	@RequestMapping(value = { "/getreport" }, method = { RequestMethod.POST })
	public ModelAndView getreport(@ModelAttribute("reportinfo") ReportInfo reportinfo, BindingResult bindingResult,
			Model model, HttpSession session, Authentication auth) {
		    ModelAndView mav = new ModelAndView();
			reportValidator.validate(reportinfo, bindingResult);
		    if (bindingResult.hasErrors()){
		    	logger.info("Returning getreport.jsp page");
		    	UserPrincipal user = userService.getUserByName(auth.getName());
		    	mav.addObject("user", user);
		    	
		        mav.addObject("stos", directorService.getSto());
		        mav.setViewName("director.getreport");
		    	return mav;
		    } else{
		
		
		ModelAndView mave = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
        mave.addObject("user", user);
		if (reportinfo.getWhom().equals("sto"))
		{
			mave.addObject("report", directorService.getreportSto(reportinfo.getSto(), reportinfo.getDateStart(), reportinfo.getDateFinish()));
			mave.addObject("reportinfo", reportinfo);
			mave.setViewName("director.reportsto");
		}else
		{
			mave.addObject("report", directorService.getreportAll(reportinfo.getDateStart(), reportinfo.getDateFinish()));
			mave.addObject("reportinfo", reportinfo);
			mave.setViewName("director.reportall");
		}
        
	    return mave;}
	}
	
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
	public ModelAndView adddetail(@ModelAttribute("detail") Detail detail, BindingResult bindingResult,
			Model model, HttpSession session, Authentication auth) {
		ModelAndView mav = new ModelAndView();
		detailValidator.validate(detail, bindingResult);
	    if (bindingResult.hasErrors()){
	    	logger.info("Returning adddetail.jsp page");
	    	UserPrincipal user = userService.getUserByName(auth.getName());
	    	mav.addObject("user", user);
	        
	    	mav.setViewName("director.adddetail");
	    	return mav;
	    }

	    directorService.addDetail(detail);
		mav.setViewName("redirect:/home");
	    return mav;
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
	public ModelAndView addsto(@ModelAttribute("sto") Sto sto,BindingResult bindingResult, 
			Model model, HttpSession session, Authentication auth) {
		ModelAndView mav = new ModelAndView();
		stoValidator.validate(sto, bindingResult);
		if (bindingResult.hasErrors()){
			UserPrincipal user = userService.getUserByName(auth.getName());
	        mav.addObject("user", user);
	    	logger.info("Returning addsto.jsp page");
	    	mav.setViewName("director.addsto");
	    	return mav;
	    }
		
        sto.setRating((float)0);
	    directorService.addSto(sto);
	    mav.setViewName("redirect:/home");
	    return mav;
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
	public ModelAndView updatesto(@PathVariable Long id,@ModelAttribute("sto") Sto sto,BindingResult bindingResult,
			Model model, HttpSession session, Authentication auth) {
		ModelAndView mav = new ModelAndView();
		rentValidator.validate(sto, bindingResult);
		if (bindingResult.hasErrors()){
	    	logger.info("Returning updatesto.jsp page");
	    	UserPrincipal user = userService.getUserByName(auth.getName());
	        mav.addObject("user", user);
	        mav.addObject("sto", directorService.getStoById(id));
	    	mav.setViewName("director.updatesto");
	    	return mav;
	    }
		
        Sto sto1 = directorService.getStoById(id);
        sto1.setName(sto.getName());
        sto1.setPrice(sto.getPrice());
	    directorService.addSto(sto1);
	    mav.setViewName("redirect:/home");
	    return mav;
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
	public ModelAndView addservice(@ModelAttribute("service") Service service,BindingResult bindingResult, 
			Model model, HttpSession session, Authentication auth) {
		ModelAndView mav = new ModelAndView();
		serviceValidator.validate(service, bindingResult);
	    if (bindingResult.hasErrors()){
	    	logger.info("Returning addservice.jsp page");
	    	UserPrincipal user = userService.getUserByName(auth.getName());
	        mav.addObject("user", user);
			mav.setViewName("director.addservice");
	    	return mav;
	    }


	    directorService.addService(service);
	    mav.setViewName("redirect:/home");
	    return mav;
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
	public ModelAndView updatemechanic(@PathVariable Long id, @ModelAttribute("mechanic") Mechanic mechanic,  Model model, 
			HttpSession session, BindingResult bindingResult,Authentication auth) {
		ModelAndView mav = new ModelAndView();
		mechanicValidator.validate(mechanic, bindingResult);
	    if (bindingResult.hasErrors()){
	    	UserPrincipal user = userService.getUserByName(auth.getName());
	        mav.addObject("user", user);
	        mav.addObject("mechanic", directorService.getMechanicById(id));
	    	mav.addObject("stos", directorService.getSto());
			mav.setViewName("director.addmechanic");
	    	  	return mav;
	    }
		Mechanic mechanic1 = directorService.getMechanicById(mechanic.getUserId());
		mechanic.setLogin(mechanic.getName());
		mechanic.setRating(mechanic1.getRating());
		mechanic.setRole(UserRole.MECHANIC);
	    directorService.saveOrUpdateMechanic(mechanic);
        mav.setViewName("redirect:/home");
	    return mav;
	}
	
	@RequestMapping(value = { "/addmechanic" }, method = { RequestMethod.POST })
	public ModelAndView addmechanic(@ModelAttribute("mechanic") Mechanic mechanic, BindingResult bindingResult,
			Model model, HttpSession session, Authentication auth) {
		ModelAndView mav = new ModelAndView();
		mechanicValidator.validate(mechanic, bindingResult);
	    if (bindingResult.hasErrors()){
	    	UserPrincipal user = userService.getUserByName(auth.getName());
	        mav.addObject("user", user);
	    	mav.addObject("stos", directorService.getSto());
			mav.setViewName("director.addmechanic");
	    	  	return mav;
	    }
		mechanic.setLogin(mechanic.getName());
		mechanic.setRating((float)0);
		mechanic.setRole(UserRole.MECHANIC);
	    directorService.saveOrUpdateMechanic(mechanic);
	    mav.setViewName("redirect:/home");
	    return mav;
	}
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/getapplicationdetail", method = RequestMethod.GET)
	public ModelAndView  getapplicationdetail(@RequestParam(value = "page", required = false) Integer page,HttpSession session, Authentication auth, Model model){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
        mav.addObject("user", user);
        if(page==null) page = 1;
		Integer pageSize = 3;
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

        mav.addObject("applicationdetail", directorService.getApplicationDetail((page-1)*pageSize,pageSize));
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
	public ModelAndView updateapplicationdetail(@PathVariable Long id, @ModelAttribute("applicationdetails") ApplicationDetail applicationDetail, BindingResult bindingResult,
			Model model, HttpSession session, Authentication auth) {
		ModelAndView mav = new ModelAndView();
		applicationDetailValidator.validate(applicationDetail, bindingResult);
	    if (bindingResult.hasErrors()){
	    	UserPrincipal user = userService.getUserByName(auth.getName());
	    	mav.addObject("statuss", directorService.getStatus());
			mav.addObject("applicationdetail", directorService.getApplicationDetailById(id));
	        mav.addObject("user", user);
			mav.setViewName("director.updateapplicationdetail");
	    	  	return mav;
	    }
		
        ApplicationDetail applicationDetail1= directorService.getApplicationDetailById(applicationDetail.getId());
        applicationDetail1.setStatus(applicationDetail.getStatus());
        applicationDetail1.setDateDelivery(applicationDetail.getDateDelivery());
       // applicationDetail.setId(1l);
	    directorService.saveApplicationDetail(applicationDetail1);
	    mav.setViewName("redirect:/home");
	    return mav;
	}
	
	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/updateapplication/{id}", method = RequestMethod.GET)
	public ModelAndView  updateapplication(@PathVariable Long id, HttpSession session, Authentication auth){
		ModelAndView mav = new ModelAndView();
		UserPrincipal user = userService.getUserByName(auth.getName());
		Application application = mechanicService.getApplicationById(id);
		Number size1 = directorService.getSizeMechanicOnSto(application.getSto());
		int size = Integer.parseInt(size1.toString());
		mav.addObject("application", application);
		mav.addObject("statuss", directorService.getStatus());
		mav.addObject("mechanics", directorService.getMechanicsOnSto(application.getSto(), 0, size));
        mav.addObject("user", user);
		mav.setViewName("director.updateapplication");
		return mav;
	};
	
	@RequestMapping(value = { "/updateapplication/{id}" }, method = { RequestMethod.POST })
	public ModelAndView updateapplication(@PathVariable Long id,@ModelAttribute("application") Application application,  Model model,BindingResult bindingResult,
			HttpSession session,  Authentication auth) {
		ModelAndView mav = new ModelAndView();
		applicationValidator.validate(application, bindingResult);
		if (bindingResult.hasErrors()){
			Application application1 = mechanicService.getApplicationById(id);
			UserPrincipal user = userService.getUserByName(auth.getName());
			Number size1 = directorService.getSizeMechanicOnSto(application1.getSto());
			int size = Integer.parseInt(size1.toString());
			mav.addObject("application", application1);
			mav.addObject("statuss", directorService.getStatus());
			mav.addObject("mechanics", directorService.getMechanicsOnSto(application1.getSto(), 0, size));
	        mav.addObject("user", user);
			mav.setViewName("director.updateapplication");
	    	  	return mav;
	    }

		Application application1 = mechanicService.getApplicationById(application.getId());
        application1.setMechanic(application.getMechanic());
        application1.setStatus(application.getStatus());
	    clientService.addOrUpdateApplication(application1);
        mav.setViewName("redirect:/home");
	    return mav;
	}
	
	}
