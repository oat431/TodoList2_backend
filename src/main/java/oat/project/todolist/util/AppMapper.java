package oat.project.todolist.util;

import oat.project.todolist.security.entity.User;
import oat.project.todolist.view.AdminAuthDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.stream.Collectors;

@Mapper(imports = Collectors.class)
public interface AppMapper {
    AppMapper INSTANCE = Mappers.getMapper(AppMapper.class);

    @Mapping(target = "authorities", expression = "java(admin.getAuthorities().stream().map(auth -> auth.getName().name()).collect(Collectors.toList()))")
    AdminAuthDTO getAdminAuthDTO(User admin);

}
