package oat.project.todolist.controller;

import oat.project.todolist.security.entity.User;
import oat.project.todolist.service.UserService;
import oat.project.todolist.util.AppMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

/* *
* todo
* - admin part : get all user
* - user part : only see their own profile data
*/

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("users")
    public ResponseEntity<?> getUsers(
            @RequestParam(value = "_limit",required = false) Integer perPage,
            @RequestParam(value = "_page", required = false) Integer page
    ){
        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<User> output = userService.getUsers(perPage,page);
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count",String.valueOf(output.getTotalElements()));
        return new ResponseEntity<>(AppMapper.INSTANCE.getUserByAdmin(output.getContent()),responseHeader, HttpStatus.OK);
    }

    @GetMapping("users/{id}")
    public ResponseEntity<?> getUser(
            @PathVariable("id") Long id
    ){
        User output = userService.getUser(id);
        if(output != null){
            return ResponseEntity.ok(AppMapper.INSTANCE.getUserView(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
        }
    }
}
