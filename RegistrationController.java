package watch.controller;

import watch.entity.User;
import watch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }
    @PostMapping("/register")
    public String registerNewUser(@ModelAttribute("user") User user, Model model) {
        userService.registerNewUser(user);
        return "redirect:/login";
    }
}
