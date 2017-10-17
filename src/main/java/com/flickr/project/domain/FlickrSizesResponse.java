package com.flickr.project.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FlickrSizesResponse {
	
	private List<FlickrImageSize> size;
	private int canblog;
	private int canprint;
	private int candownload;
	
	public List<FlickrImageSize> getSize() {
		return size;
	}

	public void setSize(List<FlickrImageSize> sizes) {
		this.size = sizes;
	}
	
	public String toString()
	{
		return size.toString();
	}

	public int getCanblog() {
		return canblog;
	}

	public void setCanblog(int canblog) {
		this.canblog = canblog;
	}

	public int getCanprint() {
		return canprint;
	}

	public void setCanprint(int canprint) {
		this.canprint = canprint;
	}

	public int getCandownload() {
		return candownload;
	}

	public void setCandownload(int candownload) {
		this.candownload = candownload;
	}
}
