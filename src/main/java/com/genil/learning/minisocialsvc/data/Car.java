package com.genil.learning.minisocialsvc.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.genil.learning.minisocialsvc.tms.utils.ValidInvoice;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * Created by Antony Genil Gregory on 12/18/2019 1:11 PM
 * For project : mini-social-svc
 **/
@Entity(name = "car")
@Data
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Car {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private CarType carType; // Sports / Luxury / Economy
    @NotBlank(message = "Car Name Cannot be blank")
    private String name;
    @NotBlank(message = "Every car needs an owner !")
    private String ownerName;

    @ValidInvoice(message = "Invoice number should start with IN !!!!")
    private String invoiceNumber;
    @Transient
    @NotBlank(message = "Owners country can't be null")
    private String ownersCountry;
}
