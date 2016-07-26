package com.reflection.person.impl;

import com.reflection.model.Person;
import com.reflection.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by mesut on 27.07.2016.
 */
@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    /**
     * Save Person Method
     * @param person {@link Person} instance
     * @param builder {@link UriComponentsBuilder} instance
     * @return ResponseEntity
     */
    @RequestMapping(value = "/person/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createPerson(@RequestBody Person person, UriComponentsBuilder builder) {
        personService.save(person);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/person/findById/{id}").buildAndExpand(person.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


}
