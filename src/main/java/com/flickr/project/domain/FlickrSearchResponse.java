package com.flickr.project.domain;

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
