package com.apweif.app.inventariodolar.controller;

import com.apweif.app.inventariodolar.dto.Result;
import com.apweif.app.inventariodolar.entity.Product;
import com.apweif.app.inventariodolar.entity.ProductPrice;
import com.apweif.app.inventariodolar.service.ProductPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
@RestController
public class ProductController {

    @Autowired
    ProductPriceService service;

    @PostMapping("/product")
    Result addProduct(@RequestBody Product p){
        Product product=service.addProduct(p);
        if(product!=null){
            return new Result("Exitoso","Producto guardado");
        }else{
            return new Result("No Exitoso", "El producto no se pudo guardar");
        }
    }

    @GetMapping("/products")
    Page<ProductPrice> getProducts(@RequestParam("category") String category,
                                   @RequestParam("name") String name,
                                   @RequestParam("page") String page){
        return service.getProductsPrice(name,category);
    }
}
