package com.example.demo;

import com.example.demo.entity.Person;
import com.example.demo.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    @Qualifier("mapObject1")
    Map<String, String> map;

    @Autowired
    MainService service;

    @RequestMapping("/data")
    @ResponseBody
    public Map<String, String> data() {
        if (map == null) {
            System.out.println("map = null");
            return null;
        }
        if (map.get("key3") == null) {
            map.put("key3", "random str");
        }else {
            map.put("key3", map.get("key3") + '1');
        }
        return map;
    }

    @RequestMapping("/createPerson")
    @ResponseBody
    public void createPerson(@RequestParam("name") String name,
                             @RequestParam("surname") String surname) {
        service.createPerson(name, surname);
    }

    @RequestMapping("/createPersonWithDog")
    @ResponseBody
    public void createPersonWithDog(@RequestParam("name") String name,
                                    @RequestParam("surname") String surname,
                                    @RequestParam("dogName") String dogName) {
        service.createPersonWithDog(name, surname, dogName);
    }

    @RequestMapping("/getPersonById")
    @ResponseBody
    public ResponseEntity<Person> getPersonById(@RequestParam("id") Integer id) {
        try {
            return ResponseEntity.ok(service.getPersonById(id));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping("/getPersonByDogId")
    @ResponseBody
    public Person getPersonByDogId(@RequestParam("dogId") Integer dogId) {
        return service.getPersonByDogId(dogId);
    }
}

