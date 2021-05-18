package sk.stuba.fei.uim.oop.assignment3.shoppinglist;


import lombok.Getter;
import lombok.NoArgsConstructor;
import sk.stuba.fei.uim.oop.assignment3.cart.Cart;
import sk.stuba.fei.uim.oop.assignment3.product.Product;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class ShoppingList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne
    private Cart cart;

    @ManyToOne
    private Product product;

    private int amount;

    public ShoppingList(Cart cart, Product product, int amount) {
        this.cart = cart;
        this.product = product;
        this.amount = amount;
    }


}
