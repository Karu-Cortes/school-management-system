package org.adaschool.schoolmanagementsystem.model.entity;

import org.adaschool.schoolmanagementsystem.model.enums.Version;

public class Course {
    //atributos
    private int id;
    private String name;
    private String description;
    private int credits;
    private Version version;

    //constructor


    public Course(int id, String name, String description, int credits, Version version) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.credits = credits;
        this.version = version;
    }

    //getters and setters


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }
}


