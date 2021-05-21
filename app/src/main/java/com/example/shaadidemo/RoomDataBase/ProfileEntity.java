package com.example.shaadidemo.RoomDataBase;

import java.util.Objects;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "profile")
public class ProfileEntity {

    @PrimaryKey(autoGenerate = true)
    private int user_id;
    @ColumnInfo
    private String name;
    @ColumnInfo
    private String gender;
    @ColumnInfo
    private String location;
    @ColumnInfo
    private String email;
    @ColumnInfo
    private String age;
    @ColumnInfo
    private String picture;
    @ColumnInfo
    private String login_uuid;
    @ColumnInfo
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getLogin_uuid() {
        return login_uuid;
    }

    public void setLogin_uuid(String login_uuid) {
        this.login_uuid = login_uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProfileEntity)) return false;
        ProfileEntity that = (ProfileEntity) o;
        return Objects.equals(getUser_id(), that.getUser_id()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getGender(), that.getGender()) &&
                Objects.equals(getLocation(), that.getLocation()) &&
                Objects.equals(getEmail(), that.getEmail()) &&
                Objects.equals(getAge(), that.getAge()) &&
                Objects.equals(getPicture(), that.getPicture()) &&
                Objects.equals(getLogin_uuid(), that.getLogin_uuid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser_id(), getName(), getGender(), getLocation(),
                getEmail(), getAge(), getPicture(), getLogin_uuid());
    }

    @Override
    public String toString() {
        return "ProfileEntity{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", location='" + location + '\'' +
                ", email='" + email + '\'' +
                ", age='" + age + '\'' +
                ", picture='" + picture + '\'' +
                ", login_uuid='" + login_uuid + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}