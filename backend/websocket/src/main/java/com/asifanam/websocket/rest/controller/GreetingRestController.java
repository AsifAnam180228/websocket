package com.asifanam.websocket.rest.controller;

import com.asifanam.websocket.service.GreetingService;
import com.asifanam.websocket.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingRestController {

    @Autowired
    private GreetingService greetingService;

    @MessageMapping("/hello")
    @SendTo("/topic/greeting")
    public Message greeting(){
        return greetingService.getMessage();
    }
}
