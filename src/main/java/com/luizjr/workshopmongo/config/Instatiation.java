package com.luizjr.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.luizjr.workshopmongo.domain.Post;
import com.luizjr.workshopmongo.domain.User;
import com.luizjr.workshopmongo.dto.AuthorDTO;
import com.luizjr.workshopmongo.repository.UserRepository;
import com.luizjr.workshopmongo.repository.PostRepository;

@Configuration
public class Instatiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User luiz = new User(null, "Luiz Junior", "luizjr@email.com");
		User lara = new User(null, "Lara Fernanda", "doce@email.com");
		User filipe = new User(null, "Filipe Gabriel", "pingo@email.com");
		User marly = new User(null, "Marly Siqueira", "cherin@email.com");
		
		userRepository.saveAll(Arrays.asList(luiz, lara, filipe, marly));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para Palmas. Té Logo!", new AuthorDTO(marly));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(marly));
		
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		marly.getPosts().addAll(Arrays.asList(post1,post2));
		userRepository.save(marly);
	}

}
