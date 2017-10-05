package com.isapp.challenge.service;

public class FlickrConnectionInfo 
{
	private String flickrAPIBaseURL;
	private String flickrAPIKey;
	private String flickrQueryParamMethodSearchImage;
	private String flickrQueryParamMethodSearchImageSize;
	private String flickrQueryParamFormatType;
	private String flickrQueryParamAPIKey;
	private String flickrQueryParamImageQueryKey;
	private String flickrQueryParamSizeQueryKey;

	public FlickrConnectionInfo()
	{
		
		flickrAPIBaseURL="https://www.flickr.com/services/rest/?";
		flickrAPIKey="80aafb8d5879b4ab3d58a6543021cd59";
		flickrQueryParamMethodSearchImage="method=flickr.photos.search";
		flickrQueryParamMethodSearchImageSize="method=flickr.photos.getSizes";
		flickrQueryParamFormatType="&format=json&nojsoncallback=1";
		flickrQueryParamAPIKey="api_key="+flickrAPIKey;
		flickrQueryParamImageQueryKey="&tags=";
		flickrQueryParamSizeQueryKey="photo_id=";
		
	}
	
	public String GetFlickrSearchImageURL(String searchKey)
	{
		return flickrAPIBaseURL+"&"+flickrQueryParamMethodSearchImage+"&"+flickrQueryParamFormatType+"&"+flickrQueryParamAPIKey+"&"+flickrQueryParamImageQueryKey+searchKey;
		
	}
	
	public String GetFlickrImageSizeURL(String photoid)
	{
		return flickrAPIBaseURL+"&"+flickrQueryParamMethodSearchImageSize+"&"+flickrQueryParamFormatType+"&"+flickrQueryParamAPIKey+"&"+flickrQueryParamSizeQueryKey+photoid;
		
	}
	
}
