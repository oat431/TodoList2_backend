package oat.project.todolist.security.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import oat.project.todolist.security.entity.Authority;
import oat.project.todolist.security.entity.AuthorityName;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findByName(AuthorityName input);
}
