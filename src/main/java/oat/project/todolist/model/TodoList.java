package oat.project.todolist.model;

import lombok.*;
import oat.project.todolist.security.entity.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TodoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long todoID;
    String todoName;
    Date created;
    Date lastUpdate; 

    @OneToMany(mappedBy = "belongTo", cascade = CascadeType.ALL)
    List<TodoTask> task;

    @ManyToOne(cascade = CascadeType.ALL)
    User owedBy;
}