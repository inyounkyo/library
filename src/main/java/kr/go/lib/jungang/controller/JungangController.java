package kr.go.lib.jungang.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("jungan")
public class JungangController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/")
    public String index(){
        return "jungan/index";
    }
}
