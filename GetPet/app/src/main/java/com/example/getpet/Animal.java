package com.example.getpet;

public class Animal {
    private String name, age, gender, size, length, energy, petImage;

    public Animal(String name, String age, String gender, String size, String length, String energy, String petImage) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.size = size;
        this.length = length;
        this.energy = energy;
        this.petImage = petImage;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getSize() {
        return size;
    }

    public String getLength() {
        return length;
    }

    public String getEnergy() {
        return energy;
    }

    public String getPetImage() {
        return petImage;
    }

    public String getAge() {
        return age;
    }

    public Animal(){

    }
}
