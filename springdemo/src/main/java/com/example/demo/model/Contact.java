package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    private int id;
    private String name;
    private String phoneNumber;
}

//@Data: Generates getters, setters, toString
///@NoArgsConstructor: Generates a no-arguments constructor.
//@AllArgsConstructor: Generates a constructor with all fields as parameters.