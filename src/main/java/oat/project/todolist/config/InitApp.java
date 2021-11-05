package oat.project.todolist.config;

import lombok.SneakyThrows;
import oat.project.todolist.model.TodoList;
import oat.project.todolist.model.TodoTask;
import oat.project.todolist.database.TaskDatabase;
import oat.project.todolist.database.TodoDatabase;
import oat.project.todolist.security.entity.Authority;
import oat.project.todolist.security.entity.AuthorityName;
import oat.project.todolist.security.entity.User;
import oat.project.todolist.security.repository.AuthorityRepository;
import oat.project.todolist.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    UserRepository userRepository;

    @Autowired
    TodoDatabase todoDatabase;

    @Autowired
    TaskDatabase taskDatabase;

    @Autowired
    AuthorityRepository authorityRepository;

    PasswordEncoder encoder = new BCryptPasswordEncoder();

    @SneakyThrows
    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent){
        addUser();
        addTodoList();
        addTask();
    }

    private User mockUser;
    private void addUser() throws ParseException {
        Authority roleUser = Authority.builder().name(AuthorityName.ROLE_USER).build();
        Authority roleAdmin = Authority.builder().name(AuthorityName.ROLE_ADMIN).build();
        mockUser = User.builder()
                .username("oat431")
                .password("Saha6462")
                .email("oat431@gmail.com")
                .sex("male")
                .firstname("Sahachan")
                .lastname("Tippimwong")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021,01,01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .dateOfBirth(Date.valueOf("2000-11-09"))
                .build();

        authorityRepository.save(roleUser);
        authorityRepository.save(roleAdmin);

        mockUser.getAuthorities().add(roleUser);
        userRepository.save(mockUser);

    }

    private TodoList todo1,todo2,todo3;
    private void addTodoList() throws ParseException {
        todo1 = TodoList.builder()
                .todoName("Doing this project")
                .created(Timestamp.valueOf(LocalDateTime.now()))
                .lastUpdate(Timestamp.valueOf(LocalDateTime.now()))
                .owedBy(mockUser)
                .build();

        todo2 = TodoList.builder()
                .todoName("Working as TA OOP")
                .created(Timestamp.valueOf(LocalDateTime.now()))
                .lastUpdate(Timestamp.valueOf(LocalDateTime.now()))
                .owedBy(mockUser)
                .build();

        todo3 = TodoList.builder()
                .todoName("Working as TA Front-end Dev")
                .created(Timestamp.valueOf(LocalDateTime.now()))
                .lastUpdate(Timestamp.valueOf(LocalDateTime.now()))
                .owedBy(mockUser)
                .build();

        todoDatabase.save(todo1);
        todoDatabase.save(todo2);
        todoDatabase.save(todo3);

    }

    private TodoTask[] tasks = new TodoTask[10];
    private void addTask() throws ParseException {
        String[] doingThisProject = {
                "Created Authentication",
                "Created TodoList CRUD",
                "Created TodoTask CRUD",
        };
        String[] taOOP = {
                "Review class,and object",
                "Review the 4 pillar of OOP",
                "Review the further concept for OOP"
        };
        String[] taFrontend = {
                "Review HTML,CSS,JS",
                "Learn TypeScript",
                "Learn nodeJS",
                "Learn basic UX/UI"
        };
        int index = 0;
        for(String project : doingThisProject){
            tasks[index] = TodoTask.builder()
                    .created(Timestamp.valueOf(LocalDateTime.now()))
                    .updateAt(Timestamp.valueOf(LocalDateTime.now()))
                    .taskName(project)
                    .status(false)
                    .belongTo(todo1)
                    .build();
            index++;
        }

        for(String oop : taOOP){
            tasks[index] = TodoTask.builder()
                    .created(Timestamp.valueOf(LocalDateTime.now()))
                    .updateAt(Timestamp.valueOf(LocalDateTime.now()))
                    .taskName(oop)
                    .status(false)
                    .belongTo(todo1)
                    .build();
            index++;
        }

        for(String frontned : taFrontend){
            tasks[index] = TodoTask.builder()
                    .created(Timestamp.valueOf(LocalDateTime.now()))
                    .updateAt(Timestamp.valueOf(LocalDateTime.now()))
                    .taskName(frontned)
                    .status(false)
                    .belongTo(todo1)
                    .build();
            index++;
        }

        for(int i=0;i<10;i++){
            taskDatabase.save(tasks[i]);
        }
    }
}
