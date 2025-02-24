package com.lab_01.codes.make_request;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Requester {

    @Autowired
    private Name_handler countryService;

    @GetMapping("/get_code")
    public List<String> getCode(@RequestParam String name) {
        return countryService.getCode(name);
    }

    @GetMapping("/get_name")
    public List<String> getName(@RequestParam String code) {
        return countryService.getName(code);
    }
}
