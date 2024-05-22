package com.pieceperdu.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.pieceperdu.backend.security.entities.AppRole;
import com.pieceperdu.backend.security.entities.AppUser;
import com.pieceperdu.backend.services.AccountService;

@EnableMethodSecurity(prePostEnabled = true)
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = "com.pieceperdu.backend")
public class BackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	@Bean
	CommandLineRunner start(AccountService accountService) {
		return args -> {
			accountService.addnewRole(new AppRole(null, "ADMIN"));
			accountService.addNewUser(new AppUser(null, "admin", "1234", null));
			accountService.addRoleToUser("admin", "ADMIN");

			accountService.addnewRole(new AppRole(null, "USER"));
			accountService.addNewUser(new AppUser(null, "user", "1234", null));
			accountService.addRoleToUser("user", "USER");
		};
	}
}
