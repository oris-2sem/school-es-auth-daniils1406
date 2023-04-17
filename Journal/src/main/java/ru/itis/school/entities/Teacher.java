package ru.itis.school.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Teacher extends User {
    private String merits;

    private String experience;

    private int earn;

    @JsonManagedReference
    @OneToMany(mappedBy = "teacher",fetch = FetchType.EAGER)
    private Set<Timetable> timeTableList;
    @JsonManagedReference
    @OneToMany(mappedBy = "lead",fetch = FetchType.EAGER)
    private Set<SchoolClass> schoolClassList;

    @PreRemove
    private void preRemove(){
        for(Timetable timetable:timeTableList){
            timetable.setTeacher(null);
        }
        for(SchoolClass lead:schoolClassList){
            lead.setLead(null);
        }
    }
}
