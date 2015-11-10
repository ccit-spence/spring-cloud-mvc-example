package com.example.models;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@ToString
@RequiredArgsConstructor
public class Instructor {

    private Long id;
    private String firstName;
    private String lastName;

}
