package com.sample.shop.common.controller;

import com.sample.shop.common.TemplateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
 * Contains the first URLs hit by the application users.
 * It also contains the error mappings for the controller errors.
 *
 * @author Ammarah Shakeel
 */
@Controller
public class RootViewController implements ErrorController {
    private TemplateUtils template;

    @Autowired
    public RootViewController(TemplateUtils templateUtils){
        this.template = templateUtils;
    }

    @RequestMapping(value = "/")
    public ModelAndView login() {

        Map<String, String> map = Collections.singletonMap("title", template.message("login.site.title"));
        return new ModelAndView("sites/login", map);
    }

    @RequestMapping("/error")
    public ModelAndView error(HttpServletResponse res) {
        Map<String, Object> errorMap = new HashMap<>();

        if (res.getStatus() == HttpStatus.NOT_FOUND.value()) {
            errorMap.put("errorCode", HttpStatus.NOT_FOUND.value());
            errorMap.put("title", template.message("error.not_found.title"));
            errorMap.put("message", template.message("error.not_found.msg"));
        }

        else if(res.getStatus() == HttpStatus.UNAUTHORIZED.value()) {
            errorMap.put("errorCode", HttpStatus.UNAUTHORIZED.value());
            errorMap.put("title", template.message("error.no_authorization.title"));
            errorMap.put("message", template.message("error.no_authorization.msg"));
        }

        else if (res.getStatus() == HttpStatus.BAD_REQUEST.value()) {
            errorMap.put("errorCode", HttpStatus.UNAUTHORIZED.value());
            errorMap.put("title", template.message("error.bad_request.title"));
            errorMap.put("message", template.message("error.bad_request.msg"));
        }

        else {
            errorMap.put("errorCode", res.getStatus());
            errorMap.put("title", template.message("error.unknown_error.title"));
            errorMap.put("message", template.message("error.unknown_error.msg"));
        }
        return new ModelAndView("sites/error", errorMap);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}