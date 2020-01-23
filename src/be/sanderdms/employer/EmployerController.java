package be.sanderdms.employer;

import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmployerController {
	
	@Autowired
	private EmployerService service;


    @RequestMapping("/")
    public ModelAndView home(){
        ModelAndView mav = new ModelAndView("index");
        
        List<Employer> listEmployer =  service.listAll();
        
        mav.addObject("listcount", service.countItems());
        mav.addObject("list", listEmployer);
        return mav;
    }
    
    
    @RequestMapping("/new")
    public String newEmployerForm(final Model model) {
    	   if(!model.containsAttribute("employer")){
    	        model.addAttribute("employer", new Employer());
    	    }
    	return "new_employer";
    	//https://stackoverflow.com/questions/15903238/passing-bindingresult-through-redirectionattributes
    }
    
    
    @RequestMapping("/edit")
    public ModelAndView editEmployerForm(@RequestParam long id, final Model model){
    	ModelAndView mav = new ModelAndView("edit_employer");
    	
    	// Model can already be provided in case of errors during /save method
    	// Check if model is already set, else take values from database
    	if(!model.containsAttribute("employer")) {
    		Employer employer = service.getById(id);
        	mav.addObject("employer", employer);
    	}else {
        	mav.addObject("employer", model.getAttribute("employer"));
    	}
    	return mav;
    }
    
    @RequestMapping("/delete")
    public String deleteCustomer(@RequestParam long id) {
    	service.delete(id);
    	return "redirect:/";
    }
    
   
   
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveEmployer(@Valid @ModelAttribute("employer") Employer employer, BindingResult binding, final HttpServletRequest request, RedirectAttributes attr ) {
		if(binding.hasErrors()) {
        attr.addFlashAttribute("org.springframework.validation.BindingResult.employer", binding);
    	attr.addFlashAttribute("employer", employer); //--> https://github.com/spring-projects/spring-framework/issues/23589
		String referer = request.getHeader("referer");
    	return "redirect:" +referer;
    	}else {
        	service.save(employer);
    	}
    	
    	return "redirect:/";
    }
    
    
}
