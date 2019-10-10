package test.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import test.entity.User;


public interface UserDao extends JpaRepository<User, Long> {
	public User findByUid(Long uid);
	public User findByUsername(String username);
	public User findByUsernameAndPassword(String username, String password);
	
}
