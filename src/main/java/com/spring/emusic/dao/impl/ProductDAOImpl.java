package com.spring.emusic.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.emusic.dao.ProductDAO;
import com.spring.emusic.model.Product;

@Repository
@Transactional//transaction class
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.save(product);
		session.flush();
	}

	@Override
	public Product getProductById(String id) {
		Session session = sessionFactory.getCurrentSession();
		Product product = (Product) session.get(Product.class, id);
		session.flush();
		return product;
	}

	@Override
	public List<Product> getAllProducts() {
		Session session = sessionFactory.getCurrentSession();
		Query query  = session.createQuery("from Product");
		@SuppressWarnings("unchecked")
		List<Product> listProduct = query.list();
		session.flush();
		return listProduct;
	}

	@Override
	public void deleteProduct(String id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(getProductById(id));
		session.flush();	
	}

	@Override
	public void editProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
//		session.update(product);
		session.merge(product);
		session.flush();
		
	}
}
