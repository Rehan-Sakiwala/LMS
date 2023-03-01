package com.example.LMS.Models;

import com.example.LMS.Enums.CardStatus;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "card_tbl")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;

    @OneToOne
    @JoinColumn
    private Student studentVar;

    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    List<Book> booksIssued=new ArrayList<>();

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private List<Transactions> listOfTransaction=new ArrayList<>();

    public Card() {
    }

    public Card(int id, Date createdOn, Date updatedOn, CardStatus cardStatus, Student studentVar,List booksIssued) {
        this.id = id;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.cardStatus = cardStatus;
        this.booksIssued=booksIssued;
        this.studentVar = studentVar;
    }

    //Getters and Setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public Student getStudentVar() {
        return studentVar;
    }

    public void setStudentVar(Student studentVar) {
        this.studentVar = studentVar;
    }

    public List<Book> getBooksIssued() {
        return booksIssued;
    }

    public void setBooksIssued(List<Book> booksIssued) {
        this.booksIssued = booksIssued;
    }

    public List<Transactions> getListOfTransaction() {
        return listOfTransaction;
    }

    public void setListOfTransaction(List<Transactions> listOfTransaction) {
        this.listOfTransaction = listOfTransaction;
    }
}
