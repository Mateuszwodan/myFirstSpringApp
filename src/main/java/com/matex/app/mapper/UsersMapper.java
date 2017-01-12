package com.matex.app.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.matex.app.model.Users;
import com.matex.app.model.to.UsersTo;
@Component
public class UsersMapper {
	public UsersTo mapModel2To(Users Users) {
		return new UsersTo(Users.getUsername(), Users.getPassword());
	}

	public Users mapTo2Model(UsersTo UsersTo) {
		return new Users(UsersTo.getUsername(), UsersTo.getPassword());
	}
	public List<UsersTo> mapModels2Tos(List<Users> Userss) {
		List<UsersTo> UserssTo = new ArrayList<UsersTo>();
		for (Users Users : Userss) {
			UserssTo.add(new UsersTo(Users.getUsername(), Users.getPassword()));
		}
	    return UserssTo;
	  }

	  public List<Users> mapTos2Models(List<UsersTo> UsersTos) {
		  List<Users> Userss = new ArrayList<Users>();
			for (UsersTo Users : UsersTos) {
				Userss.add(new Users(Users.getUsername(), Users.getPassword()));
			}
		    return Userss;
	  }
}
