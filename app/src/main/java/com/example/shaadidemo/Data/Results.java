package com.example.shaadidemo.Data;

import com.example.shaadidemo.Data.Dob;
import com.example.shaadidemo.Data.Location;
import com.example.shaadidemo.Data.Login;
import com.example.shaadidemo.Data.Name;
import com.example.shaadidemo.Data.Picture;

public class Results {
    private Name name;
    private String gender;
    private Location location;
    private String email;
    private Login login;
    private Dob dob;
    private Picture picture;

    public void setGender(String gender){
        this.gender = gender;
    }
    public String getGender(){
        return this.gender;
    }
    public void setName(Name name){
        this.name = name;
    }
    public Name getName(){
        return this.name;
    }

    public void setLocation(Location location){
        this.location = location;
    }
    public Location getLocation(){
        return this.location;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Login getLogin() {
        return this.login;
    }

    public void setDob(Dob dob) {
        this.dob = dob;
    }

    public Dob getDob() {
        return this.dob;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public Picture getPicture() {
        return this.picture;
    }

}

