package com.lab_01.codes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lab_01.codes.service.ResolveQueryService;

@RestController
public class RESTController {
    @Autowired
    private ResolveQueryService translator;

    @GetMapping("/getTranslation")
    public List<String> getTranslationResponse(@RequestParam String srcL, 
            @RequestParam String targetL, @RequestParam String text) {
        return translator.getTranslation(srcL, targetL, text);
    }

}
