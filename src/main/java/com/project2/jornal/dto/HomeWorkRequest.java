package com.project2.jornal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HomeWorkRequest {

    private String task;
    private Integer score;
    private Date date;
}
