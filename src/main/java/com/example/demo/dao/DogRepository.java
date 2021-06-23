package com.example.demo.dao;

import com.example.demo.entity.Dog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends CrudRepository <Dog, Integer> {
}
