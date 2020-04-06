package com.project2.jornal.service.impl;

import com.project2.jornal.dao.SubjectRepository;
import com.project2.jornal.entety.Subject;
import com.project2.jornal.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;

    @Override
    public void addSubject(Subject subject) {
        subjectRepository.save(subject);
    }

    @Override
    public void editSubject(Subject subject, Long subject_id) {
        Subject oldSubject = subjectRepository.findById(subject_id).orElseThrow(() -> new UsernameNotFoundException("not found"));
        BeanUtils.copyProperties(subject, oldSubject);
        subjectRepository.save(oldSubject);
    }

    @Override
    public void deleteSubject(Subject subject) {
        subjectRepository.delete(subject);
    }

    @Override
    public Subject findSubject(Long subject_id) {
        return subjectRepository.getOne(subject_id);
    }

    @Override
    public List<Subject> findAllSubject() {
        return subjectRepository.findAll();
    }
}
