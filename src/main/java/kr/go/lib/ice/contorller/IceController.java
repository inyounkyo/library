package kr.go.lib.ice.contorller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ice")
public class IceController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/")
    public String index(){
        return "ice/index";
    }
}
