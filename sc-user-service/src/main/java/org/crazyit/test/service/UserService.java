package org.crazyit.test.service;

import java.util.List;

import org.crazyit.test.dao.UserDao;
import org.crazyit.test.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;

	public User findByNameAndPassowrd(String name, String password) {
		// 查询符合条件的用户
		List<User> users = userDao.findByNameAndPassword(name, password);
		return users.size() == 1 ? users.get(0) : new User();
	}
}
