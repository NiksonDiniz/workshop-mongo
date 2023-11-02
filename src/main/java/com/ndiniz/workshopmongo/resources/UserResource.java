package com.ndiniz.workshopmongo.resources;

import com.ndiniz.workshopmongo.domain.User;
import com.ndiniz.workshopmongo.dto.UserDTO;
import com.ndiniz.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

   @Autowired
   private UserService service;

   //@RequestMapping(method = RequestMethod.GET)
   @GetMapping
   public ResponseEntity<List<UserDTO>> findAll() {
      List<User> list = service.findAll();
      List<UserDTO> listDTO = list.stream().map(UserDTO::new).collect(Collectors.toList());
      return ResponseEntity.ok().body(listDTO);
   }

   @RequestMapping(value = "/{id}", method = RequestMethod.GET)
   public ResponseEntity<UserDTO> findById(@PathVariable String id) {
      User obj = service.findById(id);
      return ResponseEntity.ok().body(new UserDTO(obj));
   }
}
