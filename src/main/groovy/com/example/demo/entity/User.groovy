package com.example.demo.entity

import org.springframework.stereotype.Component

@Component
class User {
    def name
    def id
    def birthday
    def email

    User(name, id, birthday, email) {
        this.name = name
        this.id = id
        this.birthday = birthday
        this.email = email
    }

    def getName() {
        return name
    }

    void setName(name) {
        this.name = name
    }

    def getId() {
        return id
    }

    void setId(id) {
        this.id = id
    }

    def getBirthday() {
        return birthday
    }

    void setBirthday(birthday) {
        this.birthday = birthday
    }

    def getEmail() {
        return email
    }

    void setEmail(email) {
        this.email = email
    }
}
