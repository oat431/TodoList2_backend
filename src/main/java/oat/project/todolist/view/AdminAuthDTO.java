package oat.project.todolist.view;

import java.util.List;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminAuthDTO {
    Long id;
    String username;
    List<String> authorities;
}
