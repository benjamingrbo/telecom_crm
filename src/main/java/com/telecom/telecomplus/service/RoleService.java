package com.telecom.telecomplus.service;

import com.telecom.telecomplus.model.Role;
import com.telecom.telecomplus.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Optional<Role> getRoleById(Long roleId) {
        return roleRepository.findById(roleId);
    }

    public Role updateRole(Long roleId, Role updatedRole) {
        return roleRepository.findById(roleId)
                .map(role -> {

                    if (updatedRole.getRoleName() != null) {
                        role.setRoleName(updatedRole.getRoleName());
                    }

                    return roleRepository.save(role);
                })
                .orElse(null);
    }

    public Role createRole(Role newRole) {
        return roleRepository.save(newRole);
    }


    public String deleteRoleById(Long roleId) {
        roleRepository.deleteById(roleId);
        return "Role with id: " + roleId + " has been deleted.";
    }

}
