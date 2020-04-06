package com.project2.jornal.service;

import com.project2.jornal.entety.Schedule;

import java.util.List;

public interface ScheduleService {

    void addSchedule(Schedule schedule);

    void editSchedule(Schedule schedule, Long schedule_id);

    Schedule findSchedule(Long schedule_id);

    List<Schedule> findAllSchedule();

    void deleteSchedule(Schedule schedule);

}
