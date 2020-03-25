package com.example.twitterclone.repository;

import com.example.twitterclone.model.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,String> {
}
