package cl.lider.challenge.lidersale.entity.product;

import cl.lider.challenge.lidersale.entity.IBuilder;

public class ProductBuilder implements IBuilder<Product> {

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
        build.setId(this.id);
        build.setBrand(this.brand);
        build.setDescription(this.description);
        build.setImage(this.image);
        build.setPrice(this.price);
        build.setDiscount(this.discount);
        build.setPriceWithDiscount(this.priceWithDiscount);
        return build;
    }
}
