package com.nikola.service;

import java.util.List;

import com.nikola.exception.ArticleException;
import com.nikola.model.ArticleModel;

public interface ArticleService {

	void addArticle(String name, String body, String author) throws ArticleException;

	ArticleModel selectArticleById(int id) throws ArticleException;

	List<ArticleModel> listFiveArticles() throws ArticleException;

	void updateArticle(String name, String body, String author, int id) throws ArticleException;

	List<ArticleModel> selectAuthorArticles(String name) throws ArticleException;
}
