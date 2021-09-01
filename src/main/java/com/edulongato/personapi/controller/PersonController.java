package com.edulongato.personapi.controller;

import com.edulongato.personapi.dto.MessageResponseDTO;
import com.edulongato.personapi.dto.request.PersonDTO;
import com.edulongato.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody PersonDTO personDTO){
        return personService.createPerson(personDTO);
    }



}
