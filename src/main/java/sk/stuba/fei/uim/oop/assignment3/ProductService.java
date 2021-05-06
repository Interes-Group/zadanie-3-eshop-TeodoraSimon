package sk.stuba.fei.uim.oop.assignment3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService implements  IProductService{

    public ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository){
        this.repository = repository;
        Product p1 = new Product();
        p1.setName("Smoki");
        p1.setDescription("Grickalica");
        p1.setAmount(100);
        p1.setUnit("gr");
        p1.setPrice(46);
        this.repository.save(p1);

    }


    @Override
    public List<Product> getAll() {
        return this.repository.findAll();
    }
}
