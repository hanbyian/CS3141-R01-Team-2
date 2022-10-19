package com.example.CS3141R01Team2.Users;

import java.util.List;
import java.util.Set;

import com.example.CS3141R01Team2.StudySet.StudySet;
import org.hibernate.annotations.Cascade;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity(name="users") //Entity tag used for HQL (hibernate queries)
@Table(
    name="users",
    uniqueConstraints = {
        @UniqueConstraint(name="userEmailUnique", columnNames="email")
    }
    ) //Table tag used for JPQL (Java Persistence)
public class Users {

    @Id //classifies the upcoming variable will be treated at thew Primary Key
    @SequenceGenerator( //Sequence Generator lets us customize the sequence for the ID generation, increments by 1
        name = "userSequence",
        sequenceName = "userSequence",
        allocationSize = 1
    )
    @GeneratedValue( //tells us to use the generator we created
        strategy = GenerationType.SEQUENCE,
        generator = "userSequence"
    )
    
    @Column(updatable = false)
    @NonNull      // unique?
    private Long userID;

    @Column(unique = true)
    @NonNull
    private String username;

    @Column()
    @NonNull
    private String password;    //NOTE: change password data type to hash for security

    @Column(unique = true)
    @NonNull     // unique?, or multiple accounts ok?
    private String email;

    @Column()
    @NonNull
    private String name;

    public Set<StudySet> getStudySets() {
        return studySets;
    }

    public void setStudySets(Set<StudySet> studySets) {
        this.studySets = studySets;
    }

    @OneToMany(mappedBy="setID")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<StudySet> studySets;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    //Default constructor, missing userID since that is automatically generated
    public Users(String username, String password, String email, String name) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
    }

    public Users() {
    }
}
