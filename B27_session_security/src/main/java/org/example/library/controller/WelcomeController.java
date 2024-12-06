package org.example.library.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcome(HttpSession session, Model model) {
        if (session.getAttribute("email") == null) {
            return "redirect:/login";
        }
        model.addAttribute("email", session.getAttribute("email"));
        return "welcome";
    }
}