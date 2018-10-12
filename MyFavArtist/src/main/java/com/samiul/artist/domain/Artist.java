package com.samiul.artist.domain;

import java.util.List;




public class Artist {
	private String name;
	
	private String mbid;
	private String url;	
	List<Image> image;
	private Integer streamable;
	private Integer ontour;	
	private Statistics stats;
	/*private Tags tags;
	List<SimilarArtist> similar;*/
	private Biography bio;
	public Artist() {}
	
	
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

	public Integer getStreamable() {
		return streamable;
	}

	public void setStreamable(Integer streamable) {
		this.streamable = streamable;
	}

	public Integer getOntour() {
		return ontour;
	}

	public void setOntour(Integer ontour) {
		this.ontour = ontour;
	}

	public Statistics getStats() {
		return stats;
	}

	public void setStats(Statistics stats) {
		this.stats = stats;
	}

	public Biography getBio() {
		return bio;
	}

	public void setBio(Biography bio) {
		this.bio = bio;
	}

	public String getMbid() {
		return mbid;
	}

	public void setMbid(String mbid) {
		this.mbid = mbid;
	}

	public List<Image> getImage() {
		return image;
	}

	public void setImage(List<Image> image) {
		this.image = image;
	}


	@Override
	public String toString() {
		return "Artist [name=" + name + ", mbid=" + mbid + ", url=" + url + ", image=" + image + ", streamable="
				+ streamable + ", ontour=" + ontour + ", stats=" + stats + ", bio=" + bio + "]";
	}

	
}
