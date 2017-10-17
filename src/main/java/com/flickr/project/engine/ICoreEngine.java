package com.flickr.project.engine;

import java.util.List;

import com.flickr.project.domain.FlickrImageSize;
import com.flickr.project.domain.Photo;

public interface ICoreEngine {
	
	List<Photo> searchFlickr(String text);
	
	List<FlickrImageSize> getSizeInfo(String id);
}
