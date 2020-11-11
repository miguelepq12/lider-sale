package cl.lider.challenge.lidersale.service;

import cl.lider.challenge.lidersale.entity.product.Product;
import cl.lider.challenge.lidersale.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    ProductRepository repository;

    @Override
    public Page<Product> getProducts(String text, int page) {
      return repository.findByIdIsOrBrandContainingOrDescriptionContaining(0,
                text,text,PageRequest.of(page,10));
    }
}
