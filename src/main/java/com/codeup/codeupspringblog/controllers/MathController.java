package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @RequestMapping(path="/add/{num1}/and/{num2}", method= RequestMethod.GET)
    @ResponseBody
    public String add(@PathVariable int num1, @PathVariable int num2){
        int sum = num1 + num2;
        return num1 + " + " + num2 + " is " + sum;
    }

    @RequestMapping(path="/subtract/{num1}/from/{num2}", method= RequestMethod.GET)
    @ResponseBody
    public String subtract(@PathVariable int num1, @PathVariable int num2){
        int result = num2 - num1;
        return num2 + " - " + num1 + " is " + result;
    }

    @RequestMapping(path="/multiply/{num1}/and/{num2}", method= RequestMethod.GET)
    @ResponseBody
    public String multiply(@PathVariable int num1, @PathVariable int num2){
        int result = num1 * num2;
        return num1 + " x " + num2 + " is " + result;
    }

    @RequestMapping(path="/divide/{num1}/by/{num2}", method= RequestMethod.GET)
    @ResponseBody
    public String divide(@PathVariable int num1, @PathVariable int num2){
        double result = (double) num1 / num2;
        return num1 + " / " + num2 + " is " + result;
    }
}
