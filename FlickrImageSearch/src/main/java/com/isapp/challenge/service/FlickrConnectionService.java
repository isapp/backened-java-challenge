package com.isapp.challenge.service;

import org.json.JSONArray;
import org.json.JSONObject;

import com.isapp.challenge.core.RestHttpsClient;

public class FlickrConnectionService 
{
	public FlickrConnectionInfo connectionInfo;
	public RestHttpsClient flickerClient;
	public JSONArray flickrImageSearchResponse;
	
	public FlickrConnectionService()
	{
		connectionInfo=new FlickrConnectionInfo();
		flickerClient=new RestHttpsClient();
		flickrImageSearchResponse=new JSONArray();
	}
	
	public JSONArray GenerateFlickrData(String searchKeyword, int limit)
	{
		
		//Get the images based on search query parameter.
		JSONObject imageSearchResults=flickerClient.RestGetJson(connectionInfo.GetFlickrSearchImageURL(searchKeyword));

		if(imageSearchResults.has("photos"))
		{
		
		JSONObject imageSearchResult= imageSearchResults.getJSONObject("photos");
		
		if(imageSearchResult.has("photo"))
		{
		//Get all photo ids and titles from the response string.
		JSONArray listOfImages=imageSearchResult.getJSONArray("photo");
		
		//Honor the limit specified as argument. If for some reason flickr api doesnt return the limit number of enities then default the limit as returned by flickr api.
		if(listOfImages.length()<limit)
		{
			limit=listOfImages.length();
		}
		
		for (int i = 0 ; i < limit;i++) 
		{
			JSONObject getItem = listOfImages.getJSONObject(i);
			JSONObject item=new JSONObject();
			if(getItem.has("title"))
			{
			item.put("title", getItem.get("title").toString());
			}
			
			if(getItem.has("id"))
			{
			//Get the Photo Id from the response.
			String photoid=getItem.get("id").toString();
			
			//Now Get the Photo Size Details using Flickr Size API.
			JSONObject sizeSearchResult=flickerClient.RestGetJson(connectionInfo.GetFlickrImageSizeURL(photoid)).getJSONObject("sizes");
			
			item.append("size", sizeSearchResult.get("size"));
			}
			flickrImageSearchResponse.put(i, item);	
		}
		
		}
		
		}
		
		
		return flickrImageSearchResponse;
	} 
}
