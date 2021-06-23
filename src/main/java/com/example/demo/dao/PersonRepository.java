package com.example.demo.dao;

import com.example.demo.entity.Person;
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository <Person, Integer> {

    @Query("SELECT person FROM Dog as dog, Person as person WHERE dog.id = :id AND dog.person = person")
    Person findPersonByDogId(Integer id);
}


