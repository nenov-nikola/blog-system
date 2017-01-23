package com.nikola.dao;

import java.util.List;

import com.nikola.model.ArticleModel;

public interface ArticleDao {

	void addArticle(String name, String body, String author);

	List<ArticleModel> listFiveArticles();

	ArticleModel selectArticleById(int id);

	void updateArticle(String name, String body, String author, int id);

	List<ArticleModel> selectAuthorArticles(String name);

}
