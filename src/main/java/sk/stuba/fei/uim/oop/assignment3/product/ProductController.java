package sk.stuba.fei.uim.oop.assignment3.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
//vytvorime to na to aby sme vedeli z app komunikovat
@RestController
@RequestMapping("/product")//URL
public class ProductController {

    //prepojili sme sa z controllerom
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

    //ma vratit iba objekt
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
        return new AmountResponse(this.service.getAmountById(id));//prechadza cez kazde prvky a zmeni ho na ProductResponse
    }

    @PostMapping("/{id}/amount")
    public AmountResponse increaseProductAmount(@PathVariable("id") Long id,@RequestBody ProductRequest request){
        return new AmountResponse(this.service.increaseAmount(id, request));
    }












}
