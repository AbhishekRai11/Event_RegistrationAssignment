package com.event.event.Controller;

import com.event.event.Entities.EventRegister;
import com.event.event.Services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class EventController {
    @Autowired
    EventService eventService;

    @GetMapping("user/get")
    public EventRegister getEvent(@RequestParam("eventId") Integer eventId){
        return eventService.getEvent(eventId);
    }

    @PostMapping("admin/post")
    public String createEvent(@RequestBody EventRegister eventRegister){
        return eventService.createEvent(eventRegister);
    }



    @PutMapping("admin/put")
    public String modifyEvent(@RequestParam("eventId") Integer eventId , @RequestParam("eventLocation") String eventLocation){
        return eventService.setEvent(eventId,eventLocation);
    }

    @DeleteMapping("admin/delete")
    public String deleteEvent(@RequestParam("eventId") Integer eventId){
        return eventService.deleteEvent(eventId);
    }


}
