package kr.go.lib.yeonsu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
@PropertySource("classpath:application.yml")
@RequestMapping("yeonsu/admin")
public class AdminYeonsuController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${spring.pyMenuMain.path}")
    String path;

    @RequestMapping("/index")
    public String index(){
        return "yeonsu/admin/index";
    }

    @RequestMapping(value="/xxx", method = RequestMethod.GET)
    public String admin( ModelMap model)throws IOException {

        return "/yeonsu/admin";
    }

}