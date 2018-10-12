package com.samiul.artist.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Track {
	private String name;
	private Integer duration;
	private String listeners;
	private String mbid;
	private String url;
	private List<Image> image;
	
	private Streamable Streamable;
	
	public Streamable getStreamable() {
		return Streamable;
	}

	public void setStreamable(Streamable streamable) {
		Streamable = streamable;
	}

	@JsonProperty("@attr")
	private Rank attr;
	
	private TrackArtist artist;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getListeners() {
		return listeners;
	}

	public void setListeners(String listeners) {
		this.listeners = listeners;
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

	public List<Image> getImage() {
		return image;
	}

	public void setImage(List<Image> image) {
		this.image = image;
	}

	



	public Rank getAttr() {
		return attr;
	}

	public void setAttr(Rank attr) {
		this.attr = attr;
	}

	public TrackArtist getArtist() {
		return artist;
	}

	public void setArtist(TrackArtist artist) {
		this.artist = artist;
	}

	public Track() {
		
	}
	
	

}
