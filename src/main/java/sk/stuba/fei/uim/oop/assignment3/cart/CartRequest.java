package sk.stuba.fei.uim.oop.assignment3.cart;


import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.product.Product;
import sk.stuba.fei.uim.oop.assignment3.product.ShoppingResponse;

import java.util.List;

@Setter
@Getter
public class CartRequest {

    private Long id;
    private List<ShoppingResponse> product;
    private boolean payed;
}
