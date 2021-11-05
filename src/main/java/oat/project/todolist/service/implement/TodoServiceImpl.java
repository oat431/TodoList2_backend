package oat.project.todolist.service.implement;

import oat.project.todolist.model.TodoList;
import oat.project.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oat.project.todolist.service.TodoService;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    TodoRepository todoRepository;

    @Override
    public List<TodoList> getTodoLists() {
        return todoRepository.getTodoLists();
    }

    @Override
    public TodoList createTodoList(String name,Long createBy) {
        return todoRepository.createTodoList(name,createBy);
    }

    @Override
    public TodoList getTodoListDetails(Long id) {
        return todoRepository.getTodoListDetails(id);
    }

    @Override
    public TodoList updateTodoList(Long id,TodoList todoList) {
        return todoRepository.updateTodoList(id,todoList);
    }

    @Override
    public void deleteTodoList(Long id) {
        todoRepository.deleteTodoList(id);
    }
}
