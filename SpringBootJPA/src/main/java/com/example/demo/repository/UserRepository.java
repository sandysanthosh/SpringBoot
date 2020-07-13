package com.example.demo.repository;    
import org.springframework.data.repository.CrudRepository;
import com.example.demo.model.UserRecord;  
   
public interface UserRepository extends CrudRepository<UserRecord, String>   
{    
}   