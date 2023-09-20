package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RollDiceController {
    @RequestMapping(path = "/roll-dice/{n}", method = RequestMethod.GET)
    public String rollDice(@PathVariable int n, Model model) {
        model.addAttribute("n", n);
        int randomNum = (int) (Math.floor(Math.random() * 6) + 1);
        model.addAttribute("randomNum", randomNum);
        if(n == randomNum){
            model.addAttribute("result", "correct");
        } else {
            model.addAttribute("result", "incorrect");
        }
        return "roll-dice";
    }

    @RequestMapping(path = "/roll-dice", method = RequestMethod.GET)
    public String rollDiceHome() {
        return "roll-dice";
    }
}
