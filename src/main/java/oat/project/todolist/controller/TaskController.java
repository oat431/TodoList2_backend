package oat.project.todolist.controller;

import oat.project.todolist.model.TodoTask;
import oat.project.todolist.service.TaskService;
import oat.project.todolist.util.AppMapper;
import oat.project.todolist.util.form.TaskForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping("task/{id}")
    public ResponseEntity<?> getTaskDetails(
            @PathVariable("id") Long id
    ){
        TodoTask task = taskService.getTaskDetails(id);
        if(task != null){
            return ResponseEntity.ok(AppMapper.INSTANCE.getTaskView(task));
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"This task does not exits");
        }
    }

    @PostMapping("task")
    public ResponseEntity<?> createTask(
            @RequestBody TaskForm taskForm
    ){
        taskService.createTask(taskForm.getTaskName(),taskForm.getBelongTo());
        return ResponseEntity.ok(" successfully, Create a Task");
    }

    @PutMapping("task/{id}")
    public ResponseEntity<?> updateTask(
            @RequestBody TaskForm taskForm,
            @PathVariable("id") Long id
    ){
        TodoTask task = taskService.getTaskDetails(id);
        if(task != null) {
            task.setTaskName(taskForm.getTaskName());
            taskService.updateTask(id,task);
            return ResponseEntity.ok("successfully, Update a task");
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Task not exits");
        }
    }

    @PutMapping("task/status/{id}")
    public ResponseEntity<?> updateStatus(
            @PathVariable("id") Long id
    ){
        TodoTask task = taskService.getTaskDetails(id);
        if(task != null) {
            taskService.updateTaskStatus(id);
            return ResponseEntity.ok("Status have been update");
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Task not exits");
        }
    }

    @DeleteMapping("task/{id}")
    public ResponseEntity<?> deleteTask(
            @PathVariable("id") Long id
    ){
        TodoTask task = taskService.getTaskDetails(id);
        if(task != null) {
            taskService.deleteTask(id);
            return ResponseEntity.ok("Task has been delete");
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Task not exits");
        }
    }
}
