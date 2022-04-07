package ir.it.fullsecurity.controller;

import ir.it.fullsecurity.model.User;
import ir.it.fullsecurity.model.dto.RoleToUserForm;
import ir.it.fullsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @GetMapping("users")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("save")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        // URI = name and Location (URL + URN)
        // URL = Location
        // URN = name
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/save").toUriString());
        //ResponseEntity.ok برای درخواست 200 می باشد
        //ResponseEntity.created  برای درخواست 201 میباشد
        //تفاوت با درخواست 200 این است که یک درخواست با جزئیات میسازیم و درخواست دقیق بر میگردانیم
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }
    @PostMapping("add/roletouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form){
        userService.addRoleToUser(form.getUserName(), form.getRoleName());
        return ResponseEntity.ok().build();
    }
}
