package com.cafuc.mvc.dao;

import org.hibernate.SessionFactory;

import com.cafuc.mvc.domain.People;

public class PeopleDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void savaPeople(People people){
		sessionFactory.getCurrentSession().save(people);
	}
	
}
