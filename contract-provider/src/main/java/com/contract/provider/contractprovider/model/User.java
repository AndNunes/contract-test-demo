package com.contract.provider.contractprovider.model;

public class User {

    private String name;
    private String cpf;
    private String profession;

    public User(String name, String cpf, String profession, int age) {
        this.name = name;
        this.cpf = cpf;
        this.profession = profession;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

}
