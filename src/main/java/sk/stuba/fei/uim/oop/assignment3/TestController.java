package sk.stuba.fei.uim.oop.assignment3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class TestController {
  /*  @GetMapping
    public String hello(){
        return "Lets go this!";
    }*/
    @Autowired
    public IProductService service;

    @GetMapping()
    public List<ProductResponse> getAllProducts(){
        return this.service.getAll().stream().map(product -> new ProductResponse(product)).collect(Collectors.toList());
    }
}
