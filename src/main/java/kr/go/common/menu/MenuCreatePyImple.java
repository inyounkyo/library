package kr.go.common.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component(value="mcp")
public class MenuCreatePyImple implements MenuCreatePy {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void sendCallPythonArgs(String pythonV, String path, String saveDirPath, String libLoc, String libCd) throws IOException{
        // set up the command and parameter
        String pythonScriptPath = path+"HTML_NAV.py";
        String[] cmd = new String[5];
        cmd[0] = pythonV; // check version of installed python: python -V
        cmd[1] = pythonScriptPath;
        cmd[2] = libLoc;  //LIB_LOC
        cmd[3] = libCd;   //LIB_CD
        cmd[4] = saveDirPath; //saveing menu(HTML FILE) to physical path

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
    }

}
