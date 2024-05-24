package com.event.event.Services;

import com.event.event.Entities.EventRegister;
import com.event.event.Repositories.EventRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    public EventRegister getEvent(Integer id){

        EventRegister eventRegister= eventRepository.findById(id).get();
        return eventRegister;

    }

    public String createEvent(EventRegister eventRegister){
         EventRegister eventRegister1=new EventRegister();
         eventRegister1.setLocation(eventRegister.getLocation());
         eventRegister1.setDate(eventRegister.getDate());
         eventRegister1.setName(eventRegister.getName());
         eventRegister1.setRegistrationDetail(eventRegister.getRegistrationDetail());
         eventRepository.save(eventRegister1);
        return "successfully saved";

    }
    public String setEvent(Integer id,String location){

        EventRegister eventRegister= eventRepository.findById(id).get();
        eventRegister.setLocation(location);
        eventRepository.save(eventRegister);
        return "successfully saved";

    }

    public String deleteEvent(Integer id){

        eventRepository.deleteById(id);
        return "Successfully deleted";


    }
}
