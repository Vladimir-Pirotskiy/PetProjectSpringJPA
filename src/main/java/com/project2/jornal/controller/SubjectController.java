package com.project2.jornal.controller;


import com.project2.jornal.entety.Subject;
import com.project2.jornal.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {

    private SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody Subject subject) {
        subjectService.addSubject(subject);

        return ResponseEntity.ok().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Subject> find(@PathVariable("id") Long subject_id) {

        return ResponseEntity.ok().body(subjectService.findSubject(subject_id));

    }

    @GetMapping
    public List<Subject> findAll() {
        subjectService.findAllSubject();

        return subjectService.findAllSubject();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> edit(@RequestBody Subject subject, @PathVariable("id") Long subject_id) {
        subjectService.editSubject(subject, subject_id);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody Subject subject) {
        subjectService.deleteSubject(subject);

        return ResponseEntity.ok().build();
    }

}
