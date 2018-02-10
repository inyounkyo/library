package kr.go.lib.seogu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("seogu")
public class SeoguController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/")
    public String index(){
        return "seogu/index";
    }
}
