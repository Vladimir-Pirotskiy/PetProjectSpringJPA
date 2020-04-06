package com.project2.jornal.dao;

import com.project2.jornal.entety.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomUserRepository extends JpaRepository<CustomUser, Long> {


    @Query("SELECT cu FROM CustomUser cu WHERE cu.name = :name")
    List<CustomUser> findAllByName(String name);
}