package com.devclass.camadasormdto.repositories;

import com.devclass.camadasormdto.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
