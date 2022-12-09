package com.example.CS3141R01Team2.Terms;

import com.example.CS3141R01Team2.StudySet.StudySet;
import org.springframework.lang.NonNull;

import javax.persistence.*;

/**
 * @author wmisip
 * @author eljones
 * @author mykelly
 *
 * Terms Entity Class holds the actual Terms Object and generates it as a table in the database
 * has variables pertaining to the columns of the DB and any relationships corresponding to Entities
 */
@Entity(name = "terms")
@Table(name = "terms")
public class Terms {
    @Id
    @SequenceGenerator(
            name = "termSequence",
            sequenceName = "termSequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "termSequence"
    )
    @Column(updatable = false)
    @NonNull
    private Long termID;

    @ManyToOne()
    @JoinColumn(name = "parentSet")
    @NonNull
    private StudySet parentSet;

    @Column(nullable = false, columnDefinition = "TEXT")
    @NonNull
    private String term;

    @Column(nullable = false, columnDefinition = "TEXT")
    @NonNull
    private String definition;

    public StudySet getParentSet() {
        return parentSet;
    }

    public void setParentSet(StudySet parentSet) {
        this.parentSet = parentSet;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public Long getTermID() {
        return termID;
    }

    public Terms(StudySet parentSet, String term, String definition) {  // given actual StudySet or setID???
        this.parentSet = parentSet;
        this.term = term;
        this.definition = definition;
    }

    public Terms() {
    }


}
