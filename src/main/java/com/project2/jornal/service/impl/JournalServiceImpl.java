package com.project2.jornal.service.impl;

import com.project2.jornal.dao.JournalRepository;
import com.project2.jornal.entety.Journal;
import com.project2.jornal.service.JournalService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JournalServiceImpl implements JournalService {
    private final JournalRepository journalRepository;

//    public JournalServiceImpl(JournalRepository journalRepository) {
//        this.journalRepository = journalRepository;
//    }


    @Override
    public void addJournal(Journal journal) {
        journalRepository.save(journal);

    }

    @Override
    public void editJournal(Journal journal, Long journal_id) {
        Journal oldJournal = journalRepository.findById(journal_id).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        BeanUtils.copyProperties(journal, oldJournal, "id");

        journalRepository.save(oldJournal);

    }

    @Override
    public List<Journal> findAllJournals() {
        return journalRepository.findAll();
    }

    @Override
    public Journal findJournal(Long journal_id) {
        return journalRepository.getOne(journal_id);
    }

    @Override
    public void delete(Journal journal) {
        journalRepository.delete(journal);

    }
}
