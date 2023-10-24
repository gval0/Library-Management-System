package com.librarySystem.Models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Patron {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String name;

    private String mail;

    private String membershipStatus;

    public Patron() {
    }

    public Patron(Integer id, User user, String name, String mail, String membershipStatus) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.mail = mail;
        this.membershipStatus = membershipStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMembershipStatus() {
        return membershipStatus;
    }

    public void setMembershipStatus(String membershipStatus) {
        this.membershipStatus = membershipStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patron patron = (Patron) o;
        return Objects.equals(id, patron.id) && Objects.equals(user, patron.user) && Objects.equals(name, patron.name) && Objects.equals(mail, patron.mail) && Objects.equals(membershipStatus, patron.membershipStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, name, mail, membershipStatus);
    }

    @Override
    public String toString() {
        return "Patron{" +
                "id=" + id +
                ", user=" + user +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", membershipStatus='" + membershipStatus + '\'' +
                '}';
    }
}
