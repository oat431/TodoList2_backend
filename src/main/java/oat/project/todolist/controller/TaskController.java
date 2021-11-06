package oat.project.todolist.controller;

import oat.project.todolist.util.form.TaskForm;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {
    @GetMapping("task/{id}")
    public ResponseEntity<?> getTaskDetails(
            @PathVariable("id") Long id
    ){
        return null;
    }

    @PostMapping("task")
    public ResponseEntity<?> createTask(
            @RequestBody TaskForm taskForm
    ){
        return null;
    }

    @PutMapping("task/{id}")
    public ResponseEntity<?> updateTask(
            @RequestBody TaskForm taskForm,
            @PathVariable("id") Long id
    ){
        return null;
    }

    @PutMapping("task/status/{id}")
    public ResponseEntity<?> updateStatus(
            @PathVariable("id") Long id
    ){
        return null;
    }

    @DeleteMapping("task/{id}")
    public ResponseEntity<?> deleteTask(
            @PathVariable("id") Long id
    ){
        return null;
    }
}
