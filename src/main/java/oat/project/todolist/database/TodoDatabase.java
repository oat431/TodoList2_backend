package oat.project.todolist.database;

import oat.project.todolist.model.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoDatabase extends JpaRepository<TodoList,Long> {
}
