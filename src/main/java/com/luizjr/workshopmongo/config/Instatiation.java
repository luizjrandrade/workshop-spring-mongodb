package com.luizjr.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.luizjr.workshopmongo.domain.User;
import com.luizjr.workshopmongo.repository.UserRepository;

@Configuration
public class Instatiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User luiz = new User(null, "Luiz Junior", "luizjr@email.com");
		User lara = new User(null, "Lara Fernanda", "doce@email.com");
		User filipe = new User(null, "Filipe Gabriel", "pingo@email.com");
		User marly = new User(null, "Marly Siqueira", "cherin@email.com");
		
		userRepository.saveAll(Arrays.asList(luiz, lara, filipe, marly));
		
	}

}
