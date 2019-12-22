package com.genil.learning.minisocialsvc.data;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

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
    @ManyToOne
    @JoinColumn(name = "type_id")
    @JsonIgnore
    private CarType carType; // Sports / Luxury / Economy
    private String name;
}
