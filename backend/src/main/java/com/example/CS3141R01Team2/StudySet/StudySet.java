package com.example.CS3141R01Team2.StudySet;

import java.util.Set;

import com.example.CS3141R01Team2.Terms.Terms;
import com.example.CS3141R01Team2.Users.Users;
import org.hibernate.annotations.Cascade;
import org.springframework.lang.NonNull;


import javax.persistence.*;

/**
 * @author wmisip
 * @author eljones
 * @author mykelly
 * <p>
 * StudySet Entity Class holds the actual StudySet Object and generates it as a table in the database
 * has variables pertaining to the columns of the DB and any relationships corresponding to Entities
 */
@Entity(name = "studyset")
@Table(name = "studyset")
public class StudySet {
    @Id
    @SequenceGenerator(
            name = "studySetSequence",
            sequenceName = "studySetSequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "studySetSequence"
    )

    @Column(updatable = false)      // unique?
    @NonNull
    private Long setID;

    @Column(nullable = false)
    @NonNull
    private String setName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "setOwner")
    @NonNull
    private Users setOwner;

    @OneToMany(mappedBy = "parentSet")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Terms> terms;

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public Users getSetOwner() {
        return setOwner;
    }

    public void setSetOwner(Users setOwner) {
        this.setOwner = setOwner;
    }

    public Long getSetID() {
        return setID;
    }

    public StudySet(String setName, Users setOwner) {
        this.setName = setName;
        this.setOwner = setOwner;
    }

    public StudySet() {
    }

}
