package ir.it.fullsecurity.service.impl;

import ir.it.fullsecurity.model.Role;
import ir.it.fullsecurity.model.User;
import ir.it.fullsecurity.repository.RoleRepository;
import ir.it.fullsecurity.repository.UserRepository;
import ir.it.fullsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public User saveUser(User user) {
        log.info("Save new user {} in to database.", user.getName());
        return userRepository.save(user);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        log.info("Adding role {} to user {} .", roleName, userName);
        User user = userRepository.findByUserName(userName);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String userName) {
        log.info("Finding user {} .", userName);
        return userRepository.findByUserName(userName);
    }

    @Override
    public List<User> getUsers() {
        log.info("Finding all users.");
        return userRepository.findAll();
    }
}
