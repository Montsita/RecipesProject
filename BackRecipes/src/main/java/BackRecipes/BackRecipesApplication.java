package BackRecipes;

import BackRecipes.enums.Vegetarian;
import BackRecipes.model.Recipe;
import BackRecipes.model.User;
import BackRecipes.service.impl.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BackRecipesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackRecipesApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

}
