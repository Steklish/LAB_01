package com.lab_01.codes.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lab_01.codes.tools.HTTP_request_handler;

@Service
public class Resolve_queue_service {
    
    HTTP_request_handler client = new HTTP_request_handler();

    public List<String> get_translate(String srcLan, String destLang, String text) {
        try {
            
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.getForEntity(client.get_request_for_trannslation(srcLan, destLang, text), String.class);
            String json = response.getBody();
            return List.of(json);
        }
        catch (Exception e){
            return List.of("error", e.toString());
        }
        
    }
}
