package com.event.event.Repositories;

import com.event.event.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserResRepository extends JpaRepository<Users, Integer> {

  @Query(value = "select * from users where username = ?1", nativeQuery = true)
  Optional<Users> findByUsername(String username);
}
