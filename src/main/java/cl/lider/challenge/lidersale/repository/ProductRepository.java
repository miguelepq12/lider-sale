package cl.lider.challenge.lidersale.repository;

import cl.lider.challenge.lidersale.entity.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

    Page<Product> findByIdIsOrBrandContainingOrDescriptionContaining(long id, String brand,
                                                                     String description,
                                                                     Pageable pageable);
}
