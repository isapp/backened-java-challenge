package com.flickr.project.facade.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.flickr.project.domain.FlickrImageSize;
import com.flickr.project.domain.FlickrSearchResponse;
import com.flickr.project.domain.FlickrSizeResponse;
import com.flickr.project.domain.Photo;

@Service
public class RestfulClient implements IRestfulClient{
	private RestTemplate _restTemplate;
	
	public RestfulClient()
	{
		_restTemplate = new RestTemplate();
	}
	
	@Value("${flickr.api.key}")
	private String _apiKey;
	
	private String _baseUrl = "https://api.flickr.com/services/rest/?method="; 
	private String _searchMethod = "flickr.photos.search";
	private String _sizeMethod = "flickr.photos.size";
	
	@Override
	public FlickrSizeResponse size(String id) {
		String url = "https://api.flickr.com/services/rest/?method=flickr.photos.getSizes&api_key=14fbe823601c3249f936eb3ca46fcc51&photo_id=" + id + "&format=json&nojsoncallback=1";
		FlickrSizeResponse response = _restTemplate.getForObject(url, FlickrSizeResponse.class);
		
		System.out.println(response);
		
		return response;
	}

	@Override
	public FlickrSearchResponse search(String search) {
		//String uri = _baseUrl + _searchMethod + "&" + "api_key=" + _apiKey + "&text=" + search + "&format=json&nojsoncallback=1"; 
		String url = "https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=aa3a1a809aaf0a2cceab2e7caaa83873&text=" + search + "&per_page=10&format=json&nojsoncallback=1";
		
		FlickrSearchResponse response = _restTemplate.getForObject(url, FlickrSearchResponse.class);
		
		return response;
	}
	
}
