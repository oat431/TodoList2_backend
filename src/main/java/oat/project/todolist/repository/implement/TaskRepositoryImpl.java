package oat.project.todolist.repository.implement;

import oat.project.todolist.database.TaskDatabase;
import oat.project.todolist.database.TodoDatabase;
import oat.project.todolist.model.TodoList;
import oat.project.todolist.model.TodoTask;
import oat.project.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class TaskRepositoryImpl implements TaskRepository {
    @Autowired
    TodoDatabase todoDatabase;

    @Autowired
    TaskDatabase taskDatabase;

    @Override
    public List<TodoTask> getTasks() {
        return taskDatabase.findAll();
    }

    @Override
    public TodoTask createTask(String name, Long belongTo) {
        TodoList origin = todoDatabase.findById(belongTo).orElse(null);
        TodoTask temp = TodoTask.builder()
                .taskName(name)
                .status(false)
                .created(Timestamp.valueOf(LocalDateTime.now()))
                .updateAt(Timestamp.valueOf(LocalDateTime.now()))
                .belongTo(origin)
                .build();
        taskDatabase.save(temp);
        return temp;
    }

    @Override
    public TodoTask getTaskDetails(Long id) {
        return taskDatabase.findById(id).orElse(null);
    }

    @Override
    public TodoTask updateTask(Long id, TodoTask task) {
        task.setUpdateAt(Timestamp.valueOf(LocalDateTime.now()));
        taskDatabase.save(task);
        return task;
    }

    @Override
    public TodoTask updateTaskStatus(Long id) {
        TodoTask temp = taskDatabase.findById(id).orElse(null);
        if(temp != null){
            boolean trigger = temp.getStatus();
            temp.setStatus(!trigger);
            taskDatabase.save(temp);
        }
        return temp;
    }

    @Override
    public void deleteTask(Long id) {
        TodoTask temp = taskDatabase.findById(id).orElse(null);
        taskDatabase.delete(temp);
    }
}
