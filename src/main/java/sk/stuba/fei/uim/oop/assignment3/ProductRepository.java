package sk.stuba.fei.uim.oop.assignment3;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

//ake operacie mozeme vytvorit nad db
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
 List<Product> findAll();//vrati List product
}
