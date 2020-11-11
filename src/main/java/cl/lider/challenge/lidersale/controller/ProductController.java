package cl.lider.challenge.lidersale.controller;

import cl.lider.challenge.lidersale.entity.product.Product;
import cl.lider.challenge.lidersale.entity.product.ValidateProduct;
import cl.lider.challenge.lidersale.service.ProductDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
@RestController
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    ProductDiscountService service;
    @Autowired
    ValidateProduct validate;

    @GetMapping
    public Page<Product> getProducts(@RequestParam("text") String text,
                              @RequestParam("page") int page,
                              @RequestParam("element-page") int elementPage){
        String error=validate.validateData(text);
        if(error.isEmpty()){
            return service.getProducts(text,page,elementPage);
        }else {
            throw new RuntimeException(error);
        }
    }
}
