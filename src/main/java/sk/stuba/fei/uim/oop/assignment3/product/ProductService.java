package sk.stuba.fei.uim.oop.assignment3.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements  IProductService{

    //ProductService komunikuje z repository, prepojime ho
    public ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository){
        this.repository = repository;
        //pridala som product
        Product p1 = new Product();
        p1.setName("Luk");
        p1.setDescription("povrce");
        p1.setAmount(1000);
        p1.setUnit("gr");
        p1.setPrice(59.99);
        this.repository.save(p1);
        Product p2 = new Product();
        p2.setName("Limun");
        p2.setDescription("voce");
        p2.setAmount(1000);
        p2.setUnit("gr");
        p2.setPrice(149.99);
        this.repository.save(p2);

    }


    @Override
    public List<Product> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Product createProduct(ProductRequest request) {

        Product newProduct = new Product();

        newProduct.setName(request.getName());
        newProduct.setDescription(request.getDescription());
        newProduct.setAmount(request.getAmount());
        newProduct.setUnit(request.getUnit());
        newProduct.setPrice(request.getPrice());


        return this.repository.save(newProduct);


    }

    @Override
    public Product getAllById(Long id) {
        return this.repository.findById(id).orElseThrow();
    }

    @Override
    public Product updateProduct(Long productId,ProductRequest request ) {
        Product productToFind = this.repository.findById(productId).orElseThrow();
        if(request.getDescription() != null) {
            productToFind.setDescription(request.getDescription());
        }
        if(request.getName() != null){
            productToFind.setName(request.getName());
        }
        return this.repository.save(productToFind);
    }

    @Override
    public  void deleteProductById(Long id) {

        this.repository.findById(id).orElseThrow();

        this.repository.deleteById(id);

    }

    public Product getAmountById(Long id) {
        return this.repository.findById(id).orElseThrow();

    }

    @Override
    public Product increaseAmount(Long id, ProductRequest request) {
        Product productToFind = this.repository.findById(id).orElseThrow();
        productToFind.setAmount(productToFind.getAmount()+request.getAmount());
        return this.repository.save(productToFind);
    }

    public Product save(Product p){
        return this.repository.save(p);
    }

}