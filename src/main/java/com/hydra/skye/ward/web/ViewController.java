package com.hydra.skye.ward.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yahto on 16/03/2018
 */
@Controller
public class ViewController {
    @RequestMapping(value = "/backend/**", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("v", "dev");
        return "index";
    }
}
