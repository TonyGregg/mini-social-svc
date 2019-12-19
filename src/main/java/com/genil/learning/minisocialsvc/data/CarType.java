package com.genil.learning.minisocialsvc.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Antony Genil on 12/18/19 at 14 20 for mini-social-svc
 **/
@Entity(name = "car_type")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CarType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany( mappedBy = "carType")
    private List<Car> cars;
    @Column(name = "price_min")
    private Long priceMin;
    @Column(name = "price_max")
    private Long priceMax;

    private String category;

    @Override
    public String toString() {
        return "CarType{" +
                "id=" + id +
                ", priceMin=" + priceMin +
                ", priceMax=" + priceMax +
                ", category=" + category +
                '}';
    }
}
