package sk.stuba.fei.uim.oop.assignment3;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //bude ukladana do databazy
@Getter
@Setter
//zaznam databazy
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private int amount;
    private String unit;
    private double price;

}
