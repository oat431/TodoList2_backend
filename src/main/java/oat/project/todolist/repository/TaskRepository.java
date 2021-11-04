package oat.project.todolist.repository;

import oat.project.todolist.model.TodoTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TodoTask,Long> {
}
