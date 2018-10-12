package com.samiul.artist.domain;

public class Biography {
	private String summary;
	private String content;
	public Biography() { }
	@Override
	public String toString() {
		return "Biography [summary=" + summary + ", content=" + content + "]";
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
}
