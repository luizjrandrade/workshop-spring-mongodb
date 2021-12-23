package com.luizjr.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luizjr.workshopmongo.domain.User;
import com.luizjr.workshopmongo.repository.UserRepository;
import com.luizjr.workshopmongo.service.excpetion.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll(); //retorna lista do banco
	}
	
	public User findById(String id) {
		User user = repo.findById(id).orElse(null);
		if (user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return user;
		//Optional<User> obj = repo.findById(id);
		//return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

}
