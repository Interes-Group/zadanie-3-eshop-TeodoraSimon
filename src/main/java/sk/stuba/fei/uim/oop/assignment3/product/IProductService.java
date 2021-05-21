package sk.stuba.fei.uim.oop.assignment3.product;

import java.util.List;


public interface IProductService {
    List<Product> getAll();
    Product createProduct(ProductRequest request);
    Product getAllById(Long id);
    Product updateProduct(Long productId,ProductRequest request);
    void deleteProductById(Long id);
    // Product getAmountById(Long id);
    //Product save(Product p);
    Product increaseAmount(Long id, ProductRequest request);
    void decreaseAmount(Long id, int amount);
    Product getById(long productId);
}
