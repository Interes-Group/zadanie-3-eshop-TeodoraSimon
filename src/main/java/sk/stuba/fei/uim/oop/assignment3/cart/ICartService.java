package sk.stuba.fei.uim.oop.assignment3.cart;

import sk.stuba.fei.uim.oop.assignment3.product.Product;

import java.util.List;

public interface ICartService {
    List<Cart> getAll();
    Cart createCart(CartResponse response);
    Cart getAllById(Long id);
}
