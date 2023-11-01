package com.ndiniz.workshopmongo.services;

import com.ndiniz.workshopmongo.domain.User;
import com.ndiniz.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

   @Autowired
   private UserRepository repo;

   public List<User> findAll() {
      return repo.findAll();
   }
}
