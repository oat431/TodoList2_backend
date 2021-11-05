package oat.project.todolist.controller;

import oat.project.todolist.model.TodoList;
import oat.project.todolist.service.TodoService;
import oat.project.todolist.util.AppMapper;
import oat.project.todolist.util.form.TodoListForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/*
* todo
* - user able to create todolist
* - user able to retrieve todolist
* - user able to update/edit todolist
* - user able to delete todolist
* */

@Controller
public class TodoController {
    @Autowired
    TodoService todoService;
    // return todolist created
    @PostMapping("todos")
    public ResponseEntity<?> createTodoList(
            @RequestBody TodoListForm todoListForm
    ){
        TodoList output = todoService.createTodoList(todoListForm.getTodoName(),todoListForm.getCreatBy());
        return ResponseEntity.ok("Todo list created");
    }

    // return all task in the todolist
    @GetMapping("todos/{id}")
    public ResponseEntity<?> getTodoListDetails(
            @PathVariable("id") Long id
    ){
        return null;
    }

    // return update successful
    @PutMapping("todos/{id}")
    public ResponseEntity<?> updateTodoList(
            @PathVariable("id") Long id,
            @RequestBody TodoListForm todoListForm
    ){
        return null;
    }

    // return delete successful
    @DeleteMapping("todos{id}")
    public ResponseEntity<?> deleteTodoList(
            @PathVariable("id") Long id
    ){
        todoService.deleteTodoList(id);
        return ResponseEntity.ok("The todolist has been successfully deleted");
    }
}