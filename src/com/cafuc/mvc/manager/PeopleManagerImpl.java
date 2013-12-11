package com.cafuc.mvc.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cafuc.mvc.dao.PeopleDao;
import com.cafuc.mvc.domain.People;
@Component
public class PeopleManagerImpl implements PeopleManager{
	@Autowired
	private PeopleDao peopleDao;

	
	public void savePeople(People people){
		peopleDao.savaPeople(people);
	}

}
