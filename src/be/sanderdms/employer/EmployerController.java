package be.sanderdms.employer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployerController {


    @RequestMapping
    public ModelAndView home(){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("message", "This is working controller");
        return mav;
    }
}
