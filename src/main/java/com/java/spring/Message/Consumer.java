package com.java.spring.Message;

import com.java.spring.Model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Component
@RequiredArgsConstructor
public class Consumer {

    private Logger logger=Logger.getLogger(Consumer.class.getName());

    private final List<User> users;


    @KafkaListener(topics = "elastic1",groupId = "grup1")
    public void postUser(List<User> user){
        users.addAll(user);
        System.out.println(users);
    }


    @KafkaListener(topics = "elastic2",groupId = "grup1")
    public void getUsers(List<User> user){
        logger.info(user+"");
    }



}
