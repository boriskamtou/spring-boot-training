package com.java.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/*
* Les annotations controller et @ResponseBody peuvent être remplacé par
* @RestController
* */

@RestController
public class HelloController {

    private final Map<String, Object> result = new HashMap<>(); // Crée des données au format json

    @RequestMapping("/hello")
    public Map<String, Object> hello() {
        result.put("name", "Stephen");
        result.put("city", "San Jose");
        return result;
    }
}
