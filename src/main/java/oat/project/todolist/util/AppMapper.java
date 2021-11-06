package oat.project.todolist.util;

import oat.project.todolist.model.TodoList;
import oat.project.todolist.model.TodoTask;
import oat.project.todolist.security.entity.User;
import oat.project.todolist.view.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(imports = Collectors.class)
public interface AppMapper {
    AppMapper INSTANCE = Mappers.getMapper(AppMapper.class);

    UserView getUserView(User user);
    List<UserView> getUserView(List<User> user);

    AdminView getUserByAdmin(User user);
    List<AdminView> getUserByAdmin(List<User> user);

    TodoView getTodoView(TodoList todoList);
    List<TodoView> getTodoView(List<TodoList> todoLists);

    TaskView getTaskView(TodoTask task);
    List<TodoTask> getTaskView(List<TodoTask> tasks);

    @Mapping(target = "authorities", expression = "java(user.getAuthorities().stream().map(auth -> auth.getName().name()).collect(Collectors.toList()))")
    UserAuthView getAuthView(User user);

}
