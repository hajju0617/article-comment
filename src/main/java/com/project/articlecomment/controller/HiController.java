package com.project.articlecomment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HiController {
    @GetMapping("/hi")
    public String hi(Model model) {
        model.addAttribute("username", "가나다");
        return "hi";
    }
}
