package com.event.event.Repositories;

import com.event.event.Entities.EventRegister;
import com.event.event.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<EventRegister,Integer> {

}
