package com.matex.app.database.DAO;

import org.springframework.data.repository.CrudRepository;

import com.matex.app.model.Users;

public interface UsersDAO extends CrudRepository<Users, Long> {

	public Users findByUsers(String username);
}
