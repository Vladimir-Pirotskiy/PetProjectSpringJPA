package com.project2.jornal.controller;

import com.project2.jornal.entety.CustomUser;
import com.project2.jornal.service.CustomerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class CustomUserController {

    private CustomerUserService customerUserService;

    @Autowired
    public CustomUserController(CustomerUserService customerUserService) {
        this.customerUserService = customerUserService;
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody CustomUser customUser) {
        customerUserService.addCustomUser(customUser);

        return ResponseEntity.ok().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomUser> find(@PathVariable("id") Long customUser_id) {
        customerUserService.findCustomUser(customUser_id);

        return ResponseEntity.ok().body(customerUserService.findCustomUser(customUser_id));
    }

    @GetMapping
    public List<CustomUser> findAll() {

        return customerUserService.findAllCustomUser();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> edit(@RequestBody CustomUser customUser, @PathVariable("id") Long customUser_id) {
        customerUserService.editCustomUser(customUser, customUser_id);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody CustomUser customUser) {
        customerUserService.deleteCustomUser(customUser);

        return ResponseEntity.ok().build();
    }

}
