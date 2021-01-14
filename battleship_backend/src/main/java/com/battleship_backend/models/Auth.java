package com.battleship_backend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Auth")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Auth {

    @Id
    private int userId;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @OneToOne
    @JoinColumn
    @MapsId
    private User user;

    public Auth(String username, String password){
        this.username = username;
        this.password = password;
    }
}
