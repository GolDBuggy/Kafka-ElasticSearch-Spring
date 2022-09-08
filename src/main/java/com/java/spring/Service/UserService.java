package com.java.spring.Service;

import com.java.spring.Model.User;
import com.java.spring.Repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo repo;

    private final KafkaTemplate<String,Object> template;
    private final KafkaTemplate<String,String> stringTemplate;

    private static String INPUT="input";
    private static String TEXT="text";


    public Iterable<User> getAll(){
        Pageable pageable= PageRequest.of(0,10, Sort.by("money").descending());
        Iterable<User> users=  repo.findAll(pageable);
        sendListJsonMessage(users);
        return users;
    }

    public void update(User user){
        repo.save(user);
        sendStringMessage("User updated successfully => "+user);
    }


    public void save(User user){
        user.setId(UUID.randomUUID().toString());
        sendJsonMessage(user);
        repo.save(user);
    }

    public User getById(String id){
        User user=repo.findById(id).get();
        sendJsonMessage(user);
        return user;
    }

    public void deleteAll(){
        repo.deleteAll();
        sendStringMessage("All users deleted!");
    }

    public void deleteById(String id){
        repo.deleteById(id);
        sendStringMessage("User deleted successfully id => "+id);

    }


    private void sendStringMessage(String message){
        stringTemplate.send(TEXT,message);
    }

    private void sendJsonMessage(User user){
        template.send(INPUT,user);
    }

    private void sendListJsonMessage(Iterable<User> user){
        template.send(INPUT,user);
    }
}
