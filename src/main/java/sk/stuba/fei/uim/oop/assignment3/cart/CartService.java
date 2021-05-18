package sk.stuba.fei.uim.oop.assignment3.cart;

import antlr.debug.ParserTokenAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.exceptions.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.IProductService;
import sk.stuba.fei.uim.oop.assignment3.product.Product;
import sk.stuba.fei.uim.oop.assignment3.product.ShoppingResponse;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartService implements ICartService{

    private CartRepository repository;

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
    public Cart createCart(CartResponse cartResponse) {

        Cart newC = new Cart();
        newC.setId(cartResponse.getId());
        newC.setShoppingList(cartResponse.getShoppingList());
        return this.repository.save(newC);

    }

    @Override
    public Cart getAllById(Long id) {
        return this.repository.findById(id).orElseThrow();
    }
/*
    public Cart addProductToCart(long cardId, long productId){
        Optional<Cart> cartOpt = this.repository.findById(cardId);
        Cart cart = cartOpt.orElseThrow(NotFoundException::new);

        Product product = this.productService.getAllById(productId);

        ShoppingResponse resp = new ShoppingResponse();
    }*/
/*
    @Override
    public Animal addPersonToAnimal(long animalId, long personId) {
        Optional<Animal> animalOpt = this.repository.findById(animalId);
        Animal animal = animalOpt.orElseThrow(NotFoundException::new);

        Person person = this.personService.getById(personId);

        Payment payment = new Payment(animal, person, 10);

        payment = this.paymentRepository.save(payment);

        person.getPayments().add(payment);
        animal.getPayments().add(payment);

        this.personService.save(person);
        return this.repository.save(animal);
    }*/

}
