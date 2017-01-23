package com.nikola.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "articles")
public class ArticleModel {

	@Id
	@GeneratedValue
	private int articleId;

	@Column
	private String articleName;

	@Column
	@Type(type = "text")
	private String articleBody;

	@Column
	private String articleAuthor;

	public int getArticle_id() {
		return articleId;
	}

	public void setArticle_id(int article_id) {
		this.articleId = article_id;
	}

	public String getArticle_name() {
		return articleName;
	}

	public void setArticle_name(String article_name) {
		this.articleName = article_name;
	}

	public String getArticle_body() {
		return articleBody;
	}

	public void setArticle_body(String article_body) {
		this.articleBody = article_body;
	}

	public String getArticle_author() {
		return articleAuthor;
	}

	public void setArticle_author(String article_author) {
		this.articleAuthor = article_author;
	}

}
