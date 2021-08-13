package com.example.superheroesguide;

public class items {
    private String imageurl,name;
    int intelligence,strength,speed,durability,power,combat;
    String gender,race,height,weight,eyecolor,haircolor,fullname,first_appearance,publisher,birth_place,occupation;

    public items(String imageurl, String name, int intelligence,int strength,int speed,int durability,int power,int combat,String gender,String race,String height,String weight,String eyecolor,String haircolor,String fullname,String first_appearance,String publisher,String birth_place,String occupation){
        this.imageurl=imageurl;
        this.name=name;
        this.intelligence=intelligence;
        this.strength=strength;
        this.speed=speed;
        this.durability=durability;
        this.power=power;
        this.combat=combat;
        this.gender=gender;
        this.race=race;
        this.height=height;
        this.weight=weight;
        this.eyecolor=eyecolor;
        this.haircolor=haircolor;
        this.fullname=fullname;
        this.first_appearance=first_appearance;
        this.publisher=publisher;
        this.birth_place=birth_place;
        this.occupation=occupation;


    }

    public String getImageurl() {
        return imageurl;
    }
    public String getId() {
        return name;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDurability() {
        return durability;
    }

    public int getPower() {
        return power;
    }

    public int getCombat() {
        return combat;
    }

    public String getGender() {
        return gender;
    }

    public String getRace() {
        return race;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public String getEyecolor() {
        return eyecolor;
    }

    public String getHaircolor() {
        return haircolor;
    }

    public String getFullname() {
        return fullname;
    }

    public String getFirst_appearance() {
        return first_appearance;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getBirth_place() {
        return birth_place;
    }

    public String getOccupation() {
        return occupation;
    }
}
