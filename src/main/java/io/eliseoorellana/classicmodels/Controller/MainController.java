package io.eliseoorellana.classicmodels.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class MainController {
    

    @GetMapping("/")
    public String redirectToSalesManagerIndex() {
        return "redirect:/sales-manager/index";
    }
}
