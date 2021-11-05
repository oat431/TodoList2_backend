package oat.project.todolist.util.form;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoListForm {
    String todoName;
    Long creatBy;
}
