package cl.lider.challenge.lidersale.controller;

import cl.lider.challenge.lidersale.entity.product.Product;
import cl.lider.challenge.lidersale.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
@RestController
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping
    Page<Product> getProducts(@RequestParam("text") String text,
                              @RequestParam("page") int page){
        return service.getProducts(text,page);
    }
}
