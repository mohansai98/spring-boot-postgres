package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Person;
import com.example.repository.PersonRepository;

@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/persons")
    public List<Person> getAllPersons(){
        return personRepository.findAll();
    }

    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable int id){
        return personRepository.findById(id).get();
    }

    @PostMapping("/persons")
    public String addPersons(@RequestBody List<Person> persons){
        personRepository.saveAll(persons);
        return "Saved";
    }

    @DeleteMapping("/person/{id}")
    public String deletePerson(@PathVariable int id){
        Person person = new Person(id, null, null);
        personRepository.delete(person);
        return "Deleted";
    }
    
}
