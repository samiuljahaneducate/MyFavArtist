package com.samiul.artist.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Image {
	@JsonProperty("#text")	
	private String text;
	private String size;
	
	public Image() {}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "Image [text=" + text + ", size=" + size + "]";
	}
	
	
	
}
