package com.event.event.Controller;

import com.event.event.Entities.EventRegister;
import com.event.event.Services.EventService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class EventControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EventService employeeService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getEvent() throws Exception{
        int eventId = 1;
        EventRegister event1 = new EventRegister();
        event1.setName("abhi");
        event1.setLocation("UP");
        event1.setDate("12/8/2024");


        given(employeeService.getEvent(eventId)).willReturn((event1));

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(get("/user/get?eventId=1", eventId));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.name", is(event1.getName())))
                .andExpect(jsonPath("$.location", is(event1.getLocation())))
                .andExpect(jsonPath("$.date", is(event1.getDate())));

    }


    @Test
    void modifyEvent() throws Exception{
        int eventId = 1;
        EventRegister event1 = new EventRegister();
        event1.setName("abhi");
        event1.setLocation("UP");
        event1.setDate("12/8/2024");

        EventRegister updateEvent1 = new EventRegister();
        event1.setName("abhi");
        event1.setLocation("MP");
        event1.setDate("12/8/2024");
        given(employeeService.getEvent(eventId)).willReturn((event1));
        given(employeeService.setEvent(eventId,"MP"))
                .willAnswer((invocation)-> invocation.getArgument(0));

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(put("/admin/put?eventId=1", eventId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updateEvent1)));


        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.name", is(updateEvent1.getName())))
                .andExpect(jsonPath("$.location", is(updateEvent1.getLocation())))
                .andExpect(jsonPath("$.date", is(updateEvent1.getDate())));

    }

    @Test
    void deleteEvent() throws Exception{

        int eventId = 1;
        willDoNothing().given(employeeService).deleteEvent(eventId);

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(delete("/admin/delete?eventId=1", eventId));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print());
    }

}