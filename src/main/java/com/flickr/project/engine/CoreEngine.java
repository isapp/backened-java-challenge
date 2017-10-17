package com.flickr.project.engine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flickr.project.domain.FlickrImageSize;
import com.flickr.project.domain.FlickrSearchResponse;
import com.flickr.project.domain.Photo;
import com.flickr.project.facade.rest.IRestfulClient;

@Service
public class CoreEngine implements ICoreEngine{

	@Autowired
	IRestfulClient _client;
	
	@Override
	public List<Photo> searchFlickr(String text) {
		FlickrSearchResponse response = _client.search(text); 
		
		return response.getPhotos().getPhoto();
	}

	@Override
	public List<FlickrImageSize> getSizeInfo(String id) {
		return _client.size(id);
	}

}
