package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyTestController {

    private final RestTemplate restTemplate;

    @Autowired
    public MyTestController(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping(value = "/hello")
    public String rrt() {
        try {
            final String sss = restTemplate.getForObject("http://localhost:8080/hello2", String.class);
            System.out.println(sss);
        } catch (Exception e) {
            return "TimeOut";
        }

        //Thread.sleep(6000);
        return "Hello, World !!!";
    }

}
