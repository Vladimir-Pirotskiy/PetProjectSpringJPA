package com.project2.jornal.entety;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class Journal {

    public Journal() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private CustomUser customUser;

    @OneToMany
    @JoinColumn(name = "homeWork_id")
    private List<HomeWork> homeWorkList;

    @OneToMany
    @JoinColumn(name = "schedule_id")
    private List<Schedule> scheduleList;

    @OneToMany
    @JoinColumn(name = "subject_id")
    private List<Subject> subjectList;

}
