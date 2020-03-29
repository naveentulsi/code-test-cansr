package com.cansr.sample1.web;

import com.cansr.sample1.UserDto;
import com.cansr.sample1.model.MySqlUser;
import com.cansr.sample1.service.IUserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
@Log4j2
public class HomeController {

    IUserService userService;

    @Autowired
    public void setUserService(@Qualifier("userService") IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String home(Model model) {
        log.info("Start home - /");

        final Optional<List<MySqlUser>> userLstOpt = this.userService.fetchAllUsers();
        if (userLstOpt.isPresent()) {
            log.info("user is present in system");
            model.addAttribute("users", userLstOpt.get());
        } else {
            log.info("user is not present");
            model.addAttribute("users", "No user in system");
        }
        return "welcome";
    }

    @RequestMapping(value = "/editUser/{id}", method = RequestMethod.GET)
    public String getUserDetails(@PathVariable(name = "id") Long Id, Model model) {
        log.info("Start editUserDetails");
        log.info(Id);
        final Optional<MySqlUser> userOptional = this.userService.fetchUser(Id);

        if (userOptional.isPresent()) {
            model.addAttribute("user", userOptional.get());
        } else {
            model.addAttribute("user", "no user present");
        }
        return "edit-user";
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(UserDto userDto) {
        log.info("Start saveUserDetails");
        final Boolean isSaved = this.userService.saveUser(userDto);

        if (isSaved)
            return "success";

        return "error";
    }


}
