package com.project2.jornal.service;

import com.project2.jornal.entety.HomeWork;

import java.util.List;

public interface HomeWorkService {

    void addHomeWork(HomeWork homeWork);

    void editHomeWork(HomeWork homeWork, Long homeWork_id);

    List<HomeWork> findAll();

    HomeWork findHomeWork(Long homeWork_id);

    void deleteHomeWork(HomeWork homeWork);

}
