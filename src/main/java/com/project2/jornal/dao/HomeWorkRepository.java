package com.project2.jornal.dao;

import com.project2.jornal.entety.HomeWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HomeWorkRepository extends JpaRepository<HomeWork, Long> {

    @Query("SELECT hw FROM HomeWork hw WHERE hw.task =:task")
    List<HomeWork> findAllByTask(String task);
}
