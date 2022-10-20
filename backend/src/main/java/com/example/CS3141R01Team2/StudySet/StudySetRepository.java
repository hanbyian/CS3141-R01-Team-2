package com.example.CS3141R01Team2.StudySet;

import com.example.CS3141R01Team2.Users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudySetRepository 
    extends JpaRepository<StudySet, Long> {

    @Query("SELECT u.setID, u.setName FROM studyset u WHERE u.setOwner = ?1")
    public List<ArrayList<?>> findStudySetsByUser(Users users );
}
