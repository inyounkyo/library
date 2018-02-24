package kr.go.lib.bukgu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @RequestMapping("/index")
    public String index(){
        return "bukgu/admin/index";
    }

    @RequestMapping(value="/menu", method = RequestMethod.GET)
    public String admin( ModelMap model)throws IOException {
        // set up the command and parameter
        String pythonScriptPath = path+"HTML_NAV.py";
        String[] cmd = new String[4];
        cmd[0] = "python"; // check version of installed python: python -V
        cmd[1] = pythonScriptPath;
        cmd[2] = "abcd";
        cmd[3] = "kkk";

        // create runtime to execute external command
        Runtime rt = Runtime.getRuntime();
        Process pr = rt.exec(cmd);

        // retrieve output from python script
        BufferedReader bfr = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        String line = "";
        while((line = bfr.readLine()) != null) {
            // display each output line form python script
            System.out.println(line);
        }
        return "/bukgu/admin/menu";
    }

}