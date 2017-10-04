package com.flickr;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FlickrTile {
	
	private String id;
    private String title;
    private List<Url> urls;
    
	public FlickrTile(String title, List<Url> urls) {
		this.title = title;
		this.urls  = urls;
	}
	
	public FlickrTile(JsonNode node) {
		this.id    = node.get("id").asText();
		this.title = node.get("title").asText();
	}

	public String getTitle() {
		return title;
	}
	
	public List<Url> getUrls() {
		return urls;
	}
	
    @JsonIgnore
	public String getId() {
		return id;
	}

	public void setUrls(List<Url> urls) {
		this.urls = urls;
	}

	@Override
	public String toString() {
		return "FlickrTile [id=" + id + ", title=" + title + ", urls=" + urls + "]";
	}

}
