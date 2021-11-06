package oat.project.todolist.service.implement;

import oat.project.todolist.repository.AuthUserRepository;
import oat.project.todolist.security.entity.User;
import oat.project.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    AuthUserRepository authUserRepository;

    @Override
    public Page<User> getUsers(Integer pageSize, Integer page) {
        return authUserRepository.getUsers(pageSize,page);
    }

    @Override
    public User getUser(Long id) {
        return authUserRepository.getUser(id);
    }

    @Override
    public User save(User user) {
        return authUserRepository.save(user);
    }
}
