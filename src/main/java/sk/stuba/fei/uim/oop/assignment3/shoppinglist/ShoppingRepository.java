package sk.stuba.fei.uim.oop.assignment3.shoppinglist;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.List;
import java.util.Optional;


@Repository
public interface ShoppingRepository extends CrudRepository<ShoppingList, Long> {
    List<ShoppingList> findAll();//vrati List product
    Optional<ShoppingList> findById(Long id);
}
