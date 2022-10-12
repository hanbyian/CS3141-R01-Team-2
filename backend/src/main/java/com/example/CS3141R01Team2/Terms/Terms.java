package com.example.CS3141R01Team2.Terms;

import com.example.CS3141R01Team2.StudySet.StudySet;

import javax.persistence.*;

@Entity(name="terms")
@Table(name="terms")
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
    private Long termID;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="parentSet", nullable = false)
    private StudySet parentSet;

    @Column(nullable=false)
    private String term;

    @Column(nullable=false)
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
    
    public Terms(StudySet parentSet, String term, String definition) {
        this.parentSet = parentSet;
        this.term = term;
        this.definition = definition;
    }
    public Terms() {
    }

    
}
