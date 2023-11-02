package com.ndiniz.workshopmongo.services;

import com.ndiniz.workshopmongo.domain.User;
import com.ndiniz.workshopmongo.dto.UserDTO;
import com.ndiniz.workshopmongo.repository.UserRepository;
import com.ndiniz.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

   @Autowired
   private UserRepository repo;

   public List<User> findAll() {
      return repo.findAll();
   }

   public User findById(String id) {
      Optional<User> obj = repo.findById(id);
      return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
   }

   public User insert(User obj) {
      return repo.insert(obj);
   }

   public User fromDTO(UserDTO objDTO) {
      return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
   }
}
