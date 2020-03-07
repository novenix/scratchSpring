package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

//request maping se pone el endpoint en el cual va a funcionar
@RequestMapping("api/v1/person")
//restcontroller permite poner endpoints
@RestController
public class PersonController {

    private final PersonService personService;
    //spring inyecta el servicio en la api get, put delete, post
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    //post
    @PostMapping
    //requestbody esta diciendo que el objeto que reciba en post lo va
    //a poner en un Person
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }
    //en el  @GetMapping(path = "{id}") se obtiene el id api/v1/person/34324-213213-321
    @GetMapping(path = "{id}")
    //@PathVariable("id") es para tomar el id que ya tomo de path
    public Person getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonById(id)
                .orElse(null);

    }//en el  @DeleteMapping(path = "{id}") se obtiene el id api/v1/person/34324-213213-321
    @DeleteMapping(path = "{id}")
    //@PathVariable("id") es para tomar el id que ya tomo de path
    public void deletePersonById(@PathVariable("id") UUID id){
        personService.deletePerson(id);
    }
    @PutMapping(path = "{id}")
    //@PathVariable("id") es para tomar el id que ya tomo de path
    //@RequestBody es para tomar informacion del body
    public void updatePerson(@PathVariable("id")UUID id, @RequestBody Person personToUpdate){
        personService.updatePerson(id,personToUpdate);
    }
}
