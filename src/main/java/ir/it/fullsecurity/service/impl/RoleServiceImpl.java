package ir.it.fullsecurity.service.impl;

import ir.it.fullsecurity.model.Role;
import ir.it.fullsecurity.repository.RoleRepository;
import ir.it.fullsecurity.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role saveRole(Role role) {
        log.info("Save new role {} in to database.", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public Role getRole(String name) {
        log.info("Finding role {} .",name);
        return roleRepository.findByName(name);
    }

    @Override
    public List<Role> getRoles() {
        log.info("Finding all roles.");
        return roleRepository.findAll();
    }
}
