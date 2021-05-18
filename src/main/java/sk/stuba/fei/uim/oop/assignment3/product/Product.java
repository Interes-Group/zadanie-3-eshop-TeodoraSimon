package sk.stuba.fei.uim.oop.assignment3.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.cart.Cart;
import sk.stuba.fei.uim.oop.assignment3.shoppinglist.ShoppingList;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity //bude ukladana do databazy
@Getter
@Setter
@NoArgsConstructor
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


    @Setter
    @OneToMany
    private List<ShoppingList> payments = new ArrayList<>();
}
