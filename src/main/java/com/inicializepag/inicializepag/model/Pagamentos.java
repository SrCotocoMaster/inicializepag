package com.inicializepag.inicializepag.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
public class Pagamentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String forma;
}
