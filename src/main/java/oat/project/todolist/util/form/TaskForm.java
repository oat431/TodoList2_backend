package oat.project.todolist.util.form;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskForm {
    String taskName;
    Long belongTo;
}
