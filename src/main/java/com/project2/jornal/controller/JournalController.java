package com.project2.jornal.controller;

import com.project2.jornal.entety.Journal;
import com.project2.jornal.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/journal")

public class JournalController {

    private JournalService journalService;

    @Autowired
    public JournalController(JournalService journalService) {
        this.journalService = journalService;
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody Journal journal) {
        journalService.addJournal(journal);

        return ResponseEntity.ok().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Journal> find(@PathVariable("id") Long journal_id) {
        journalService.findJournal(journal_id);

        return ResponseEntity.ok().body(journalService.findJournal(journal_id));

    }

    @GetMapping
    public List<Journal> findAll() {

        return journalService.findAllJournals();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> edit(@RequestBody Journal journal, @PathVariable("id") Long journal_id) {
        journalService.editJournal(journal, journal_id);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody Journal journal) {
        journalService.delete(journal);

        return ResponseEntity.ok().build();
    }
}
