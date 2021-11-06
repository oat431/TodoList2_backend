package oat.project.todolist.repository;

import oat.project.todolist.model.TodoList;

import java.util.List;

public interface TodoRepository {
    List<TodoList> getTodoLists();
    TodoList createTodoList(String name,Long createBy);
    TodoList getTodoListDetails(Long id);
    TodoList updateTodoList(Long id,TodoList todoList);
    void deleteTodoList(Long id);
}
