package ir.it.fullsecurity;

import ir.it.fullsecurity.model.Role;
import ir.it.fullsecurity.model.User;
import ir.it.fullsecurity.service.RoleService;
import ir.it.fullsecurity.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class FullSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(FullSecurityApplication.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner runner(UserService userService, RoleService roleService){
		return args ->{
			roleService.saveRole(new Role(null,"ROLE_USER"));
			roleService.saveRole(new Role(null,"ROLE_MANAGER"));
			roleService.saveRole(new Role(null,"ROLE_ADMIN"));
			roleService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null,"hojat","hojatsba","123",new ArrayList<>()));
			userService.saveUser(new User(null,"yaser","yasersba","123",new ArrayList<>()));
			userService.saveUser(new User(null,"reza","rezasba","123",new ArrayList<>()));
			userService.saveUser(new User(null,"hamed","hamedsba","123",new ArrayList<>()));
			userService.saveUser(new User(null,"samad","samadsba","123",new ArrayList<>()));
			userService.saveUser(new User(null,"amin","aminsba","123",new ArrayList<>()));

			userService.addRoleToUser("hojatsba","ROLE_SUPER_ADMIN");
			userService.addRoleToUser("yasersba","ROLE_ADMIN");
			userService.addRoleToUser("yasersba","ROLE_MANAGER");
			userService.addRoleToUser("rezasba","ROLE_USER");
			userService.addRoleToUser("hamedsba","ROLE_MANAGER");
			userService.addRoleToUser("samadsba","ROLE_MANAGER");
			userService.addRoleToUser("aminsba","ROLE_MANAGER");
			userService.addRoleToUser("aminsba","ROLE_ADMIN");
			userService.addRoleToUser("aminsba","ROLE_USER");

		};
	}

}
