package com.matex.app.database.DAO;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.matex.app.model.Privilege;
@Transactional
public interface PrivilegeDAO extends CrudRepository<Privilege, Long>{
	
	public Privilege findByName(String email);

}
