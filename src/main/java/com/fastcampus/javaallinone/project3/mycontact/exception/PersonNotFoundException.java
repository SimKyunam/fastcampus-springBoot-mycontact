package com.fastcampus.javaallinone.project3.mycontact.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by mileNote on 2020-09-30
 * Blog : https://milenote.tistory.com
 * Github : https://github.com/SimKyunam
 */
@Slf4j
public class PersonNotFoundException extends RuntimeException {
    private static final String MESSAGE = "Person Entity가 존재하지 않습니다.";

    public PersonNotFoundException(){
        super(MESSAGE);
        log.error(MESSAGE);
    }
}
