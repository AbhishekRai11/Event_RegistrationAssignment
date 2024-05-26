package com.event.event;
import com.event.event.Entities.EventRegister;
import com.event.event.Repositories.EventRepository;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;




@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class EventTest {

    @Autowired
    EventRepository pRepo;

    @Test
    @Order(1)
    public void testCreate () {
        EventRegister p = new EventRegister();
        //p.setId(5);
        p.setName("iPhone XR");
        p.setDate("12/05/2024");
        p.setLocation("Munmbai");
        p.setRegistrationDetail("hsdfoeff fhifu fiufhi");

        pRepo.save(p);
        assertNotNull(pRepo.findByUsername("iPhone XR").get());
    }



//    @Test
//    @Order(2)
//    public void testReadAll () {
//        List list = pRepo.findAll();
//        assertThat(list).size().isGreaterThan(0);
//    }

    @Test
    @Order(4)
    public void testRead () {
        EventRegister event = pRepo.findByUsername("iPhone XR").get();
        assertEquals("iPhone XR", event.getName());
    }

    @Test
    @Order(3)
    public void testUpdate () {
        EventRegister event = pRepo.findByUsername("iPhone XR").get();
        System.out.println(event);
        event.setLocation("Chennai");
        pRepo.save(event);
        assertNotEquals("Mumbai", pRepo.findByUsername("iPhone XR").get().getLocation());
    }

    @Test
    @Order(4)
    public void testDelete () {
        //pRepo.deleteById();
        EventRegister event = pRepo.findByUsername("iPhone XR").get();
        int id= event.getId();
        pRepo.deleteById(id);
        assertThat(pRepo.existsById(id)).isFalse();
    }

}

