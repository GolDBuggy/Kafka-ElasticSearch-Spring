package com.java.spring.Repository;

import com.java.spring.Model.User;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface UserRepo extends ElasticsearchRepository<User,String> {


}
