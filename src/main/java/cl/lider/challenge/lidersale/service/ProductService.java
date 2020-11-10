package cl.lider.challenge.lidersale.service;

import cl.lider.challenge.lidersale.entity.product.Product;
import org.springframework.data.domain.Page;

public interface ProductService {
    Page<Product> getProducts(String text,int page);
}
