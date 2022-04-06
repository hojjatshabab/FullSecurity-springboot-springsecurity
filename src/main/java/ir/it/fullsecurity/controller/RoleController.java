package ir.it.fullsecurity.controller;

import ir.it.fullsecurity.model.Role;
import ir.it.fullsecurity.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("role")
public class RoleController {

    private final RoleService roleService;

    @GetMapping("roles")
    public ResponseEntity<List<Role>> getRoles(){
        return new ResponseEntity<>(roleService.getRoles(), HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        HttpHeaders header = new HttpHeaders();
        header.add("desc","Save role to database.");
        return ResponseEntity.status(HttpStatus.OK).headers(header).body(roleService.saveRole(role));
    }
}
