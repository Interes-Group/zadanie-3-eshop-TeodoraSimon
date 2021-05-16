package sk.stuba.fei.uim.oop.assignment3;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

//ake operacie mozeme vytvorit nad db
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
 List<Product> findAll();//vrati List product
 Optional<Product> findById(Long id);
 List<Product> deleteProductById(Long id);//vrati List product
}
