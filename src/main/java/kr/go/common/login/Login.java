package kr.go.common.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes
@RequestMapping("login")
public class Login {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/")
    public String index( HttpServletRequest request, Model map ) {

        map.addAttribute("tt","Empddty is 1111111222");
        return "common/login/login";
    }

    @RequestMapping("/loginPro")
    public String login(@RequestParam("id") String id,
                        @RequestParam("password") String password,
                        HttpSession session, HttpServletRequest request,
                        Model map){

        logger.info("id::::"+id);
        logger.info("password:::"+password);
        logger.info("afterUri:::"+session.getAttribute("afterUri"));

        session.setAttribute("id", id);
        session.setAttribute("password", password);

        if(session.getAttribute("afterUri") != null) {
            String afterUri = session.getAttribute("afterUri").toString();
            session.removeAttribute("afterUri");
            return afterUri;
        }else {
            return "home/home";
        }
    }

}
