package com.project2.jornal.controller;


import com.project2.jornal.entety.HomeWork;
import com.project2.jornal.service.HomeWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/homeWork")
public class HomeWorkController {

    private HomeWorkService homeWorkService;

    @Autowired
    public HomeWorkController(HomeWorkService homeWorkService) {
        this.homeWorkService = homeWorkService;
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody HomeWork homeWork) {
        homeWorkService.addHomeWork(homeWork);

        return ResponseEntity.ok().build();


    }
    @GetMapping("/{id}")
    public ResponseEntity<HomeWork> find(@PathVariable("id") Long homeWork_id) {

        return ResponseEntity.ok().body(homeWorkService.findHomeWork(homeWork_id));

    }

    @GetMapping
    public List<HomeWork> findAll() {

        return homeWorkService.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> edit(@RequestBody HomeWork homeWork, @PathVariable("id") Long homeWork_id) {
        homeWorkService.editHomeWork(homeWork, homeWork_id);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody HomeWork homeWork) {
        homeWorkService.deleteHomeWork(homeWork);

        return ResponseEntity.ok().build();
    }

}
