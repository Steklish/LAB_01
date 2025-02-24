package com.lab_01.codes.make_request;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Name_handler {
    public List<String> getCode(String name) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://restcountries.com/v3.1/name/" + name;
// 
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        String json = response.getBody();
        JSONObject data = new JSONObject(json.substring(1, json.length() - 1)); // Remove array brackets
        String phoneCode = data.getJSONObject("idd").getString("root");

        return List.of("Queried name=" + name, "code=" + phoneCode);
        
    }

    public List<String> getName(String code) {
        code = "+" + code;
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://restcountries.com/v3.1/all"; // Fetch all countries to find the matching code
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        String json = response.getBody();
        JSONArray countriesArray = new JSONArray(json);

        for (int i = 0; i < countriesArray.length(); i++) {
            JSONObject country = countriesArray.getJSONObject(i);
            if (country.has("idd")) {
                JSONObject idd = country.getJSONObject("idd");
                if (idd.has("root") && idd.getString("root").equals(code)) {
                    JSONObject nameObject = country.getJSONObject("name");
                    String countryName = nameObject.getString("common");
                    return List.of("Queried code=" + code, "name=" + countryName);
                }
            }
        }

        return List.of("Queried code=" + code, "name not found");

    }
}
