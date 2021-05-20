package sk.stuba.fei.uim.oop.assignment3.shoppinglist;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class ShoppingResponse {

    private Long productId;
    private Long amount;

    public ShoppingResponse(Long productId , Long amount){
        this.productId = productId;
        this.amount = amount;
    }





}
