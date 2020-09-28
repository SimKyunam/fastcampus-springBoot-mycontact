package com.fastcampus.javaallinone.project3.mycontact.configuration.serializer;

import com.fastcampus.javaallinone.project3.mycontact.domain.dto.Birthday;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDate;

/**
 * Created by mileNote on 2020-09-28
 * Blog : https://milenote.tistory.com
 * Github : https://github.com/SimKyunam
 */
public class BirthdaySerializer extends JsonSerializer<Birthday> {
    @Override
    public void serialize(Birthday value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if(value != null){
            gen.writeObject(LocalDate.of(value.getYearOfBirthday(), value.getMonthOfBirthday(), value.getDayOfBirthday()));
        }
    }
}
