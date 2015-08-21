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

import sjc.example.domain.model.Detail;
import sjc.example.domain.model.Director;
import sjc.example.domain.model.Mechanic;
import sjc.example.domain.model.Rent;
import sjc.example.domain.model.Service;
import sjc.example.domain.model.Sto;
import sjc.example.domain.service.DirectorService;

@Controller
@RequestMapping("/director")
public class DirectorConrtoller {
	
	@Autowired
	private DirectorService directorService;

	@PreAuthorize("isFullyAuthenticated()") 
	@RequestMapping(value = "/{id}/listOrder", method = RequestMethod.GET)
	public String getListOrder(@PathVariable("id") Director director,
			HttpSession session, Model model){
		model.addAttribute("listOrder",directorService.getApplication());
		return "director.listOrder";
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
