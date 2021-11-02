package org.example.server.processing.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ACCOUNT")
@NoArgsConstructor
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int balance;

    @ManyToOne
    @JoinColumn(name = "custid", nullable = false)
    private Cust custid;

    @OneToMany(mappedBy = "accid")
    private Set<Card> cards;

}
