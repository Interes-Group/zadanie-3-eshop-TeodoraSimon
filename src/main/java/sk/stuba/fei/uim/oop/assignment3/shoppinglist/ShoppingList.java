package sk.stuba.fei.uim.oop.assignment3.shoppinglist;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.cart.Cart;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="ShoppingLists")
public class ShoppingList {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="cart_id")
    private Cart cart;

    private long productId;
    private long amount;

}
