package org.crazyit.test.dao;

import java.util.List;

import org.crazyit.test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {

	/**
	 * 根据名称和密码查询用户
	 * @return
	 */
	List<User> findByNameAndPassword(String name, String password);
}
