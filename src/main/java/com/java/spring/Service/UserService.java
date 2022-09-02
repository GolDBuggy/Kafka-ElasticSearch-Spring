package com.java.spring.Service;

import com.java.spring.Model.User;
import com.java.spring.Repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo repo;

    private final KafkaTemplate<String,Object> template;

    String topic="elastic1";
    String topic1="elastic2";


    public Iterable<User> getAll(){
        Iterable<User> users=  repo.findAll();
        template.send(topic1,users);
        return users;
    }

    public void save(User user){
        user.setId(UUID.randomUUID().toString());
        template.send(topic,user);
        repo.save(user);
    }
}
