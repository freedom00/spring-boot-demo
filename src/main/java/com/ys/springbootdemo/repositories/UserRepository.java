package com.ys.springbootdemo.repositories;

import com.ys.springbootdemo.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
