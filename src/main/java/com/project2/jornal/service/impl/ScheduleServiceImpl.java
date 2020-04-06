package com.project2.jornal.service.impl;

import com.project2.jornal.dao.ScheduleRepository;
import com.project2.jornal.entety.Schedule;
import com.project2.jornal.service.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleRepository scheduleRepository;

    @Override
    public void addSchedule(Schedule schedule) {
        scheduleRepository.save(schedule);
    }

    @Override
    public void editSchedule(Schedule schedule, Long schedule_id) {
        Schedule oldSchedule = scheduleRepository.findById(schedule_id).orElseThrow(() -> new UsernameNotFoundException("not found"));

        BeanUtils.copyProperties((schedule), oldSchedule, "id");

        scheduleRepository.save(oldSchedule);
    }

    @Override
    public Schedule findSchedule(Long schedule_id) {
        return scheduleRepository.getOne(schedule_id);

    }

    @Override
    public void deleteSchedule(Schedule schedule) {
        scheduleRepository.delete(schedule);
    }

    @Override
    public List<Schedule> findAllSchedule() {
        return scheduleRepository.findAll();
    }
}
