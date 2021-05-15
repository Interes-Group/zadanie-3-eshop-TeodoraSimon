package sk.stuba.fei.uim.oop.assignment3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
}
