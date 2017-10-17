package com.flickr.project.engine;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flickr.project.domain.FlickrImageSize;
import com.flickr.project.domain.FlickrSearchResponse;
import com.flickr.project.domain.FlickrSizeResponse;
import com.flickr.project.domain.Photo;
import com.flickr.project.facade.rest.IFlickrClient;

@Service
public class CoreEngine implements ICoreEngine{

	@Autowired
	IFlickrClient _client;
	
	@Override
	public List<Photo> searchFlickr(String text) {
		FlickrSearchResponse response = _client.search(text); 
		
		if(response == null || response.getPhotos() == null) 
		{
			return new ArrayList<Photo>();
		}
		
		return response.getPhotos().getPhoto();
	}

	@Override
	public List<FlickrImageSize> getSizeInfo(String id) {
		FlickrSizeResponse response = _client.size(id);
		
		if(response == null || response.getSizes() == null)
		{
			return new ArrayList<FlickrImageSize>();
		}
		
		return response.getSizes().getSize();
	}

}
