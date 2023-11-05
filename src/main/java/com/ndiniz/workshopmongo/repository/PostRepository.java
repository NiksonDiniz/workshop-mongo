package com.ndiniz.workshopmongo.repository;

import com.ndiniz.workshopmongo.domain.Post;
import com.ndiniz.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
