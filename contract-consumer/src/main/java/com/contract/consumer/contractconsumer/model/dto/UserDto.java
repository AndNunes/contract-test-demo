package com.contract.consumer.contractconsumer.model.dto;

public class UserDto {

    private String name;
    private String profession;
    private String email;
    private int age;

    public UserDto(String name, String profession, String email, int age) {
        this.name = name;
        this.profession = profession;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
