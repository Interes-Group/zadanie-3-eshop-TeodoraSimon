package sk.stuba.fei.uim.oop.assignment3.cart;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.shoppinglist.ShoppingList;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;


@Entity //bude ukladana do databazy
@Getter
@Setter
@NoArgsConstructor
@Table(name="carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /*@ElementCollection
    private List<ShoppingResponse> shoppingList = new ArrayList<>();*/

    @OneToMany(mappedBy = "cart")
    private List<ShoppingList> shoppingList = new ArrayList<ShoppingList>();

    private boolean payed=false;


}
