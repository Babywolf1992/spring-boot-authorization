package com.babywolf.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by babywolf on 17/5/16.
 */
@Entity
@Table(name = "user_")
public class User {

    @Column(name = "username_")
    private String username;

    @Column(name = "password_")
    private String password;

    @Id
    @Column(name = "id_")
    private long id;

    @Column(name = "nickname_")
    private String nickname;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
