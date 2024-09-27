package edu.miu.cs.cs425.finalproject.carmanagement;

import edu.miu.cs.cs425.finalproject.carmanagement.model.Role;
import edu.miu.cs.cs425.finalproject.carmanagement.model.User;
import edu.miu.cs.cs425.finalproject.carmanagement.repository.RoleRepository;
import edu.miu.cs.cs425.finalproject.carmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Cs425FinalProjectApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(Cs425FinalProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Role role = new Role();
		role.setName("ROLE_USER");
		roleRepository.save(role);

		List<Role> roles = new ArrayList<>();
		roles.add(role);

		User user = new User(
				"John",
				"Doe",
				"Smith",
				"johnsmith",
				"john@example.com",
				"password123",
				roles
		);

		userRepository.save(user);
	}
}
