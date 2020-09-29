package com.fastcampus.javaallinone.project3.mycontact.service;

import com.fastcampus.javaallinone.project3.mycontact.controller.dto.PersonDto;
import com.fastcampus.javaallinone.project3.mycontact.domain.Person;
import com.fastcampus.javaallinone.project3.mycontact.repository.PersonRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {
    @InjectMocks //대상이 되는 객체에 사용
    private PersonService personService;

    @Mock //대상이 되는 객체에서 사용할 객체 주입
    private PersonRepository personRepository;

    @Test
    void getPeopleByName(){
        //Mockito 사용하는 이유 단위 테스트를 위해서..
        //Ex) personRepository.findByName()에서 에러가 발생해도 getPeopleByName()에 문제가 없으면 통과
        when(personRepository.findByName("martin"))
            .thenReturn(Lists.newArrayList(new Person("martin")));

        List<Person> result = personService.getPeopleByName("martin");

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getName()).isEqualTo("martin");
    }

    @Test
    void getPerson(){
        when(personRepository.findById(1L))
            .thenReturn(Optional.of(new Person("martin")));

        Person person = personService.getPerson(1L);

        assertThat(person.getName()).isEqualTo("martin");
    }

    @Test
    void getPersonIfNotFound(){
        when(personRepository.findById(1L))
            .thenReturn(Optional.empty());

        Person person = personService.getPerson(1L);

        assertThat(person).isNull();
    }

    @Test
    void put(){
        //return이 없는 경우 테스트를 검증하기가 어렵다.
        //그래서 verify()를 이용하여 실제 실행이 있는지 체크를 한다.
        //times는 실행 횟수, any를 통해 값을 넣는 행위를 임의로 한다.
        PersonDto dto = PersonDto.of("martin", "programming", "판교", LocalDate.now(), "programmer", "010-1111-2222");

        personService.put(dto);

        verify(personRepository, times(1)).save(any(Person.class));
    }
}