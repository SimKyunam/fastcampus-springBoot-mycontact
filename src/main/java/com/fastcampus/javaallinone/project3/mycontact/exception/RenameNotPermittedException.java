package com.fastcampus.javaallinone.project3.mycontact.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by mileNote on 2020-09-30
 * Blog : https://milenote.tistory.com
 * Github : https://github.com/SimKyunam
 */
@Slf4j
public class RenameNotPermittedException extends RuntimeException{
    private static final String MESSAGE = "이름을 변경 허용하지 않습니다.";

    public RenameNotPermittedException(){
        super(MESSAGE);
        log.error(MESSAGE);
    }
}
