package sk.stuba.fei.uim.oop.assignment3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
//vytvorime to na to aby sme vedeli z app komunikovat
@RestController
@RequestMapping("/product")//URL
public class TestController {

    //prepojili sme sa z controllerom
    @Autowired
    public IProductService service;


    @GetMapping()
    public List<ProductResponse> getAllProducts(){
        return this.service.getAll().stream().map(ProductResponse::new).collect(Collectors.toList());//prechadza cez kazde prvky a zmeni ho na ProductResponse
    }

    @PostMapping()
    public ProductResponse addProduct(@RequestBody  ProductRequest request){
        return new ProductResponse(this.service.createProduct(request));
    }

    //ma vratit iba objekt
    @GetMapping("/{id}")
    public List<ProductResponse> getAllProductsById(@PathVariable("id") Long id){
        return this.service.getAllById(id).stream().map(ProductResponse::new).collect(Collectors.toList());//prechadza cez kazde prvky a zmeni ho na ProductResponse
    }

    @PutMapping("/{id}")
   /* @PathVariable(value = "id") UUID id,
    @RequestBody VehicleUpdateDTO vehicleUpdateDTO*/
    public ProductResponse updateProduct(@PathVariable("id") Long productId, @RequestBody ProductRequest request){
      return new ProductResponse(this.service.updateProduct(productId, request));
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long productId){
        this.service.deleteProductById(productId);
    }












}
