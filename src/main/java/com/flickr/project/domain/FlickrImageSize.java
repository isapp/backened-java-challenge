package com.flickr.project.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FlickrImageSize {
	private int width;
	private int height;
	private String url;
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Image[width= ");
		sb.append(width);
		sb.append(", height= ");
		sb.append(height);
		sb.append(", url=");
		sb.append(url);
		sb.append("]");
		
		return sb.toString();
	}

}
