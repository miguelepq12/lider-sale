package cl.lider.challenge.lidersale.service;

import cl.lider.challenge.lidersale.entity.product.Product;
import cl.lider.challenge.lidersale.entity.product.ProductBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    @Override
    public Page<Product> getProducts(String text, int page) {

        List<Product> products = new ArrayList<>();
        products.add(new ProductBuilder(1)
                .withBrand("arepera")
                .withDescription("descrption")
                .withPrice(100)
                .withPriceWithDiscount(50)
                .withDiscount(50)
                .withImage("www.lider.cl/catalogo/images/tvIcon.svg")
                .build());

        products.add(new ProductBuilder(1)
                .withBrand("arepera2")
                .withDescription("descrption")
                .withPrice(100)
                .withPriceWithDiscount(50)
                .withDiscount(50)
                .withImage("www.lider.cl/catalogo/images/tvIcon.svg")
                .build());

        products.add(new ProductBuilder(1)
                .withBrand("arepera3")
                .withDescription("descrption")
                .withPrice(100)
                .withPriceWithDiscount(50)
                .withDiscount(50)
                .withImage("www.lider.cl/catalogo/images/tvIcon.svg")
                .build());

        products.add(new ProductBuilder(1)
                .withBrand("arepera4")
                .withDescription("descrption")
                .withPrice(100)
                .withPriceWithDiscount(50)
                .withDiscount(50)
                .withImage("www.lider.cl/catalogo/images/tvIcon.svg")
                .build());

        products.add(new ProductBuilder(1)
                .withBrand("arepera5")
                .withDescription("descrption")
                .withPrice(100)
                .withPriceWithDiscount(50)
                .withDiscount(50)
                .withImage("www.lider.cl/catalogo/images/tvIcon.svg")
                .build());

        products.add(new ProductBuilder(1)
                .withBrand("arepera6")
                .withDescription("descrption")
                .withPrice(100)
                .withPriceWithDiscount(50)
                .withDiscount(50)
                .withImage("www.lider.cl/catalogo/images/tvIcon.svg")
                .build());

        return new PageImpl<>(products, PageRequest.of(1,5),products.size());
    }
}
