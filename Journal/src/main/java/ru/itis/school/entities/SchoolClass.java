package ru.itis.school.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
//import org.hibernate.annotations.UuidGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class SchoolClass {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "lead")
    private Teacher lead;

    @Column(name = "date_insert")
    private Date dateInsert;

    private String letter;

    @Column(name = "students_number")
    private int studentsNumber;

    @JsonManagedReference
    @OneToMany(mappedBy = "schoolClassOfStudent",fetch = FetchType.EAGER)
    private Set<Student> studentList;
    @JsonManagedReference
    @OneToMany(mappedBy = "schoolClassOfTimetable",fetch = FetchType.EAGER)
    private Set<Timetable> timetableList;


    @PreRemove
    private void preRemove(){
        for(Student student:studentList){
            student.setSchoolClassOfStudent(null);
        }
        for(Timetable timetable:timetableList){
            timetable.setSchoolClassOfTimetable(null);
        }
    }

}