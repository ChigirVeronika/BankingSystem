package by.bsuir.banking.controller;

import by.bsuir.banking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userService;


    @Autowired
    MessageSource messageSource;


}
