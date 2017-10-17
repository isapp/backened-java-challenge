package com.flickr.project.facade.rest;

import com.flickr.project.domain.FlickrSearchResponse;
import com.flickr.project.domain.FlickrSizeResponse;

public interface IFlickrClient {
	/**
	 * 
	 * @param id
	 * @return {@FlickrSizeResponse}
	 */
	public FlickrSizeResponse size(String id);
	
	/**
	 * 
	 * @param search
	 * @return {@FlickrSearchResponse}
	 */
	public FlickrSearchResponse search(String search);
}
