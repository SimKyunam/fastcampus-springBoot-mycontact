package com.fastcampus.javaallinone.project3.mycontact.controller.dto;

import lombok.Data;

import java.time.LocalDate;

/**
 * Created by mileNote on 2020-09-21
 * Blog : https://milenote.tistory.com
 * Github : https://github.com/SimKyunam
 */

@Data
public class PersonDto {
    private String name;
    private int age;
    private String hobby;
    private String bloodType;
    private String address;
    private LocalDate birthday;
    private String job;
    private String phoneNumber;
}
