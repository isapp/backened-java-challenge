package com.flickr.project.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FlickrUrl {
	
	private int width, height;
	private String url;
	
	public FlickrUrl(String url, int h, int w)
	{
		setUrl(url);
		setWidth(w);
		setHeight(h);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("FlickUrl[width=");
		sb.append(width);
		sb.append(", height=");
		sb.append(height);
		sb.append(", url=");
		sb.append(url);
		
		return sb.toString();
	}
}

