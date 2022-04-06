package ir.it.fullsecurity.service;

import ir.it.fullsecurity.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    void addRoleToUser(String userName , String name);
    User getUser(String userName);
    List<User> getUsers();
}
