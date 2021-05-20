package sk.stuba.fei.uim.oop.assignment3.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sk.stuba.fei.uim.oop.assignment3.exceptions.BadRequestException;
import sk.stuba.fei.uim.oop.assignment3.exceptions.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.IProductService;
import sk.stuba.fei.uim.oop.assignment3.product.Product;
import sk.stuba.fei.uim.oop.assignment3.shoppinglist.ShoppingList;
import sk.stuba.fei.uim.oop.assignment3.shoppinglist.ShoppingListRequest;
import sk.stuba.fei.uim.oop.assignment3.shoppinglist.ShoppingRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CartService implements ICartService{
    @Autowired
    private CartRepository repository;

    @Autowired
    private ShoppingRepository shoppingRepository;

    @Autowired
    private IProductService productService;

    @Autowired
    public CartService(CartRepository repository) {
        this.repository = repository;
       /* Cart c1 = new Cart(false);
        Cart c2 = new Cart(true);
        this.repository.save(c1);
        this.repository.save(c2);*/
    }

    @Override
    public List<Cart> getAll() {
        return this.repository.findAll();
    }


    @Override
    public Cart createCart() {

        Cart newC = new Cart();
        newC.getShoppingList().clear();
        newC.setPayed(false);
        return this.repository.save(newC);

    }

    @Override
    public Cart getAllById(Long id) {
        return this.repository.findById(id).orElseThrow();
    }

    @Override
    public  void deleteCartById(Long id) {

        this.repository.findById(id).orElseThrow();

        this.repository.deleteById(id);

    }

    public Cart addProductToCart( long productId, long cardId, long amount){
        Cart cart = this.repository.findById(cardId).orElseThrow();
        Product product = this.productService.getById(productId);

        //az je zaplatene vrat error
        if (cart.isPayed()) {
            throw new BadRequestException();
        }

        //az nema tolko kusu na sklade vrat error
        if (product.getAmount() < amount) {
            throw new BadRequestException();
        }

        this.productService.decreaseAmount(productId, (int)amount);

        ShoppingList  shoppingList = null;
        for (ShoppingList sl : cart.getShoppingList()) {
            if(sl.getProductId() == productId) {
                shoppingList = sl;
            }
        }


        if(shoppingList == null) {
            shoppingList = new ShoppingList();
            shoppingList.setAmount(amount);
            shoppingList.setProductId(productId);
            shoppingList.setCart(cart);

            cart.getShoppingList().add(shoppingList);
        }
        else {
            //az uz je v shoppinglist dodaj dalsi pocet
            shoppingList.setAmount(shoppingList.getAmount() + amount);
        }



        this.shoppingRepository.save(shoppingList);
        this.repository.save(cart);
        return cart;
    }

    public double payForCart(long cardId) {
        Cart cart = this.repository.findById(cardId).orElseThrow();
        if(cart.isPayed()) {
            throw new BadRequestException();
        }else {
            cart.setPayed(true);
        }

        Double price = 0d;
        for (ShoppingList sl : cart.getShoppingList()) {
            Product product = this.productService.getById(sl.getProductId());
            price += product.getPrice() * sl.getAmount();
        }

        this.repository.save(cart);
        return price;
    }

}
