package com.isapp.challenge.FlickrImageSearch;

import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isapp.challenge.service.FlickrConnectionService;

@RestController
@EnableAutoConfiguration
public class FlickrSearch {

    @RequestMapping("/images")
    List<Object> search(@RequestParam(value="query", defaultValue=" ") String searchPattern) 
    {
    	FlickrConnectionService serviceInstance=new FlickrConnectionService();    	
    	return serviceInstance.GenerateFlickrData(searchPattern, 10).toList();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(FlickrSearch.class, args);
    }
}
