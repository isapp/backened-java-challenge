package com.flickr;

import com.fasterxml.jackson.databind.JsonNode;

public class Url {
	
	private int width;
	private int height;
	private String url;
	
	public Url(int width, int height, String url) {
		this.width  = width;
		this.height = height;
		this.url    = url;
	}
	
	public Url(JsonNode node) {
		this.width  = node.get("width").asInt();
		this.height = node.get("height").asInt();
		this.url    = node.get("url").asText();
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public String getUrl() {
		return url;
	}

	@Override
	public String toString() {
		return "Url [url=" + url + ", width=" + width + ", height=" + height + "]";
	}
	
}
