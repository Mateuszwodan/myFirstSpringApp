package com.matex.app.database.DAO;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.matex.app.model.User;
@Transactional
public interface UsersDAO extends CrudRepository<User, Long> {

	public User findByName(String username);
}
