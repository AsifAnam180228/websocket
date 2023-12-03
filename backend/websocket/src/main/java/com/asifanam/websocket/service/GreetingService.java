package com.asifanam.websocket.service;

import com.asifanam.websocket.vo.Message;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Service
public class GreetingService {
    public Message getMessage(){
        Calendar c = Calendar.getInstance();
        LocalDateTime time = LocalDateTime.now();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = time.format(myFormat);
        StringBuilder sb = new StringBuilder();
        String message = "Have a Good Day! " + timeOfDay;
        if (timeOfDay > 0 && timeOfDay<12){
            message = "Good Morning!";
        }
        else if (timeOfDay >= 16  && timeOfDay< 21){
            message = "Good Evening!";
        }
        else if (timeOfDay >= 22 && timeOfDay <24){
            message = "Good Night!";
        }
        sb.append(message).append(" - ").append(formattedDate).append(" - ").append(generateString());
        return new Message(sb.toString());
    }

    private String generateString() {
        return UUID.randomUUID().toString();
    }

}
