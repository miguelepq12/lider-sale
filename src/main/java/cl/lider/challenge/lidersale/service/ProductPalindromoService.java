package cl.lider.challenge.lidersale.service;

import cl.lider.challenge.lidersale.entity.product.Product;
import cl.lider.challenge.lidersale.repository.ProductRepository;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductPalindromoService implements ProductDiscountService {
    @Autowired
    ProductRepository repository;

    @Override
    public Page<Product> getProducts(String text, int page,int elementsPage) {
        Page<Product> products=getProductsRepository(text,page>0?page-1:0,elementsPage);

        if(isTextPalindromo(text)){
            products.getContent().forEach(this::applyDiscount);
        }
        return products;
    }

    @Override
    public Page<Product> getProductsRepository(String text, int page, int elementsPage) {
        if(NumberUtils.isCreatable(text)){
            return repository.findById(Integer.parseInt(text),
                    PageRequest.of(page,elementsPage));
        }else {
            return repository.findByBrandContainingOrDescriptionContaining(text,text,
                    PageRequest.of(page,elementsPage));
        }
    }

    @Override
    public Product applyDiscount(Product p) {
        double discount=50;
        p.setPriceWithDiscount(p.getPrice()-(p.getPrice()*(discount/100)));
        p.setDiscount(discount);
        return p;
    }

    private boolean isTextPalindromo(String text){
        if(!text.isEmpty()) {
            text = text.toLowerCase().replace("á", "a")
                    .replace("é", "e")
                    .replace("í", "i")
                    .replace("ó", "o")
                    .replace("ú", "u")
                    .replace(" ", "")
                    .replace(".", "")
                    .replace(",", "");
            String invertida = new StringBuilder(text).reverse().toString();
            return invertida.equals(text);
        }else {
            return false;
        }
    }
}
