package sk.stuba.fei.uim.oop.assignment3.product;

import java.util.List;

//mame prve interface lebo je to jednoduchsie vymenit pozdejsie
public interface IProductService {
    List<Product> getAll(); // vytvorili sme to preto aby servica vedela vracat zozanm productov
    Product createProduct(ProductRequest request);
    Product getAllById(Long id);
    Product updateProduct(Long productId,ProductRequest request);
    void deleteProductById(Long id);
    Product getAmountById(Long id);

    Product increaseAmount(Long id, ProductRequest request);


}
