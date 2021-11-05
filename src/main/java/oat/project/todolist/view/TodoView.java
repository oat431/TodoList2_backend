package oat.project.todolist.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoView {
    String todoName;
    Date created;
    Date lastUpdate;
    List<TaskView> task;
}
