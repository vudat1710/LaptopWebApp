package com.group14.project.web.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.group14.project.web.beans.User;

@Repository
@Transactional
@Component("userDao")
public class UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void saveUser(User user) {
		getSession().save(user);
	}
	
	public boolean isUsernameExisted(String username) {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));
		criteria.setProjection(Projections.rowCount());
		return (Integer.parseInt(criteria.uniqueResult().toString())) == 1;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> searchUserByUserIdUsernameName(String userId, String username, String name){
		Criteria criteria = getSession().createCriteria(User.class);
		if(!userId.equals("")) {
			criteria.add(Restrictions.idEq(Integer.parseInt(userId)));
		}
		if(!username.equals("")) {
			criteria.add(Restrictions.ilike("username", username + "%"));
		}
		if(!name.equals("")) {
			criteria.add(Restrictions.ilike("name", name + "%"));
		}
		return criteria.list();
	}

	public User getUserByUserId(String userId) {
		Criteria criteria = getSession().createCriteria(User.class);
		if (!userId.isEmpty()) {
			criteria.add(Restrictions.idEq(Integer.parseInt(userId)));
		}
		return (User) criteria.uniqueResult();
	}

	public User getUserByUserId(int userId) {
		Criteria criteria = getSession().createCriteria(User.class);
		
		criteria.add(Restrictions.idEq(userId));
		
		return (User) criteria.uniqueResult();
	}
	
	public void updateUser(User user) {
		getSession().update(user);
	}

	public User getUserByUsername(String username) {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));
		return (User) criteria.uniqueResult();
	}

}
