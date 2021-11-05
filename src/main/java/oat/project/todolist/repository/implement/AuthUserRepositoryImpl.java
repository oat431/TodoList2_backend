package oat.project.todolist.repository.implement;

import oat.project.todolist.repository.AuthUserRepository;
import oat.project.todolist.security.entity.User;
import oat.project.todolist.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthUserRepositoryImpl implements AuthUserRepository {
    @Autowired
    UserRepository userRepository;

    @Override
    public Page<User> getUsers(Integer pageSize, Integer page) {
        return userRepository.findAll(PageRequest.of(page-1,pageSize));
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
