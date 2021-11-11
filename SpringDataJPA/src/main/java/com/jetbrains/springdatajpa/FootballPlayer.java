package com.jetbrains.springdatajpa;

import javax.persistence.*;


@Entity
public class FootballPlayer {


    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    private int age;

    private char gender;

    private String nationality;

    private String teamPlayFor;

    private int number;





    public FootballPlayer(String firstName, String lastName, int age, char gender,String nationality, String teamPlayFor,int number){

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.nationality = nationality;
        this.teamPlayFor = teamPlayFor;
        this.number = number;
    }

    public FootballPlayer(){

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getTeamPlayFor() {
        return teamPlayFor;
    }

    public void setTeamPlayFor(String teamPlayFor) {
        this.teamPlayFor = teamPlayFor;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public static FootballPlayer create(String name, String dept) {
        FootballPlayer employee = new FootballPlayer();
        employee.setFirstName(name);
        employee.setLastName(dept);
        return employee;
    }

    @Override
    public String toString() {
        return "FootballPlayer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", nationality='" + nationality + '\'' +
                ", teamPlayFor='" + teamPlayFor + '\'' +
                ", number=" + number +
                '}';
    }
}
