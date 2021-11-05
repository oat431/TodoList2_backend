package oat.project.todolist.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskView {
    String taskName;
    boolean status;
    Date created;
    Date updateAt;
}
