package sk.stuba.fei.uim.oop.assignment3.shoppinglist;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.product.Product;

@Setter
@Getter
public class ShoppingListRequest {

    private long productId;
    private int amount;
}
