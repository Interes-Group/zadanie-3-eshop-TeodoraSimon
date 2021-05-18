package sk.stuba.fei.uim.oop.assignment3.cart;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.shoppinglist.ShoppingList;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CartResponse {

    private Long id;
    private List<ShoppingList> shoppingList = new ArrayList<>();
    //private List<ShoppingResponse> shoppingList;

    private boolean payed;

    public CartResponse(Cart c) {
        this.id = c.getId();
        this.shoppingList = c.getShoppingList();
        this.payed = c.isPayed();
    }
}
