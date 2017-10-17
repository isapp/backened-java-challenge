package com.flickr.project.engine;

import java.util.List;

import com.flickr.project.domain.FlickrImageSize;
import com.flickr.project.domain.Photo;

public interface ICoreEngine {
	
	/**
	 * 
	 * @param text to search Flickr for image
	 * @return List of {@Photo}
	 */
	List<Photo> searchFlickr(String text);
	
	/**
	 * 
	 * @param id of photo
	 * @return List of {@FlickrImageSize}
	 */
	List<FlickrImageSize> getSizeInfo(String id);
}
