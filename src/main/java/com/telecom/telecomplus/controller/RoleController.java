package com.telecom.telecomplus.controller;

import com.telecom.telecomplus.model.Role;
import com.telecom.telecomplus.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/role/getAllRoles")
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }

    @GetMapping("/role/getRoleById/{id}")
    public Optional<Role> getRoleById(@PathVariable Long id){
        return roleService.getRoleById(id);
    }

    @PutMapping("/role/updateRole/{id}")
    public Role updateRole(@RequestBody Role updatedRole, @PathVariable  Long id){
        return roleService.updateRole(id, updatedRole);
    }

    @PostMapping("/role/createRole")
    public Role createRole(@RequestBody Role newRole){
        return roleService.createRole(newRole);
    }

    @DeleteMapping("/role/deleteRole/{id}")
    public String deleteRole(@PathVariable Long id){
        return roleService.deleteRoleById(id);
    }
}
