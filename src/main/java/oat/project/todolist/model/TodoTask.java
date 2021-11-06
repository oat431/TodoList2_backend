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
    Boolean status;
    Date created;
    Date updateAt;

    @ManyToOne(cascade = CascadeType.ALL)
    TodoList belongTo;
}
