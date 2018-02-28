package kr.go.common.menu;

import org.springframework.stereotype.Service;

import java.io.IOException;

public interface MenuCreatePy {
    public void sendCallPythonArgs(String pythonV, String path, String saveDirPath, String libLoc, String libCd) throws IOException;
}
