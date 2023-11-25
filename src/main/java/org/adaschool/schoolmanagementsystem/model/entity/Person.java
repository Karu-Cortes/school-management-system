package org.adaschool.schoolmanagementsystem.model.entity;

import java.time.LocalDate;

public class Person {
    //Atributos
    private int id;
    private String name;
    private String firstName;
    private LocalDate dateOfBirth;

    //Constructor


    public Person(int id, String name, String firstName, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
    }


    //getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}

