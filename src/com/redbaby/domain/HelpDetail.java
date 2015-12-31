package com.redbaby.domain;

/**
 * 帮助内容
 *
 */
public class HelpDetail {
	
	
	private String title;

	/** 帮助内容 */
	private String content;

	public HelpDetail() {
	}

	public HelpDetail(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
