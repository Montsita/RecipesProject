package BackRecipes.service.interfaces;



import BackRecipes.model.Role;
import BackRecipes.model.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface {

    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    User getUser(String name);

    List<User> getUsers();
}

