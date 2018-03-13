package com.insight.challenge.app.search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.photos.PhotoList;
import com.flickr4java.flickr.photos.PhotosInterface;
import com.flickr4java.flickr.photos.SearchParameters;
import com.flickr4java.flickr.photos.Size;
import com.insight.challenge.app.search.domain.Image;
import com.insight.challenge.app.search.domain.UrlInfo;

@RestController
@RequestMapping("/")
public class SearchController {

	@Autowired
	private Environment env;

	private String flickrApiKey;

	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);

	@GetMapping(path = "images")
	public Collection<Image> search(@RequestParam("query") String text)
			throws IOException, SAXException, FlickrException {
		logger.info("Search Request received with filter String: " + text);

		List<Image> imageList = new ArrayList<>();

		if (flickrApiKey == null) {
			flickrApiKey = env.getProperty("flickr_api_key");
		}

		Flickr flickr = new Flickr(flickrApiKey, "", new REST());

		SearchParameters searchParams = new SearchParameters();
		searchParams.setText(text);
		searchParams.setSort(6);
		searchParams.setAccuracy(1);

		PhotosInterface photosInterface = flickr.getPhotosInterface();
		PhotoList<Photo> photoList = photosInterface.search(searchParams, 10, 1);// Limit result - size:10, page:1

		for (Photo photo : photoList) {
			Image img = new Image(photo.getTitle());
			imageList.add(img);

			Collection<Size> sizes = photosInterface.getSizes(photo.getId());
			for (Size size : sizes) {
				img.addUrl(new UrlInfo(size.getHeight(), size.getWidth(), size.getSource()));
			}
		}

		return imageList;
	}
}
