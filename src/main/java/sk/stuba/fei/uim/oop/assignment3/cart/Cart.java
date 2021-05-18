package sk.stuba.fei.uim.oop.assignment3.cart;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.product.Product;
import sk.stuba.fei.uim.oop.assignment3.product.ShoppingResponse;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity //bude ukladana do databazy
@Getter
@Setter
@NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ElementCollection
    private List<ShoppingResponse> shoppingList = new ArrayList<>();

    private boolean payed=false;


}
