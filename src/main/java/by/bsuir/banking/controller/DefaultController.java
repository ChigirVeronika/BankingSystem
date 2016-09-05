package by.bsuir.banking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/")
@Controller
public class DefaultController {
    @RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
    public String goToIndex() {
        return "home";
    }
}

