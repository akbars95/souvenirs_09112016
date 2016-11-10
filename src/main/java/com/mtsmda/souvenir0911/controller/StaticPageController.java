package com.mtsmda.souvenir0911.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by dminzat on 11/9/2016.
 */
@Controller
public class StaticPageController {

    @RequestMapping(value = {"/", "/index", "/home"}, method = RequestMethod.GET)
    public String indexPage(){
        return "index";
    }

    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    public String catalogPage(){
        return "catalog";
    }

    @RequestMapping(value = "/contact_us", method = RequestMethod.GET)
    public String contactUsPage(){
        return "contact_us";
    }

    @RequestMapping(value = "/about_us", method = RequestMethod.GET)
    public String aboutUsPage(){
        return "about_us";
    }

    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public String notFoundPage(){
        return "404";
    }

}