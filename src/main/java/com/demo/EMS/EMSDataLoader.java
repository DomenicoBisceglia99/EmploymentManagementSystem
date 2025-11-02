package com.demo.EMS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.demo.EMS.entity.User;
import com.demo.EMS.repository.UserRepository;


@Component
public class EMSDataLoader implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		List<User> usersDB = this.userRepository.findAll();
//		
//		for(User user : usersDB) {
//			user.setPassword(passwordEncoder.encode("1234"));
//			userRepository.save(user);
//		}
		 
	} 
	

}
