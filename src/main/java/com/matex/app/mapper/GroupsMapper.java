package com.matex.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.matex.app.model.Groups;
import com.matex.app.model.DTO.GroupsDTO;

@Mapper
public interface GroupsMapper {
	GroupsMapper INSTANCE = Mappers.getMapper( GroupsMapper.class );
	 
	GroupsDTO groupsToGroupsDto(Groups group);
	Groups groupsDTOToGroups(GroupsDTO group);

}
