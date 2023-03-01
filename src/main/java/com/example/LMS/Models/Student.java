package com.example.LMS.Models;

import net.bytebuddy.implementation.bind.MethodDelegationBinder;

import javax.persistence.*;

@Entity
@Table(name = "student_tbl")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(unique = true)
    private String email;

    private int age;

    private String country;
    private String MobNo;

    @OneToOne(mappedBy = "studentVar",cascade = CascadeType.ALL)
    private Card card;

    public Student() {
    }

    public Student(int id, String name, String email, int age, String country,String MobNo, Card card) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.country = country;
        this.card = card;
        this.MobNo=MobNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getMobNo() {
        return MobNo;
    }

    public void setMobNo(String mobNo) {
        MobNo = mobNo;
    }
}
