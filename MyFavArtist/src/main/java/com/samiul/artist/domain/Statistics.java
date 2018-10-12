package com.samiul.artist.domain;

public class Statistics {
	private String listeners;
	private String playcount;
	public Statistics() {		
	}
	public String getListeners() {
		return listeners;
	}
	public void setListeners(String listeners) {
		this.listeners = listeners;
	}
	public String getPlaycount() {
		return playcount;
	}
	public void setPlaycount(String playcount) {
		this.playcount = playcount;
	}
	@Override
	public String toString() {
		return "Statistics [listeners=" + listeners + ", playcount=" + playcount + "]";
	}
	
	
	
}
