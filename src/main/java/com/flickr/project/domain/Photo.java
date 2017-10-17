package com.flickr.project.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Photo {
	private String id;
	private String title;
	
	public void setId(String id)
	{
		this.id = id;
	}
	
	public String getId()
	{
		return id;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("[title=");
		sb.append(title);
		sb.append(", id=");
		sb.append(id);
		sb.append("]");
		return sb.toString();
	}
}
