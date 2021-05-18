package sk.stuba.fei.uim.oop.assignment3.cart;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.product.ProductRequest;
import sk.stuba.fei.uim.oop.assignment3.product.ProductResponse;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService service;

    @GetMapping()
    public List<CartResponse> getAllCart(){
        return this.service.getAll().stream().map(CartResponse::new).collect(Collectors.toList());//prechadza cez kazde prvky a zmeni ho na ProductResponse
    }

    @PostMapping()
    public ResponseEntity<CartResponse> addCart(){
        return new ResponseEntity<>(new CartResponse(this.service.createCart()), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public CartResponse getAllCartsById(@PathVariable("id") Long id){
        return new CartResponse(this.service.getAllById(id));//prechadza cez kazde prvky a zmeni ho na ProductResponse
    }

    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable("id") Long cartId){
        this.service.deleteCartById(cartId);
    }






}
