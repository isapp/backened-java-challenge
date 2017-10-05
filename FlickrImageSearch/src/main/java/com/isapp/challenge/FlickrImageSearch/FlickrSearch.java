package com.isapp.challenge.FlickrImageSearch;

import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class FlickrSearch {

    @RequestMapping("/flickr")
    String search(@RequestParam(value="search", defaultValue=" ") String searchPattern) 
    {
    	
    	return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(FlickrSearch.class, args);
    }
}
