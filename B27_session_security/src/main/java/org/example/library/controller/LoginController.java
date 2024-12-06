package org.example.library.controller;

import jakarta.servlet.http.HttpSession;
import org.example.library.model.User;
import org.example.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    // Display the login page
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Handle login form submission
    @PostMapping("/login")
    public String login(
            @RequestParam String email,
            @RequestParam String password,
            HttpSession session,
            Model model) {

        // Validate user credentials
        User user = userRepository.findByEmail(email)
                .filter(u -> u.getPassword().equals(password)) // Corrected password check
                .orElse(null);

        if (user == null) {
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }

        // Store user information in session
        session.setAttribute("email", user.getEmail());
        return "redirect:/welcome";
    }

    // Handle logout action
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
