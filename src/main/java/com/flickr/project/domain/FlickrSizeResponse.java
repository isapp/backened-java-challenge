package com.flickr.project.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @since 1.0
 * @author raysmets
 * Class to map to Flickr's size method response.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlickrSizeResponse {
	
	private FlickrSizesResponse sizes;
	private String stat;
	
	public FlickrSizesResponse getSizes() {
		return sizes;
	}
	public void setSizes(FlickrSizesResponse sizes) {
		this.sizes = sizes;
	}
	public String getStat() {
		return stat;
	}
	public void setStat(String stat) {
		this.stat = stat;
	}
	
	public String toString()
	{
		return sizes.toString();
	}
}
