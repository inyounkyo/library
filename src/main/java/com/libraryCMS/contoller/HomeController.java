package com.libraryCMS.contoller;

import com.libraryCMS.mapper.TestMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TestMapper testMapper;

    @RequestMapping("/aaaa")
    public String home(){
        logger.info(testMapper.getValueFromDatabase());
        return "home/home";
    }
}
