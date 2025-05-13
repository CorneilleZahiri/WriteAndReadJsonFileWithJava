package com.pps.quiz;

import java.util.List;

public class Utilisateur {
    private String nomPrenom;
    private int age;
    private String profession;
    private List<String> diplomes;

    public Utilisateur() {
    }

    public Utilisateur(String nomPrenom, int age, String profession, List<String> diplomes) {
        this.nomPrenom = nomPrenom;
        this.age = age;
        this.profession = profession;
        this.diplomes = diplomes;
    }

    public String getNomPrenom() {
        return nomPrenom;
    }

    public void setNomPrenom(String nomPrenom) {
        this.nomPrenom = nomPrenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public List<String> getDiplomes() {
        return diplomes;
    }

    public void setDiplomes(List<String> diplomes) {
        this.diplomes = diplomes;
    }
}
