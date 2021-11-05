package oat.project.todolist.model;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TodoTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long taskId;

    String taskName;
    boolean status;
    Date created;
    Date updateAt;

    @ManyToOne
    TodoList belongTo;
}
