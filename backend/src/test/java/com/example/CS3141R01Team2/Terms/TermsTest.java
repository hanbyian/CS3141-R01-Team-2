package com.example.CS3141R01Team2.Terms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import com.example.CS3141R01Team2.StudySet.StudySet;
import com.example.CS3141R01Team2.Users.Users;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TermsTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Terms#Terms()}
     *   <li>{@link Terms#setDefinition(String)}
     *   <li>{@link Terms#setParentSet(StudySet)}
     *   <li>{@link Terms#setTerm(String)}
     *   <li>{@link Terms#getDefinition()}
     *   <li>{@link Terms#getParentSet()}
     *   <li>{@link Terms#getTerm()}
     *   <li>{@link Terms#getTermID()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Terms actualTerms = new Terms();
        actualTerms.setDefinition("Definition");
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setName("Name");
        users.setPassword("iloveyou");
        users.setUsername("janedoe");
        StudySet studySet = new StudySet();
        studySet.setSetName("Set Name");
        studySet.setSetOwner(users);
        actualTerms.setParentSet(studySet);
        actualTerms.setTerm("Term");
        assertEquals("Definition", actualTerms.getDefinition());
        assertSame(studySet, actualTerms.getParentSet());
        assertEquals("Term", actualTerms.getTerm());
        assertNull(actualTerms.getTermID());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Terms#Terms(StudySet, String, String)}
     *   <li>{@link Terms#setDefinition(String)}
     *   <li>{@link Terms#setParentSet(StudySet)}
     *   <li>{@link Terms#setTerm(String)}
     *   <li>{@link Terms#getDefinition()}
     *   <li>{@link Terms#getParentSet()}
     *   <li>{@link Terms#getTerm()}
     *   <li>{@link Terms#getTermID()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        Users users = new Users();
        users.setEmail("jane.doe@example.org");
        users.setName("Name");
        users.setPassword("iloveyou");
        users.setUsername("janedoe");

        StudySet studySet = new StudySet();
        studySet.setSetName("Set Name");
        studySet.setSetOwner(users);
        Terms actualTerms = new Terms(studySet, "Term", "Definition");
        actualTerms.setDefinition("Definition");
        Users users1 = new Users();
        users1.setEmail("jane.doe@example.org");
        users1.setName("Name");
        users1.setPassword("iloveyou");
        users1.setUsername("janedoe");
        StudySet studySet1 = new StudySet();
        studySet1.setSetName("Set Name");
        studySet1.setSetOwner(users1);
        actualTerms.setParentSet(studySet1);
        actualTerms.setTerm("Term");
        assertEquals("Definition", actualTerms.getDefinition());
        assertSame(studySet1, actualTerms.getParentSet());
        assertEquals("Term", actualTerms.getTerm());
        assertNull(actualTerms.getTermID());
    }
}

