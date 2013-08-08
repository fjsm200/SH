package com.cafuc.mvc.manager;

import com.cafuc.mvc.dao.PeopleDao;
import com.cafuc.mvc.domain.People;

public class PeopleManagerImpl {
	private PeopleDao peopleDao;

	public void setPeopleDao(PeopleDao peopleDao) {
		this.peopleDao = peopleDao;
	}
	
	public void savePeople(People people){
		peopleDao.savaPeople(people);
	}

}
