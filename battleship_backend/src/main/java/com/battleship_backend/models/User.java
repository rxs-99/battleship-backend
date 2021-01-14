package com.battleship_backend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class User {

    @Id
    @GeneratedValue(/*generator = "user_id_seq",/**/ strategy = GenerationType.IDENTITY)
    //@SequenceGenerator(allocationSize = 1, name = "user_id_seq", sequenceName = "user_id_seq")
    @Column(name = "id")
    private int id;
    @Column
    private int totalGames;
    @Column
    private int totalWins;
    @Column
    private int totalLosses;
}
