package ru.itis.school.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student extends User {
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "school_class_of_student")
    private SchoolClass schoolClassOfStudent;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent")
    private User parent;
    @JsonManagedReference
    @OneToMany(mappedBy = "student",fetch = FetchType.EAGER)
    private List<Task> taskList;


    @PreRemove
    private void preRemove(){
        for(Task task:taskList){
            task.setStudent(null);
        }
    }
}
