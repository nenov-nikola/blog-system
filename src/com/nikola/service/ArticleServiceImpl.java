package com.nikola.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import com.nikola.dao.ArticleDao;
import com.nikola.exception.ArticleException;
import com.nikola.model.ArticleModel;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDao articleDao;

	@PersistenceContext
	private EntityManager em;

	@Override
	public void addArticle(String name, String body, String author) throws ArticleException {
		if (name.length() > 0 && !body.equals(null) && author.length() > 0) {
			articleDao.addArticle(HtmlUtils.htmlEscape(name), HtmlUtils.htmlEscape(body), HtmlUtils.htmlEscape(author));
		} else {
			throw new ArticleException("This article can not be saved. Invalid data.");
		}

	}

	@Override
	public ArticleModel selectArticleById(int id) throws ArticleException {
		ArticleModel article = em.find(ArticleModel.class, id);
		if (article == null) {
			throw new ArticleException("Article do not exist.");
		} else {
			return articleDao.selectArticleById(id);
		}
	}

	@Override
	public void updateArticle(String name, String body, String author, int id) throws ArticleException {
		ArticleModel article = em.find(ArticleModel.class, id);
		if (article == null) {
			throw new ArticleException("This article do not exists.");
		} else {
			articleDao.updateArticle(HtmlUtils.htmlEscape(name), HtmlUtils.htmlEscape(body),
					HtmlUtils.htmlEscape(author), id);
		}
	}

	@Override
	public List<ArticleModel> selectAuthorArticles(String name) throws ArticleException {
		if (name.equals(null) || name.length() == 0) {
			throw new ArticleException("This author do not exists");
		} else {
			return articleDao.selectAuthorArticles(name);
		}
	}

	@Override
	public List<ArticleModel> listFiveArticles() throws ArticleException {
		return articleDao.listFiveArticles();
	}

}
