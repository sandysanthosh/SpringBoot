package com.example.demo.service;    
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.UserRecord;
import com.example.demo.repository.UserRepository;  

@Service    
public class UserService   
{    
@Autowired    
private UserRepository userRepository;    
public List<UserRecord> getAllUsers()  
{    
List<UserRecord>userRecords = new ArrayList<>();    
userRepository.findAll().forEach(userRecords::add);    
return userRecords;    
}    
public void addUser(UserRecord userRecord)  
{    
userRepository.save(userRecord);    
}    
}    