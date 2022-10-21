package com.example.CS3141R01Team2.StudySet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import com.example.CS3141R01Team2.Users.Users;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class StudySetTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link StudySet#StudySet()}
     *   <li>{@link StudySet#setSetName(String)}
     *   <li>{@link StudySet#setSetOwner(Users)}
     *   <li>{@link StudySet#getSetID()}
     *   <li>{@link StudySet#getSetName()}
     *   <li>{@link StudySet#getSetOwner()}
     * </ul>
     */
    @Test
    void testConstructor() {
        StudySet actualStudySet = new StudySet();
        actualStudySet.setSetName("Set Name");
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setName("Name");
        users.setPassword("iloveyou");
        users.setStudySets(new ArrayList<>());
        users.setUsername("janedoe");
        actualStudySet.setSetOwner(users);
        assertNull(actualStudySet.getSetID());
        assertEquals("Set Name", actualStudySet.getSetName());
        assertSame(users, actualStudySet.getSetOwner());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link StudySet#StudySet(String, Users)}
     *   <li>{@link StudySet#setSetName(String)}
     *   <li>{@link StudySet#setSetOwner(Users)}
     *   <li>{@link StudySet#getSetID()}
     *   <li>{@link StudySet#getSetName()}
     *   <li>{@link StudySet#getSetOwner()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setName("Name");
        users.setPassword("iloveyou");
        users.setStudySets(new ArrayList<>());
        users.setUsername("janedoe");
        StudySet actualStudySet = new StudySet("Set Name", users);
        actualStudySet.setSetName("Set Name");
        Users users1 = new Users();
        users1.setEmail("jane.doe@example.org");
        users1.setName("Name");
        users1.setPassword("iloveyou");
        users1.setStudySets(new ArrayList<>());
        users1.setUsername("janedoe");
        actualStudySet.setSetOwner(users1);
        assertNull(actualStudySet.getSetID());
        assertEquals("Set Name", actualStudySet.getSetName());
        assertSame(users1, actualStudySet.getSetOwner());
    }
}

