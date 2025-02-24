package com.lab_01.codes.tools;

import java.net.URLEncoder;

public class HTTP_request_handler {
    final String baseUrl = "https://translate.googleapis.com/translate_a/single?client=gtx&sl=%s&tl=%s&dt=t&q=%s";
    
    public String get_request_for_trannslation(String srcLan, String destLang, String text){
        try {
            String encodedText = URLEncoder.encode(text, "UTF-8");
            String fin_q = String.format(baseUrl, srcLan, destLang, encodedText);
            
            System.out.println(fin_q);
            return fin_q;
        } catch (Exception e) {
            e.printStackTrace();
            return "-";
        }
    }
}