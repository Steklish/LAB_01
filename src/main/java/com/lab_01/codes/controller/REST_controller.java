package com.lab_01.codes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lab_01.codes.service.Resolve_queue_service;

@RestController
public class REST_controller {
    @Autowired
    private Resolve_queue_service translator;

    @GetMapping("/getTranslation")
    public List<String> getTranslation(@RequestParam String srcL, @RequestParam String targetL, @RequestParam String text) {
        return translator.get_translate(srcL, targetL, text);
    }

}
