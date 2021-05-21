package sk.stuba.fei.uim.oop.assignment3.cart;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.shoppinglist.ShoppingList;
import sk.stuba.fei.uim.oop.assignment3.shoppinglist.ShoppingResponse;

import java.util.ArrayList;
import java.util.List;
@Getter
public class CartResponse {


    private Long id;
    private List<ShoppingResponse> shoppingList;

    private boolean payed;

    public CartResponse(Cart c) {
        shoppingList = new ArrayList<ShoppingResponse>();
        this.id = c.getId();
        for(ShoppingList sL : c.getShoppingList()){
            shoppingList.add(new ShoppingResponse((Long)sL.getProductId() , sL.getAmount()));
        }
        this.payed = c.isPayed();
    }
}
