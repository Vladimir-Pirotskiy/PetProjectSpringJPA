package com.project2.jornal.service.impl;

import com.project2.jornal.dao.HomeWorkRepository;
import com.project2.jornal.entety.HomeWork;
import com.project2.jornal.service.HomeWorkService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HomeWorkServiceImpl implements HomeWorkService {
    private final HomeWorkRepository homeWorkRepository;

    @Override
    public void addHomeWork(HomeWork homeWork) {
        homeWorkRepository.save(homeWork);
    }

    @Override
    public void editHomeWork(HomeWork homeWork, Long homeWork_id) {
        HomeWork oldHomeWork = homeWorkRepository.findById(homeWork_id).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        BeanUtils.copyProperties(homeWork, oldHomeWork, "id");

        homeWorkRepository.save(oldHomeWork);
    }

    @Override
    public List<HomeWork> findAll() {
        return homeWorkRepository.findAll();
    }

    @Override
    public HomeWork findHomeWork(Long homeWork_id) {
        return homeWorkRepository.getOne(homeWork_id);
    }

    @Override
    public void deleteHomeWork(HomeWork homeWork) {
        homeWorkRepository.delete(homeWork);
    }
}
