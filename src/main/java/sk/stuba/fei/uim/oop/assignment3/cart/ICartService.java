package sk.stuba.fei.uim.oop.assignment3.cart;

import sk.stuba.fei.uim.oop.assignment3.product.Product;
import sk.stuba.fei.uim.oop.assignment3.shoppinglist.ShoppingListRequest;

import java.util.List;

public interface ICartService {
    List<Cart> getAll();
    Cart createCart();
    Cart getAllById(Long id);
    void deleteCartById(Long id);
    Cart addProductToCart(long productId, long cardId, long amount);
}
