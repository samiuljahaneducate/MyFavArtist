package com.samiul.artist.domain;

import java.util.List;

public class SimilarArtist {
	private String name;
	private String url;
	private List<Image> image;
	public SimilarArtist() {}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
}
