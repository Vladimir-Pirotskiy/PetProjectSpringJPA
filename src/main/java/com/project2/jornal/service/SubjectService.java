package com.project2.jornal.service;

import com.project2.jornal.entety.Subject;

import java.util.List;

public interface SubjectService {

    void addSubject(Subject subject);

    void editSubject(Subject subject, Long subject_id);

    Subject findSubject(Long subject_id);

    List<Subject> findAllSubject();

    void deleteSubject(Subject subject);
}
