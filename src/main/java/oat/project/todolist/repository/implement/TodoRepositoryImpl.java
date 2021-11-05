package oat.project.todolist.repository.implement;

import oat.project.todolist.database.TodoDatabase;
import oat.project.todolist.model.TodoList;
import oat.project.todolist.repository.TodoRepository;
import oat.project.todolist.security.entity.User;
import oat.project.todolist.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class TodoRepositoryImpl implements TodoRepository {
    @Autowired
    TodoDatabase todoDatabase;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<TodoList> getTodoLists() {
        return todoDatabase.findAll();
    }

    @Override
    public TodoList createTodoList(String name,Long createBy) {
        User owner = userRepository.findById(createBy).orElse(null);
        TodoList newTodo = TodoList.builder()
                .todoName(name)
                .created(Timestamp.valueOf(LocalDateTime.now()))
                .lastUpdate(Timestamp.valueOf(LocalDateTime.now()))
                .owedBy(owner)
                .build();
        return todoDatabase.save(newTodo);
    }

    @Override
    public TodoList getTodoListDetails(Long id) {
        return todoDatabase.findById(id).orElse(null);
    }

    @Override
    public TodoList updateTodoList(Long id,TodoList todoList) {
        TodoList temp = todoDatabase.findById(id).orElse(null);
        if(temp != null){
            temp = todoList;
            todoDatabase.save(temp);
            return temp;
        }
        return todoList;
    }

    @Override
    public void deleteTodoList(Long id) {
        TodoList temp = todoDatabase.findById(id).orElse(null);
        todoDatabase.delete(temp);
    }
}
