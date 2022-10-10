package com.example.CS3141R01Team2.StudySet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudySetRepository 
    extends JpaRepository<StudySet, Long>{
    
}
