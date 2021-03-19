package com.app.repo;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.entity.ColorEntity;

@Repository
public class ColorRepoImpl implements ColorRepo {

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<ColorEntity> getColors() {
		return sessionFactory.openSession().createCriteria(ColorEntity.class).list();
	}

}
