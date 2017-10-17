package com.flickr.project.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @since 1.0
 * @author raysmets
 * Class to map to Flickr's search method response.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlickrSearchResponse {
	private String stat;
	private Photos photos;
	
	public Photos getPhotos() {
		return photos;
	}
	public void setPhotos(Photos photos) {
		this.photos = photos;
	}
	public String getStat() {
		return stat;
	}
	public void setStat(String stat) {
		this.stat = stat;
	}
	
	@Override
	public String toString()
	{
		return photos.toString();
	}
}
