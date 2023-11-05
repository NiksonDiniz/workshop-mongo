package com.ndiniz.workshopmongo.services;

import com.ndiniz.workshopmongo.domain.Post;
import com.ndiniz.workshopmongo.domain.User;
import com.ndiniz.workshopmongo.dto.UserDTO;
import com.ndiniz.workshopmongo.repository.PostRepository;
import com.ndiniz.workshopmongo.repository.UserRepository;
import com.ndiniz.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

   @Autowired
   private PostRepository repo;

   public Post findById(String id) {
      Optional<Post> obj = repo.findById(id);
      return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
   }

   public List<Post> findByTitle(String text) {
      return repo.searchTitle(text);
   }

}
