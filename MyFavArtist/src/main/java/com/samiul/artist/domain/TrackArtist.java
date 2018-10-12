package com.samiul.artist.domain;

import java.util.List;

public class TrackArtist {
	private String name;
	private String mbid;
	private String url;
	
	private List<Image> artistImage;
	
	
	public List<Image> getArtistImage() {
		return artistImage;
	}
	public void setArtistImage(List<Image> artistImage) {
		this.artistImage = artistImage;
	}
	public TrackArtist() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMbid() {
		return mbid;
	}
	public void setMbid(String mbid) {
		this.mbid = mbid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
	
}
