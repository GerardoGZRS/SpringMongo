package com.opencodez.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.opencodez.domain.Users;
import org.springframework.stereotype.Repository;

@Repository("usersRepository")
public interface UserRepository extends MongoRepository<Users, String> {
	
    public abstract Users findById(String id);
    
    Users findFirstByName(String name);
        
	
    @Query("{address:'?0'}")
    List<Users> findCustomByAddress(String address);

    @Query("{address : { $regex: ?0 } }")
    List<Users> findCustomByRegExAddress(String domain);

}
