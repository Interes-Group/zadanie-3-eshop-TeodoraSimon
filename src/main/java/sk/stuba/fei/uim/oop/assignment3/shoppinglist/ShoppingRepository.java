package sk.stuba.fei.uim.oop.assignment3.shoppinglist;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;



@Repository
public interface ShoppingRepository extends CrudRepository<ShoppingList, Long> {

}
