package com.example.CS3141R01Team2.StudySet;

import com.example.CS3141R01Team2.Users.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author wmisip
 * @author eljones
 * @author mykelly
 *
 * Repository for the StudySet Entity holding all queries currently needed for requests
 */
@Repository
public interface StudySetRepository 
    extends JpaRepository<StudySet, Long> {

    /**
     * Query to find all Study Sets for a given user
     *
     * @param users the user to find the study sets of
     * @return A List of ArrayLists for each study set owned by the user
     */
    @Query("SELECT u.setID, u.setName FROM studyset u WHERE u.setOwner = ?1")
    public List<ArrayList<?>> findStudySetsByUser(Users users );

    /**
     * Query to return a List of all Study Sets in the system
     *
     * @return A List of ArrayLists for each study set in the system
     */
    @Query("SELECT u.setID, u.setName, u.setOwner.username FROM studyset u")
    public List<ArrayList<?>> showAllSets();
}
