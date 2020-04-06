package com.project2.jornal.service;

import com.project2.jornal.entety.CustomUser;

import java.util.List;

public interface CustomerUserService {

    void addCustomUser(CustomUser customerUser);

    void editCustomUser(CustomUser customUser, Long customUser_id);

    List<CustomUser> findAllCustomUser();

    void deleteCustomUser(CustomUser customUser);

    CustomUser findCustomUser(Long customUser_id);
}
