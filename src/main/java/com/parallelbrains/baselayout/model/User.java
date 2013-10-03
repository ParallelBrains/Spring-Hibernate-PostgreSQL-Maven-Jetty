package com.parallelbrains.baselayout.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "project_user")
public class User extends BaseModel {

    @Column
    private String username;

    @Column
    private String password;

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
}
