package com.project2.jornal.service.impl;

import com.project2.jornal.dao.CustomUserRepository;
import com.project2.jornal.entety.CustomUser;
import com.project2.jornal.service.CustomerUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomUserServiceImpl implements CustomerUserService {
    private final CustomUserRepository customUserRepository;

    @Override
    public void addCustomUser(CustomUser customerUser) {
        customUserRepository.save(customerUser);
    }

    @Override
    public void editCustomUser(CustomUser customUser, Long customUser_id) {
        CustomUser oldCustomerUser = customUserRepository.findById(customUser_id).orElseThrow(() -> new UsernameNotFoundException("not found"));

        BeanUtils.copyProperties(customUser, oldCustomerUser, "id");

        customUserRepository.save(oldCustomerUser);
    }


    @Override
    public void deleteCustomUser(CustomUser customUser) {
        customUserRepository.delete(customUser);
    }

    @Override
    public List<CustomUser> findAllCustomUser() {
        return customUserRepository.findAll();

    }

    @Override
    public CustomUser findCustomUser(Long customUser_id) {
        return customUserRepository.getOne(customUser_id);

    }
}
