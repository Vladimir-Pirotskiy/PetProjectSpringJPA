package com.project2.jornal.service;

import com.project2.jornal.entety.Journal;

import java.util.List;

public interface JournalService {

    void addJournal(Journal journal);

    void editJournal(Journal journal, Long journal_id);

    List<Journal> findAllJournals();

    Journal findJournal(Long journal_id);

    void delete(Journal journal);

}
