package oat.project.todolist.service;

import oat.project.todolist.model.TodoList;

import java.util.List;

public interface TodoService {
    List<TodoList> getTodoLists();
    TodoList createTodoList(String name,Long createBy);
    TodoList getTodoListDetails(Long id);
    TodoList updateTodoList(Long id,TodoList todoList);
    void deleteTodoList(Long id);
}
