package com.demo.EMS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.EMS.entity.User;
import com.demo.EMS.repository.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public void deleteUserById(Long idUser) {
		this.userRepository.deleteById(idUser);
	}
	
	public void updateUserById(Long idUser, User nuovoUser) {
		User userDB = this.userRepository.findById(idUser) 
				.orElseThrow(() -> new RuntimeException("User non trovato con id " + idUser));
		userDB.setUsername(nuovoUser.getUsername());
		userDB.setPassword(nuovoUser.getPassword());
		this.userRepository.save(userDB);
	}
	
	public void insertUser(User nuovoUser) {
		this.userRepository.save(nuovoUser);
	}
	
	public void addUser(String username, String password) {
		User user = new User();; 
		user.setUsername(username);
		user.setPassword(passwordEncoder.encode(password)); // qui viene criptata
		userRepository.save(user);
	}
	
}
