package oat.project.todolist.database;

import oat.project.todolist.model.TodoTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskDatabase extends JpaRepository<TodoTask,Long> {
}
