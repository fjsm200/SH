package com.cafuc.mvc.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cafuc.mvc.domain.People;
@Component
public class PeopleDaoImpl implements PeopleDao{
	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public void savaPeople(People people) {
		sessionFactory.getCurrentSession().save(people);
	}

}
