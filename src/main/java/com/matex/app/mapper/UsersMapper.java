package com.matex.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.matex.app.model.User;
import com.matex.app.model.DTO.UserDTO;

@Mapper
public interface UsersMapper {
	
	UsersMapper INSTANCE = Mappers.getMapper( UsersMapper.class );
	 
    UserDTO userToUserDto(User user);

    User userDTOToUser(UserDTO userDTO);
}
