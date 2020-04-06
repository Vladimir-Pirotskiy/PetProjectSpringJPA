package com.project2.jornal.entety;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
public class CustomUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy = "customUser")
    private Journal journal;


    private String name;
    private Boolean type;


    public CustomUser() {
    }

    public CustomUser(String name, Boolean type) {
        this.name = name;
        this.type = type;
    }
}
