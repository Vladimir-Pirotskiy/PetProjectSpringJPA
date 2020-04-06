package com.project2.jornal.dao;

import com.project2.jornal.entety.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepository extends JpaRepository<Journal, Long> {
}
