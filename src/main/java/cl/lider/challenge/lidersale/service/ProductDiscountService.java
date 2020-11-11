package cl.lider.challenge.lidersale.service;

import cl.lider.challenge.lidersale.entity.product.Product;
import org.springframework.data.domain.Page;

public interface ProductDiscountService {
    Page<Product> getProducts(String text,int page, int elementsPage);
    Page<Product> getProductsRepository(String text,int page, int elementsPage);
    Product applyDiscount(Product productWithoutDiscount);
}
