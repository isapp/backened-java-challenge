package com.flickr.project.engine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flickr.project.domain.FlickrImageSize;
import com.flickr.project.domain.Photo;
import com.flickr.project.facade.rest.IRestfulClient;

@Service
public class CoreEngine implements ICoreEngine{

	@Autowired
	IRestfulClient _client;
	
	@Override
	public List<Photo> searchFlickr(String text) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FlickrImageSize> getSizeInfo(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
