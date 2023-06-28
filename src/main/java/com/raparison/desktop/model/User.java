package com.raparison.desktop.model;

import java.util.Date;

public class User {
    public User(String name, String lastName, Date birthDate, String sexe) {
        this.name = name;
        this.lastName = lastName;
        this. birthDate = birthDate;
        this.sexe = sexe;
    }

    private String name;
    private String lastName;
    private Date birthDate;
    private String sexe;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
}
