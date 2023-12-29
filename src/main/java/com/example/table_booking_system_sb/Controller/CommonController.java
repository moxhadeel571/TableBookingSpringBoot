package com.example.table_booking_system_sb.Controller;

import com.example.table_booking_system_sb.Model.User;
import com.example.table_booking_system_sb.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommonController {
@Autowired
    private UserService userService;


    @GetMapping("/signin")
    public String login(){
        return "login";
    }
    @GetMapping("/register")
    public String register(){
        return "Registration";
    }

    @PostMapping("/saveUser")
    public String registerUser(@ModelAttribute("user") User user, @RequestParam("role") String[] role) {
        user.setRoles(role); // Set the role based on the selected option in the form
        userService.saveUser(user); // Save the user to the database
        return "redirect:/signin"; // Redirect to the login page after successful registration
    }



}
