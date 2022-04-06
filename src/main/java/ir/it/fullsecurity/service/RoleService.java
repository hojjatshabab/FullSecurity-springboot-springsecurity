package ir.it.fullsecurity.service;

import ir.it.fullsecurity.model.Role;

import java.util.List;

public interface RoleService {
    Role saveRole(Role role);
    Role getRole(String name);
    List<Role> getRoles();
}
