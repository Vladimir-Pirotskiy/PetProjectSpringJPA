package com.project2.jornal;

import com.project2.jornal.dao.HomeWorkRepository;
import com.project2.jornal.dao.JournalRepository;
import com.project2.jornal.dao.ScheduleRepository;
import com.project2.jornal.entety.CustomUser;
import com.project2.jornal.entety.HomeWork;
import com.project2.jornal.service.CustomerUserService;
import com.project2.jornal.service.HomeWorkService;
import com.project2.jornal.service.SubjectService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class JournalApplication {

    public static void main(String[] args) {
        SpringApplication.run(JournalApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(JournalRepository journalRepository, ScheduleRepository scheduleRepository, CustomerUserService customerUserService, SubjectService subjectService, HomeWorkService homeWorkService, HomeWorkRepository homeWorkRepository) {
        return (args) -> {

            CustomUser customUser = new CustomUser("vasya", true);
            CustomUser customUser2 = new CustomUser("masha", false);
            CustomUser customUser3 = new CustomUser("peya", true);
            CustomUser customUser4 = new CustomUser("anya", false);

            customerUserService.addCustomUser(customUser);
            customerUserService.addCustomUser(customUser2);
            customerUserService.addCustomUser(customUser3);
            customerUserService.addCustomUser(customUser4);

            HomeWork homeWork = new HomeWork("task1", 32, LocalDate.now());
            HomeWork homeWork2 = new HomeWork("task2", 1, LocalDate.now());
            HomeWork homeWork3 = new HomeWork("task3", 100, LocalDate.of(2020,1,2));
            HomeWork homeWork4 = new HomeWork("task4", 23, LocalDate.now());

            homeWorkService.addHomeWork(homeWork);
            homeWorkService.addHomeWork(homeWork2);
            homeWorkService.addHomeWork(homeWork3);
            homeWorkService.addHomeWork(homeWork4);

        };
    }
}
