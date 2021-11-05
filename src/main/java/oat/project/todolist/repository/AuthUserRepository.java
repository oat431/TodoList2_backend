package oat.project.todolist.repository;

import oat.project.todolist.security.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AuthUserRepository {
    Page<User> getUsers(Integer pageSize, Integer page);
    User getUser(Long id);
    User save(User user);
}
