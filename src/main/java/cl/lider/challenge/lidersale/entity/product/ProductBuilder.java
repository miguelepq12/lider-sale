package cl.lider.challenge.lidersale.entity.builders;

import cl.lider.challenge.lidersale.entity.Product;
import org.springframework.data.annotation.Id;

public class ProductBuilder implements IBuilder{

    private long id;
    private String brand;
    private String description;
    private String image;
    private double price;
    private double priceWithDiscount;
    private double discount;

    public ProductBuilder(long id) {
        this.id = id;
    }

    public ProductBuilder withBrand(String brand){
        this.brand = brand;
        return this;
    }

    public ProductBuilder withDescription(String description){
        this.description = description;
        return this;
    }

    public ProductBuilder withImage(String image){
        this.image = image;
        return this;
    }

    public ProductBuilder withPrice(double price){
        this.price = price;
        return this;
    }

    public ProductBuilder withDiscount(double discount){
        this.discount = discount;
        return this;
    }

    public ProductBuilder withPriceWithDiscount(double priceWithDiscount){
        this.priceWithDiscount = priceWithDiscount;
        return this;
    }

    @Override
    public Product build() {
        Product build= new Product();
        build.setI
        build.
    }
}
