package com.insight.challenge.app.search.domain;

public class UrlInfo {

	private int width;
	private int height;
	private String url;

	public UrlInfo(int height, int width, String url) {
		super();
		this.height = height;
		this.width = width;
		this.url = url;
	}

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

	@Override
	public String toString() {
		return "ClassPojo [height = " + height + ", width = " + width + ", url = " + url + "]";
	}
}