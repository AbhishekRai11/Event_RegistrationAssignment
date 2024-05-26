package com.event.event.Controller;

import com.event.event.Entities.EventRegister;
import com.event.event.Services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {
    @Autowired
    EventService eventService;

    @GetMapping("user/get")
    public ResponseEntity<Object> getEvent(@RequestParam("eventId") Integer eventId){
        return ResponseEntity.ok(eventService.getEvent(eventId));
    }

    @GetMapping("user/getAll")
    public  ResponseEntity<Object> getAllEvent(){
        return  ResponseEntity.ok(eventService.getAllEvent());
    }

    @PostMapping("admin/post")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Object> createEvent(@RequestBody EventRegister eventRegister){
        //return eventService.createEvent(eventRegister);
        return ResponseEntity.ok(eventService.createEvent(eventRegister));
    }



    @PutMapping("admin/put")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Object> modifyEvent(@RequestParam("eventId") Integer eventId , @RequestParam("eventLocation") String eventLocation){
        //return eventService.setEvent(eventId,eventLocation);
        return ResponseEntity.ok(eventService.setEvent(eventId,eventLocation));
    }

    @DeleteMapping("admin/delete")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Object> deleteEvent(@RequestParam("eventId") Integer eventId){
        //return eventService.deleteEvent(eventId);
        return ResponseEntity.ok(eventService.deleteEvent(eventId));
    }


}
