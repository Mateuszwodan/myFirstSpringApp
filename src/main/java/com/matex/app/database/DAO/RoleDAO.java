package com.matex.app.database.DAO;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.matex.app.model.Role;
@Transactional
public interface RoleDAO extends CrudRepository<Role, Long>{

	public Role findByName(String email);
}
