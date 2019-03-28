package com.example.demo.Controller;

import com.example.demo.Model.Values;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.print.DocFlavor;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home/index";
    }

    //post fra form
    @PostMapping("/calculate")
    public String calculate(@ModelAttribute Values val, Model model){
        String value_1 = val.getValue_1();
        String value_2 = val.getValue_2();

        //konverter
        //udregn resultat
        double result = Double.parseDouble(value_1) + Double.parseDouble(value_2);

        // tilføj resultat til model
        model.addAttribute("result", result);

        //return ny side
        return "home/result";
    }


}
