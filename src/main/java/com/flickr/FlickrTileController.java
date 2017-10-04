package com.flickr;

import java.io.IOException;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.apiUtils.FlickrAPI;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class FlickrTileController {
	
	private FlickrAPI api = new FlickrAPI();
	
	@RequestMapping("/images")
    public List<FlickrTile> images(@RequestParam(value="query") String query) {
		
		List<FlickrTile> flickrTiles = null;
		
		try {
			flickrTiles = retrieveTilesFromFlickrApi(query);
		}catch(Exception e) {
			handleErrors(e);
		}
		
        return flickrTiles;
    }
	
    
    private List<FlickrTile> retrieveTilesFromFlickrApi(String query) throws JsonProcessingException, IOException {
    	
    	List<FlickrTile> flickrTiles = api.fetchImageTitleAndIds(query);
		    		
		for(FlickrTile tile : flickrTiles) { 
			tile.setUrls(api.fetchImageSize(tile.getId()));    			
		}
  	
    	return flickrTiles;
    	
    }
    
    
    //handle errors here
    private void handleErrors(Exception e) {
    	
    	if(e instanceof IOException) {
    		
    	}else if(e instanceof JsonProcessingException) {
    		
    	}
    }
	
}
