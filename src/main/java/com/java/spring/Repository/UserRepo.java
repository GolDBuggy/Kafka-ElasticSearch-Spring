package com.java.spring.Repository;

import com.java.spring.Model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserRepo extends ElasticsearchRepository<User,String> {


}
