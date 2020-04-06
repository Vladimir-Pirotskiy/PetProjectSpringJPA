package com.project2.jornal.dto;

import com.project2.jornal.entety.Day;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleRequest {

    private Day dayWeek;
}
