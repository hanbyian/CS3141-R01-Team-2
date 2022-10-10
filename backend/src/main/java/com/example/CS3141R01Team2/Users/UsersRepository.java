package com.example.CS3141R01Team2.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository 
    extends JpaRepository<Users, Long>{
    
        

}
