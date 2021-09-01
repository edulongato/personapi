package com.edulongato.personapi.service;

import com.edulongato.personapi.dto.MessageResponseDTO;
import com.edulongato.personapi.dto.request.PersonDTO;
import com.edulongato.personapi.entity.Person;
import com.edulongato.personapi.mapper.PersonMapper;
import com.edulongato.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;



    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public MessageResponseDTO createPerson(PersonDTO personDTO){

        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created personDTO with ID" + savedPerson.getId())
                .build();
    }
}
