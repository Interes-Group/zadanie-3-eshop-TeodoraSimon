package sk.stuba.fei.uim.oop.assignment3.shoppinglist;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ShoppingListRequest {

    private long productId;
    private int amount;
}
