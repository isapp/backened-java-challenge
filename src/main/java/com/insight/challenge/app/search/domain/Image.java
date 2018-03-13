package com.insight.challenge.app.search.domain;

import java.util.ArrayList;
import java.util.List;

public class Image {
	private String title;

	private List<UrlInfo> urls = new ArrayList<>();

	public Image(String title) {
		super();
		this.title = title;
	}

	public void addUrl(UrlInfo url) {
		this.urls.add(url);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<UrlInfo> getUrls() {
		return urls;
	}

	public void setUrls(List<UrlInfo> urls) {
		this.urls = urls;
	}

	@Override
	public String toString() {
		return "ClassPojo [title = " + title + ", urls = " + urls + "]";
	}
}
