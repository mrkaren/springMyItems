package com.example.springmyitems.repository;

import com.example.springmyitems.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    List<User> findAllByName(String name);

}
