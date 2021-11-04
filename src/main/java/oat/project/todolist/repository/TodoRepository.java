package oat.project.todolist.repository;

import oat.project.todolist.model.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoList,Long> {
}
