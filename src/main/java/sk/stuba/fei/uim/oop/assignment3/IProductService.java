package sk.stuba.fei.uim.oop.assignment3;

import java.util.List;

//mame prve interface lebo je to jednoduchsie vymenit pozdejsie
public interface IProductService {
    List<Product> getAll(); // vytvorili sme to preto aby servica vedela vracat zozanm productov
    Product createProduct(ProductRequest request);
}
