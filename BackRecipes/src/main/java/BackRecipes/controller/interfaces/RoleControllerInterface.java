package BackRecipes.controller.interfaces;

import BackRecipes.dtos.RoleToUserDTO;
import BackRecipes.model.Role;

public interface RoleControllerInterface {

    void saveRole(Role role);

    void addRoleToUser(RoleToUserDTO roleToUserDTO);
}
