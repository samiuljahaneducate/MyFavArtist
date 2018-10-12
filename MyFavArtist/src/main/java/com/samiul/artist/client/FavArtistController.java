package com.samiul.artist.client;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.samiul.artist.service.FavArtistService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping("/api")
@Api(value="Artist", description="Artist info", tags="artist")
public class FavArtistController {
	
	@Autowired
	private FavArtistService favArtistService;
   
	@RequestMapping(value = "/get/{artistName}", method = RequestMethod.GET)
    @ApiOperation(value="Get Artist Info", notes= "Gets info of an artist", nickname="getArtistInfo")

	public ResponseEntity<?>  getArtistInfo( @PathVariable(name = "artistName", required = true) final String artistName){		
	    return favArtistService.getArtistInfo(artistName);
	}
	
	@ApiOperation(value="Get Top Tracks", notes= "Gets top tracks in a geo location", nickname="getTopTracks")
	@RequestMapping(value = "/getTopTracks/{countryName}", method = RequestMethod.GET)
	public ResponseEntity<?>  getTopTracks( @PathVariable(name = "countryName", required = true) final String countryName){		
	    return favArtistService.getTopTracks(countryName);
	}
	
	
}
