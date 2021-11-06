package oat.project.todolist.service;

import oat.project.todolist.model.TodoTask;

import java.util.List;

public interface TaskService {
    List<TodoTask> getTasks();
    TodoTask createTask(String name, Long belongTo);
    TodoTask getTaskDetails(Long id);
    TodoTask updateTask(Long id,TodoTask task);
    TodoTask updateTaskStatus(Long id);
    void deleteTask(Long id);
}
