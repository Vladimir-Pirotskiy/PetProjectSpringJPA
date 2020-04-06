package com.project2.jornal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomUserRequest {

    private String name;
    private Long postId;
    private Boolean type;




}
