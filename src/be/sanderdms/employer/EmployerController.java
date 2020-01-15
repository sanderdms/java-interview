package be.sanderdms.employer;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployerController {
	
	@Autowired
	private EmployerService service;


    @RequestMapping("/")
    public ModelAndView home(){
        ModelAndView mav = new ModelAndView("index");
        
        List<Employer> listEmployer =  service.listAll();
        
        mav.addObject("message", "This is message");
        mav.addObject("list", listEmployer);
        return mav;
    }
    
    @RequestMapping("/new")
    public String newEmployerForm(Map<String, Object> model) {
    	model.put("employer", new Employer());
    	return "new_employer";
    }
    
    
    @RequestMapping("/edit")
    public ModelAndView editEmployerForm(@RequestParam long id){
    	
    	ModelAndView mav = new ModelAndView("edit_employer");
    	Employer employer = service.getById(id);
    	mav.addObject("employer", employer);
    	return mav;
    }
    
    @RequestMapping("/delete")
    public String deleteCustomer(@RequestParam long id) {
    	service.delete(id);
    	return "redirect:/";
    }
    
   
   
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveEmployer(@Valid @ModelAttribute("employer") Employer employer, Errors error) {
    	if(error.hasErrors()) {
    		System.out.println(error);
    		
    	}else {
        	service.save(employer);
    	}
    	return "redirect:/";
    }
    
    
}
