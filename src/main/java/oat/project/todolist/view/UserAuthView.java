package oat.project.todolist.view;

import java.util.List;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthView {
    Long id;
    String username;
    List<String> authorities;
}
