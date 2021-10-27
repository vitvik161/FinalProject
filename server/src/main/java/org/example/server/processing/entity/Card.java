package org.example.server.processing.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "CARD")
@NoArgsConstructor
@Getter
@Setter
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String pan;
    private int pin;

    @ManyToOne
    @JoinColumn(name = "accid", nullable = false)
    private Account accid;
}
