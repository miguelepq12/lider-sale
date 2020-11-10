package cl.lider.challenge.lidersale.entity.product;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {

    @Getter
    @Setter
    @Id
    private long id;
    @Getter
    @Setter
    private String brand;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private String image;
    @Getter
    @Setter
    private double price;
    @Getter
    @Setter
    private double priceWithDiscount;
    @Getter
    @Setter
    private double discount;
}
