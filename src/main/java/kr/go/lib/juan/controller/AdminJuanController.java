package kr.go.lib.juan.controller;

import kr.go.common.menu.MenuCreatePy;
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

import java.io.IOException;

@Controller
@PropertySource("classpath:application.yml")
@RequestMapping("juan/admin")
public class AdminJuanController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${spring.pyMenuMain.path}")
    String path;
    @Value("${spring.pyMenuMain.saveDirPath}")
    String saveDirPath;
    @Value("${spring.pyMenuMain.pythonV}")
    String pythonV;

    @Autowired
    @Qualifier("mcp")
    private MenuCreatePy menuCreatePy;

    @RequestMapping("/index")
    public String index(){
        return "juan/admin/index";
    }

    @RequestMapping(value="/menu", method = RequestMethod.GET)
    public String admin( ModelMap model)throws IOException {

        menuCreatePy.sendCallPythonArgs(pythonV, path, saveDirPath, "juan", "LIB004" );

        return "/juan/admin/menu";
    }

}