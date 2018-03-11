package com.nikola.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nikola.model.ArticleModel;

@Repository
@Transactional
public class ArticleDaoImpl implements ArticleDao {

	//@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void addArticle(String name, String body, String author) {
		Session session = em.unwrap(Session.class);
		Transaction t = session.beginTransaction();
		ArticleModel article = new ArticleModel();
		article.setArticle_name(name);
		article.setArticle_body(body);
		article.setArticle_author(author);
		session.saveOrUpdate(article);
		t.commit();
	}

	@Override
	@Transactional
	public List<ArticleModel> listFiveArticles() {
		Session session = em.unwrap(Session.class);
		@SuppressWarnings("unchecked")
		List<ArticleModel> articles = session
				.createSQLQuery(
						"select articleId, articleName, articleBody, articleAuthor from articles order by articleId DESC")
				.addScalar("articleId", IntegerType.INSTANCE).addScalar("articleName", StringType.INSTANCE)
				.addScalar("articleBody", StringType.INSTANCE).addScalar("articleAuthor", StringType.INSTANCE)
				.setResultTransformer(Transformers.aliasToBean(ArticleModel.class)).setMaxResults(5).list();

		return articles;
	}

	@Override
	@Transactional
	public ArticleModel selectArticleById(int id) {
		ArticleModel article = em.find(ArticleModel.class, id);
		return article;
	}

	@Override
	@Transactional
	public void updateArticle(String name, String body, String author, int id) {
		Session session = em.unwrap(Session.class);
		Transaction t = session.beginTransaction();
		ArticleModel article = (ArticleModel) session.get(ArticleModel.class, id);
		article.setArticle_name(name);
		article.setArticle_body(body);
		article.setArticle_author(author);
		article.setArticle_id(id);
		session.update(article);
		t.commit();
	}

	@Override
	@Transactional
	public List<ArticleModel> selectAuthorArticles(String name) {
		Session session = em.unwrap(Session.class);
		@SuppressWarnings("unchecked")
		List<ArticleModel> articles = ((SQLQuery) session
				.createSQLQuery("SELECT articleId, articleName, articleBody, articleAuthor"
						+ " FROM articles where articleAuthor = :name order by articleId DESC")
				.setParameter("name", name)).addScalar("articleId", IntegerType.INSTANCE)
						.addScalar("articleName", StringType.INSTANCE).addScalar("articleBody", StringType.INSTANCE)
						.addScalar("articleAuthor", StringType.INSTANCE)
						.setResultTransformer(Transformers.aliasToBean(ArticleModel.class)).list();
		return articles;
	}

}
