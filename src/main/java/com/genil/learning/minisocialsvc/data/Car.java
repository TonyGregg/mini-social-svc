package com.genil.learning.minisocialsvc.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Antony Genil Gregory on 12/18/2019 1:11 PM
 * For project : mini-social-svc
 **/
@Entity(name = "car")
@Data
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String type; // Sports / Luxury / Economy
    private String name;
}
