package com.apiUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flickr.FlickrTile;
import com.flickr.Url;

public class FlickrAPI {
	
	RestTemplate restTemplate = new RestTemplate();
	
	//constants
	private static final int MAX_LENGTH  = 10;
	private static final String base_url = "https://api.flickr.com/services/rest/";
	private static final String api_key  = "80aafb8d5879b4ab3d58a6543021cd59";
	
	//enums for methods
	public enum ApiMethods {
		
		SEARCH("flickr.photos.search"),
		SIZE("flickr.photos.getSizes");

	    private String method;

	    ApiMethods(String method) {
	        this.method = method;
	    }
	}
	
	/*
	 * 1st arg: base_url
	 * 2nd arg: method
	 * 3rd arg: api_key
	 * 4th arg: args (rest of arguments for API call)
	 */
	private static final String format = "%s?method=%s&api_key=%s&format=json&nojsoncallback=1%s";
	
	
	/**
	 * Retrieves an images sizes and urls
	 * @param photoId
	 * @return
	 * @throws JsonProcessingException
	 * @throws IOException
	 */
	public List<Url> fetchImageSize(String photoId) throws JsonProcessingException, IOException {
		
		ResponseEntity<String> response = fetchJsonFromSizeAPI(photoId);
		JsonNode root = convertJsonToNodes(response);
		JsonNode sizes = root.path("sizes").path("size");
				
		return createUrlList(sizes);
	}
	
	
	/**
	 * Retrieves a list of names based on the search criteria
	 * @return
	 * @throws JsonProcessingException
	 * @throws IOException
	 */
	public List<FlickrTile> fetchImageTitleAndIds(String query) throws JsonProcessingException, IOException {
		
		ResponseEntity<String> response = fetchJsonFromSearchAPI(query);
		JsonNode root = convertJsonToNodes(response);
		JsonNode photos = root.path("photos").path("photo");
										
		return createTileList(photos);
	}
	
	
	/*================HELPER FUNCTIONS====================*/
	
	
	private ResponseEntity<String> fetchJsonFromSizeAPI(String photoId) {
		
		String url = String.format(format, base_url, ApiMethods.SIZE.method, api_key, "&photo_id=" + photoId);	
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		
		return response;
	}
	
	
	private ResponseEntity<String> fetchJsonFromSearchAPI(String query) {
		
		String url = String.format(format, base_url, ApiMethods.SEARCH.method, api_key, "&text=" + query);	
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
				
		return response;
	}
	
	
	private JsonNode convertJsonToNodes(ResponseEntity<String> response) throws JsonProcessingException, IOException {	
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(response.getBody());
		
		return root;
	}
	
	
	private List<FlickrTile> createTileList(JsonNode photos) {
		
		List<FlickrTile> dataList = new ArrayList<FlickrTile>();
		
		for(int i = 0; i < photos.size() && i < MAX_LENGTH; i++) {
			FlickrTile tile = new FlickrTile(photos.get(i));
			dataList.add(tile);
		}
		
		return dataList;
	}
	
	
	private List<Url> createUrlList(JsonNode sizes) {
		
		List<Url> urls = new ArrayList<Url>();
		
		for(JsonNode size : sizes) {
			urls.add(new Url(size));
		}
		
		return urls;
	}


}
