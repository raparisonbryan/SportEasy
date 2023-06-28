package com.raparison.activity.model;

import java.util.Date;

public class User {
    public User(String name, String lastName, Date birthDate, boolean sexe) {
        this.name = name;
        this.lastName = lastName;
        this. birthDate = birthDate;
        this.sexe = sexe;
    }

    private String name;
    private String lastName;
    private Date birthDate;
    private boolean sexe;

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

    public boolean isSexe() {
        return sexe;
    }

    public void setSexe(boolean sexe) {
        this.sexe = sexe;
    }
}
