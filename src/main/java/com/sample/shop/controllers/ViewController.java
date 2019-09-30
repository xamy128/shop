package com.sample.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.Map;

/**
 * Controller to pass the required views with models.
 */
@Controller
public class ViewController {

    public ModelAndView customer() {
        Map<String, String> model = new HashMap<>();
        return new ModelAndView("sites/customer", model);
    }
}
