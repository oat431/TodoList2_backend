package oat.project.todolist.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserView {
    Long id;
    String firstname;
    String lastname;
    String email;
    List<TodoView> todoLists;
}
