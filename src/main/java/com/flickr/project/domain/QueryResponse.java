package com.flickr.project.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @since 1.0
 * @author raysmets
 * Class holding relevant query result information. 
 */
public class QueryResponse {
	private String title;
	private List<FlickrUrl> urls;
	
	public QueryResponse(String title)
	{
		this.title = title;
		urls = new ArrayList<FlickrUrl>();
	}
	
	public void setTitle(String t)
	{
		title = t;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setUrls(List<FlickrUrl> list)
	{
		urls = list;
	}
	
	public List<FlickrUrl> getUrls()
	{
		return urls;
	}
	
	public void addFlickrUrl(String url, int width, int height)
	{
		FlickrUrl furl = new FlickrUrl(url, height, width);
		urls.add(furl);
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("QueryResponse[title=");
		sb.append(title);
		sb.append(", urls");
		sb.append(urls);
		sb.append("]");
		
		return sb.toString();
	}
}
