package com.flickr.project.facade.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flickr.project.domain.Photo;
import com.flickr.project.domain.QueryResponse;
import com.flickr.project.engine.ICoreEngine;

@RestController
public class QueryController {
	
	@Autowired
	private ICoreEngine _coreEngine;
	
	@RequestMapping(value = "/image", method = RequestMethod.GET, produces = "application/json")
	public List<QueryResponse> queryFlickr(@RequestParam(value="search", defaultValue="BallmerPeak") final String search)
	{
		List<QueryResponse> result = new ArrayList<QueryResponse>();
		
		//use _coreEngine to get results
		System.out.println("querying for " + search);
		
		List<Photo> photoList = _coreEngine.searchFlickr(search);
		System.out.println(photoList);
		return result;
	}
}
