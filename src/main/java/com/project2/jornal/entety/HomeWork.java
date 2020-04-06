package com.project2.jornal.entety;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class HomeWork {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "journal_id")
    private Journal journal;

    private String task;
    private Integer score;
    private LocalDate date;


    public HomeWork() {
    }

    public HomeWork(String task, Integer score, LocalDate date) {
        this.task = task;
        this.score = score;
        this.date = date;
    }



}
