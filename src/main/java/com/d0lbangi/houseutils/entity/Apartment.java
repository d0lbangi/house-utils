package com.d0lbangi.houseutils.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author d0lbangi
 */

@Entity
@Getter
@Setter
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    public String name;

    @Column(nullable = false)
    public String address;

    @Column(nullable = false)
    public String price;


}
