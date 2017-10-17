package com.flickr.project.facade.rest;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flickr.project.domain.FlickrImageSize;
import com.flickr.project.domain.Photo;

@Service
public class RestfulClient implements IRestfulClient{

	@Override
	public List<FlickrImageSize> size(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Photo> search(String search) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
