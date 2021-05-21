package sk.stuba.fei.uim.oop.assignment3.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")//URL
public class ProductController {

    @Autowired
    public IProductService service;

    @GetMapping()
    public List<ProductResponse> getAllProducts(){
        return this.service.getAll().stream().map(ProductResponse::new).collect(Collectors.toList());//prechadza cez kazde prvky a zmeni ho na ProductResponse
    }

    @PostMapping()
    public ResponseEntity<ProductResponse> addProduct(@RequestBody  ProductRequest request){
        return new ResponseEntity<>(new ProductResponse(this.service.createProduct(request)), HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ProductResponse getAllProductsById(@PathVariable("id") Long id){
        return new ProductResponse(this.service.getAllById(id));//prechadza cez kazde prvky a zmeni ho na ProductResponse
    }

    @PutMapping("/{id}")
    public ProductResponse updateProduct(@PathVariable("id") Long productId, @RequestBody ProductRequest request){
        return new ProductResponse(this.service.updateProduct(productId, request));
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long productId){
        this.service.deleteProductById(productId);
    }

    @GetMapping("/{id}/amount")
    public AmountResponse getAmountById(@PathVariable("id") Long id){
        return new AmountResponse(this.service.getAllById(id));//prechadza cez kazde prvky a zmeni ho na ProductResponse
    }

    @PostMapping("/{id}/amount")
    public AmountResponse increaseProductAmount(@PathVariable("id") Long id,@RequestBody ProductRequest request){
        return new AmountResponse(this.service.increaseAmount(id, request));
    }

}
