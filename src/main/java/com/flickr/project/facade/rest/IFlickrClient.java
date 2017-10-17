package com.flickr.project.facade.rest;

import com.flickr.project.domain.FlickrSearchResponse;
import com.flickr.project.domain.FlickrSizeResponse;

public interface IFlickrClient {
	public FlickrSizeResponse size(String id);
	public FlickrSearchResponse search(String search);
}
