package BackRecipes.controller.interfaces;

import BackRecipes.model.User;

import java.util.List;

public interface UserControllerInterface {
    List<User> getUsers();

    User saveUser(User user);
}
