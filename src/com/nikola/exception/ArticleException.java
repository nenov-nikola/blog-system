package com.nikola.exception;

public class ArticleException extends Exception {

	private static final long serialVersionUID = 1L;

	public ArticleException(String message) {
		super(message);
	}

	public ArticleException(String message, Exception e) {
		super(message, e);
	}
}
