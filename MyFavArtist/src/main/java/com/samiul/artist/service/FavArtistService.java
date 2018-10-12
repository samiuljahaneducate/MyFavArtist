package com.samiul.artist.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samiul.artist.domain.Artist;
import com.samiul.artist.domain.Biography;
import com.samiul.artist.domain.Image;
import com.samiul.artist.domain.Rank;
import com.samiul.artist.domain.SimilarArtist;
import com.samiul.artist.domain.Statistics;
import com.samiul.artist.domain.Streamable;
import com.samiul.artist.domain.Track;
import com.samiul.artist.domain.TrackArtist;
import com.samiul.artist.domain.Tracks;


@Service
public class FavArtistService {@Autowired
	private RestTemplate restTemplate;

	@Value("${lastfm.artist.getinfo}")
	private String ARTIST_GETINFO;
	
	@Value("${lastfm.geo.gettoptracks}")
	private String GEO_GET_TOP_TRACKS;
	
	
	@Value("${lastfm.api.key}")
	private String API_KEY;
	
	private String url = null;
	
	
	public ResponseEntity<?> getArtistInfo(String artistName){
	    
	    url = ARTIST_GETINFO + "&artist=" + artistName + "&api_key=" + API_KEY + "&format=json";
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
		String responseJson = responseEntity.getBody();		
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = null;
		try {
			rootNode = objectMapper.readTree(responseJson);

		} catch (IOException e) {
			e.printStackTrace();
		}
		Artist artist = new Artist();
		if (rootNode != null) {
			JsonNode artistJson = rootNode.path("artist");
			artist.setName(artistJson.path("name").asText());
			
			artist.setMbid(artistJson.path("mbid").asText());
			artist.setUrl(artistJson.path("url").asText());
			artist.setUrl(artistJson.path("url").asText());
			
			// get and set images
			if (artistJson.path("image").isArray()) {
				List<Image> images = new ArrayList<>();
				JsonNode imageNode = artistJson.path("image");
				for (JsonNode imgNode : imageNode) {
					Image img = new Image();					
					img.setSize(imgNode.path("size").asText());
					img.setText(imgNode.path("#text").asText());					
					images.add(img);
				}
				if (images != null) {
					artist.setImage(images);
				}
			}
			// end of get and set images
			
			artist.setStreamable(artistJson.path("streamable").asInt());
			artist.setOntour(artistJson.path("ontour").asInt());
			
			// set stats
			Statistics stats = new Statistics();
			JsonNode statsNode = artistJson.path("stats");
			stats.setListeners(statsNode.path("listeners").asText());
			stats.setPlaycount(statsNode.path("playcount").asText());
			artist.setStats(stats);
			
			//set Bio 
			Biography bio = new Biography();
			JsonNode bioNode = artistJson.path("bio");
			bio.setContent(bioNode.path("content").asText());
			bio.setSummary(bioNode.path("summary").asText());
			artist.setBio(bio);
					
			/*// set similar
			
			SimilarArtist simArt = new SimilarArtist();
			JsonNode simArtNode = artistJson.path("bio");
			
			
			
			// set similar
*/			
			
			// 
			//System.out.println("Artist info is " + artist);
			//Iterator<JsonNode> elementsIterator = artistJson.elements();
			/*
			if (elementsIterator.hasNext()) {
				JsonNode element = elementsIterator.next();
				System.out.println("tree");
			}*/

		}	 
		return new ResponseEntity<Artist>(artist, HttpStatus.OK);
	}

	public ResponseEntity<?> getTopTracks(String countryName) {
		url = GEO_GET_TOP_TRACKS + "&limit=1&country=" + countryName + "&api_key=" + API_KEY + "&format=json";
		
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
		String responseJson = responseEntity.getBody();		
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = null;
		try {
			rootNode = objectMapper.readTree(responseJson);

		} catch (IOException e) {
			e.printStackTrace();
		}
		Tracks tracks = new Tracks();
		List<Track> allTracks = new ArrayList<>();
		if (rootNode != null) {
			JsonNode trackJson = rootNode.path("tracks");
			JsonNode allTrackJson = trackJson.path("track");
			for (JsonNode objNode : allTrackJson) {
				Track track = new Track();
				track.setName(objNode.path("name").asText());
				track.setDuration(objNode.path("duration").asInt());
				track.setListeners(objNode.path("listeners").asText());
				track.setMbid(objNode.path("mbid").asText());
				track.setUrl(objNode.path("url").asText());
				
				// set streamable
				
				Streamable streamable = new Streamable();
				JsonNode sreamableNode = objNode.path("streamable");
				streamable.setFulltrack(sreamableNode.path("fulltrack").asText());
				streamable.setText((sreamableNode.path("#text").asText()));
				track.setStreamable(streamable);
				
				//set artist
				
				TrackArtist artist = new TrackArtist();
				JsonNode artistNode = objNode.path("artist");
				artist.setMbid(artistNode.path("mbid").asText());
				artist.setName(artistNode.path("name").asText());
				artist.setUrl(artistNode.path("url").asText());
				
				track.setArtist(artist);				
				
				String urlArtist = ARTIST_GETINFO + "&artist=" + artist.getName() + "&api_key=" + API_KEY + "&format=json";
				ResponseEntity<String> artistResponseEntity = restTemplate.getForEntity(urlArtist, String.class);
				String responseArtistJson = artistResponseEntity.getBody();	
				ObjectMapper objectMapper2 = new ObjectMapper();
				JsonNode artistRootNode = null;
				try {
					artistRootNode = objectMapper.readTree(responseArtistJson);

				} catch (IOException e) {
					e.printStackTrace();
				}
				
				if (artistRootNode != null) {
					JsonNode artistJson = artistRootNode.path("artist");	
					// get and set images
					if (artistJson.path("image").isArray()) {
						List<Image> images = new ArrayList<>();
						JsonNode imageNode = artistJson.path("image");
						for (JsonNode imgNode : imageNode) {
							Image img = new Image();					
							img.setSize(imgNode.path("size").asText());
							img.setText(imgNode.path("#text").asText());					
							images.add(img);
						}
						if (images != null) {
							artist.setArtistImage(images);
						}
					}
					// end of get and set images
				}
				
				// set image
				// get and set images
				if (objNode.path("image").isArray()) {
					List<Image> images = new ArrayList<>();
					JsonNode imageNode = objNode.path("image");
					for (JsonNode imgNode : imageNode) {
						Image img = new Image();					
						img.setSize(imgNode.path("size").asText());
						img.setText(imgNode.path("#text").asText());					
						images.add(img);
					}
					if (images != null) {
						track.setImage(images);
					}
				}
				// end of get and set images
				
				// get and set rank
				Rank rank = new Rank();
				JsonNode attrNode = objNode.path("@attr");
				rank.setRank(attrNode.path("rank").asText());				
				track.setAttr(rank);
				allTracks.add(track);
			}
			tracks.setTracks(allTracks);
		}
		return new ResponseEntity<Tracks>(tracks, HttpStatus.OK);
	}
}
