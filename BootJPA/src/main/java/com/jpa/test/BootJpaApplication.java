package com.jpa.test;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entities.User;

@SpringBootApplication
public class BootJpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BootJpaApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);
//		User user = new User();
//		user.setName("Tanu Soni");
//		user.setStatus("Java Developer");
//		user.setCity("Delhi");
//		User user1 = userRepository.save(user);
//		System.out.println(user1);

//		// Create Object of User
//		User user = new User();
//		user.setName("Updesh");
//		user.setStatus("Unity Developer");
//		user.setCity("Aligarh");
//
//		// Saving Single User
////		User user1 = userRepository.save(user);
////		System.out.println(user1);
//
//		User user2 = new User();
//		user2.setName("Vanshika");
//		user2.setStatus("Python Developer");
//		user2.setCity("Delhi");
////		User user3 = userRepository.save(user2);
////		System.out.println(user3);
//
//		// Saving More than a single User
//		List<User> users = List.of(user, user2);
//		Iterable<User> allUser = userRepository.saveAll(users);
//		allUser.forEach(usr -> {
//			System.out.println(usr);
//		});

		// Update User

//		Optional<User> optional = userRepository.findById(52);
//		User user = optional.get();
//		user.setName("Jay Ojha");
//		User finaluser = userRepository.save(user);
//		System.out.println(finaluser);

		// How to get data

		// findById(id) - return optional containing your data
//		Optional<User> optional = userRepository.findById(52);

//		Iterable<User> allUser = userRepository.findAll();
//		allUser.forEach(user ->{
//			System.out.println(user);
//		});

		// Delete the object
//		
//		userRepository.deleteById(52);
//		System.out.println("deleted");

		// Spring JPA
//		List<User> list = userRepository.findByName("Neeru");
//		list.forEach(user ->{
//			System.out.println(user);
//		});
//		
//		List<User> temp = userRepository.findByNameAndCity("Tanu Soni","Delhi");
//		temp.forEach(user ->{
//			System.out.println(user);
//		});

		// Query Annotation
//		List<User> users = userRepository.getAllUser();		
//		users.forEach(user ->{
//			System.out.println(user);
//		});
//		
//		List<User> user1 = userRepository.getUserByName("Banti");		
//		user1.forEach(user ->{
//			System.out.println(user);
//		});

		List<User> users = userRepository.getUsers();
		users.forEach(user -> {
			System.out.println(user);
		});

	}

}
