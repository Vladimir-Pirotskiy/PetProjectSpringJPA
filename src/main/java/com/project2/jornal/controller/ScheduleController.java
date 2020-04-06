package com.project2.jornal.controller;

import com.project2.jornal.entety.Journal;
import com.project2.jornal.entety.Schedule;
import com.project2.jornal.service.JournalService;
import com.project2.jornal.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    private ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody Schedule schedule) {
        scheduleService.addSchedule(schedule);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Schedule> find(@PathVariable("id") Long schedule_id) {

        return ResponseEntity.ok().body(scheduleService.findSchedule(schedule_id));

    }

    @GetMapping
    public List<Schedule> findAll() {

        return scheduleService.findAllSchedule();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> edit(@RequestBody Schedule schedule, @PathVariable("id") Long schedule_id) {
        scheduleService.editSchedule(schedule, schedule_id);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody Schedule schedule) {
        scheduleService.deleteSchedule(schedule);

        return ResponseEntity.ok().build();
    }



}
