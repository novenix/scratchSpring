package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//definir operaciones permitidas para los que quieran implementar la interfaz
public interface PersonDao {
    //insertar una persona
    int insertPerson(UUID id, Person person);
    default int insertPerson(Person person){
        UUID id=UUID.randomUUID();
        //id se hace aleatorio
        return insertPerson(id,person);
    }
    //obtener todas las personas
    List<Person> selectAllPeople();

    //obtener una persona en especifico
    Optional<Person> selectPersonById(UUID id);
    //borrar persona
    int deletePersonById(UUID id);

    //actualizar persona
    int updatePersonById(UUID id,Person person);
}
