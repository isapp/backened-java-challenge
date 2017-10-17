package com.flickr.project.facade.rest;

import java.util.List;

import com.flickr.project.domain.FlickrImageSize;
import com.flickr.project.domain.Photo;

public interface IRestfulClient {
	public List<FlickrImageSize> size(String id);
	public List<Photo> search(String search);
}
