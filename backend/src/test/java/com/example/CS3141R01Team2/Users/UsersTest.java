package com.example.CS3141R01Team2.Users;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import com.example.CS3141R01Team2.StudySet.StudySet;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class UsersTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Users#Users()}
     *   <li>{@link Users#setEmail(String)}
     *   <li>{@link Users#setName(String)}
     *   <li>{@link Users#setPassword(String)}
     *   <li>{@link Users#setStudySets(List)}
     *   <li>{@link Users#setUsername(String)}
     *   <li>{@link Users#getEmail()}
     *   <li>{@link Users#getName()}
     *   <li>{@link Users#getPassword()}
     *   <li>{@link Users#getStudySets()}
     *   <li>{@link Users#getUsername()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Users actualUsers = new Users();
        actualUsers.setEmail("jane.doe@example.org");
        actualUsers.setName("Name");
        actualUsers.setPassword("iloveyou");
        ArrayList<StudySet> studySetList = new ArrayList<>();
        actualUsers.setUsername("janedoe");
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setName("Name");
        users.setPassword("iloveyou");
        ArrayList<StudySet> studySetList1 = new ArrayList<>();
        users.setUsername("janedoe");
        StudySet studySet = new StudySet();
        studySet.setSetName("Set Name");
        studySet.setSetOwner(users);
        assertEquals("jane.doe@example.org", actualUsers.getEmail());
        assertEquals("Name", actualUsers.getName());
        assertEquals("iloveyou", actualUsers.getPassword());
        assertEquals("janedoe", actualUsers.getUsername());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Users#Users(String, String, String, String)}
     *   <li>{@link Users#setEmail(String)}
     *   <li>{@link Users#setName(String)}
     *   <li>{@link Users#setPassword(String)}
     *   <li>{@link Users#setUsername(String)}
     *   <li>{@link Users#Users()}
     *   <li>{@link Users#getEmail()}
     *   <li>{@link Users#getName()}
     *   <li>{@link Users#getPassword()}
     *   <li>{@link Users#getUsername()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        Users actualUsers = new Users("janedoe", "iloveyou", "jane.doe@example.org", "Name");
        actualUsers.setEmail("jane.doe@example.org");
        actualUsers.setName("Name");
        actualUsers.setPassword("iloveyou");
        ArrayList<StudySet> studySetList = new ArrayList<>();
        actualUsers.setUsername("janedoe");
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setName("Name");
        users.setPassword("iloveyou");
        ArrayList<StudySet> studySetList1 = new ArrayList<>();
        users.setUsername("janedoe");
        StudySet studySet = new StudySet();
        studySet.setSetName("Set Name");
        studySet.setSetOwner(users);
        assertEquals("jane.doe@example.org", actualUsers.getEmail());
        assertEquals("Name", actualUsers.getName());
        assertEquals("iloveyou", actualUsers.getPassword());
        assertEquals("janedoe", actualUsers.getUsername());
    }
}

