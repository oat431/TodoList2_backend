package oat.project.todolist.service.implement;

import oat.project.todolist.model.TodoTask;
import oat.project.todolist.repository.TaskRepository;
import oat.project.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskRepository taskRepository;

    @Override
    public List<TodoTask> getTasks() {
        return taskRepository.getTasks();
    }

    @Override
    public TodoTask createTask(String name, Long belongTo) {
        return taskRepository.createTask(name,belongTo);
    }

    @Override
    public TodoTask getTaskDetails(Long id) {
        return taskRepository.getTaskDetails(id);
    }

    @Override
    public TodoTask updateTask(Long id, TodoTask task) {
        return taskRepository.updateTask(id,task);
    }

    @Override
    public TodoTask updateTaskStatus(Long id) {
        return taskRepository.updateTaskStatus(id);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteTask(id);
    }
}
