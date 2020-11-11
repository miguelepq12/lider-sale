package cl.lider.challenge.lidersale.service;

import cl.lider.challenge.lidersale.entity.product.Product;
import cl.lider.challenge.lidersale.entity.product.ProductBuilder;
import cl.lider.challenge.lidersale.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
class ProductPalindromoServiceTest {
    final String text = "arep";
    final String textNumber = "3";
    final int page = 1;
    final int numberPages = 10;

    @InjectMocks
    ProductPalindromoService service = new ProductPalindromoService();
    @Mock
    ProductRepository productRepository;

    static Page<Product> productsPage;
    static List<Product> products;


    @BeforeAll
    static void beforeAll() {
        products = new ArrayList<>();
        products.add(new ProductBuilder(1)
                .withBrand("arepera")
                .withDescription("descrption")
                .withPrice(100)
                .withPriceWithDiscount(50)
                .withDiscount(50)
                .withImage("www.lider.cl/catalogo/images/tvIcon.svg")
                .build());

        products.add(new ProductBuilder(2)
                .withBrand("hola")
                .withDescription("arepera")
                .withPrice(100)
                .withPriceWithDiscount(50)
                .withDiscount(50)
                .withImage("www.lider.cl/catalogo/images/tvIcon.svg")
                .build());

        products.add(new ProductBuilder(3)
                .withBrand("a")
                .withDescription("f")
                .withPrice(100)
                .withPriceWithDiscount(50)
                .withDiscount(50)
                .withImage("www.lider.cl/catalogo/images/tvIcon.svg")
                .build());

    }
    @Test
    void getAllProductsTest() {
        productsPage = new PageImpl<>(products);

        Mockito.when(productRepository.findByBrandContainingOrDescriptionContaining(
                "", "", PageRequest.of(page-1, numberPages)))
                .thenReturn(productsPage);

        Page<Product> productPage = service.getProducts("", page, numberPages);

        Assertions.assertEquals(3, productPage.getTotalElements());
    }

    @Test
    void getProductsForBrandDescriptionTest() {
        productsPage = new PageImpl<>(products.stream()
                .filter(product -> product.getBrand().contains(text) ||
                        product.getDescription().contains(text))
                .collect(Collectors.toList()));

        Mockito.when(productRepository.findByBrandContainingOrDescriptionContaining(
                text, text, PageRequest.of(page, numberPages)))
                .thenReturn(productsPage);

        Page<Product> productPage = service.getProducts(text, page, numberPages);

        Assertions.assertEquals(2, productPage.getTotalElements());
    }

    @Test
    void getProductsForId() {
        productsPage = new PageImpl<>(products.stream()
                .filter(product -> product.getId() == Long.parseLong(textNumber))
                .collect(Collectors.toList()));

        Mockito.when(productRepository.findById(Long.parseLong(textNumber),
                PageRequest.of(page, numberPages)))
                .thenReturn(productsPage);

        Page<Product> productPage = service.getProducts(textNumber, page-1, numberPages);

        Assertions.assertEquals(1, productPage.getTotalElements());
    }

    @Test
    void getProductPalindromoWithDiscount() {
        productsPage = new PageImpl<>(products.stream()
                .filter(product -> product.getBrand().contains(text) ||
                        product.getDescription().contains(text))
                .collect(Collectors.toList()));

        Mockito.when(productRepository.findByBrandContainingOrDescriptionContaining(
                text, text, PageRequest.of(page, numberPages)))
                .thenReturn(productsPage);

        Page<Product> productPage = service.getProducts(text, page, numberPages);

        Assertions.assertEquals(service.applyDiscount(productsPage.stream().findFirst()
                        .orElseThrow())
                        .getPriceWithDiscount(),
                productPage.getContent().stream().findFirst()
                        .orElseThrow()
                        .getPriceWithDiscount());
    }

}