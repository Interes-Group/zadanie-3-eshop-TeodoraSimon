package sk.stuba.fei.uim.oop.assignment3.product;

import lombok.Getter;

@Getter //na vsetky atributi
public class ProductResponse {

    private Long id;
    private String name;
    private String description;
    private int amount;
    private String unit;
    private double price;

    //private Long cartId;

    public ProductResponse(Product p) {
        if(p==null){
            return;
        }
        this.id = p.getId();
        this.name = p.getName();
        this.description = p.getDescription();
        this.amount = p.getAmount();
        this.unit = p.getUnit();
        this.price = p.getPrice();
      //  this.cartId = p.getCart() != null ? p.getCart().getId() : null;
    }



}
