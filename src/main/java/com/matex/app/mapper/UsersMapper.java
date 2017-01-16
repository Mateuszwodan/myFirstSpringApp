package com.matex.app.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.matex.app.model.User;
import com.matex.app.model.to.UsersTo;
@Component
public class UsersMapper {
	public UsersTo mapModel2To(User Users) {
		return new UsersTo(Users.getUsername(), Users.getPassword(), Users.getEnabled());
	}

	public User mapTo2Model(UsersTo UsersTo) {
		return new User(UsersTo.getUsername(), UsersTo.getPassword(), UsersTo.getEnabled());
	}
	public List<UsersTo> mapModels2Tos(List<User> Userss) {
		List<UsersTo> UserssTo = new ArrayList<UsersTo>();
		for (User Users : Userss) {
			UserssTo.add(new UsersTo(Users.getUsername(), Users.getPassword(), Users.getEnabled()));
		}
	    return UserssTo;
	  }

	  public List<User> mapTos2Models(List<UsersTo> UsersTos) {
		  List<User> Userss = new ArrayList<User>();
			for (UsersTo Users : UsersTos) {
				Userss.add(new User(Users.getUsername(), Users.getPassword(), Users.getEnabled()));
			}
		    return Userss;
	  }
}
