package com.example.demo.service;

import com.example.demo.dao.DogRepository;
import com.example.demo.dao.PersonRepository;
import com.example.demo.entity.Dog;
import com.example.demo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;

@Service
public class MainService {
    @Autowired
    DogRepository dogRepository;

    @Autowired
    PersonRepository personRepository;

    @Transactional
    public void createPerson(String name, String surname) {
        Person person = new Person();
        person.setName(name);
        person.setSurname(surname);
        personRepository.save(person);
    }

    @Transactional
    public void createPersonWithDog(String name, String surname, String dogName) {
        Person person = new Person();
        person.setName(name);
        person.setSurname(surname);
        Dog dog = new Dog(dogName);
        person.setDogs(Arrays.asList(dog));
        dogRepository.save(dog);
        personRepository.save(person);
    }

    public Person getPersonById(Integer id) {
        return personRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found id = " + id));
    }

    public Person getPersonByDogId(Integer dogId) {
        return personRepository.findPersonByDogId(dogId);
    }
}
