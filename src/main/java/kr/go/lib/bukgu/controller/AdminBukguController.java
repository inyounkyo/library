package kr.go.lib.bukgu.controller;

import kr.go.common.menu.MenuCreatePy;
import kr.go.common.menu.MenuLibCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Controller
@PropertySource("classpath:application.yml")
@RequestMapping("bukgu/admin")
public class AdminBukguController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${spring.pyMenuMain.path}")
    String path;
    @Value("${spring.pyMenuMain.saveDirPath}")
    String saveDirPath;

    @Autowired
    @Qualifier("mcp")
    private MenuCreatePy menuCreatePy;

    @RequestMapping("/index")
    public String index(){
        return "bukgu/admin/index";
    }

    @RequestMapping(value="/menu", method = RequestMethod.GET)
    public String admin( ModelMap model)throws IOException {

        menuCreatePy.sendCallPythonArgs(path, saveDirPath, "bukgu", "LIB001" );

        return "/bukgu/admin/menu";
    }

}