package com.libraryCMS.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SampleRestContoller {

    @GetMapping("/asd/")
    public String hello(){
        return "index";
    }
}
