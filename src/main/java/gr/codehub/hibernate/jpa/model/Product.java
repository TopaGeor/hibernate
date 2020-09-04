package gr.codehub.hibernate.jpa.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;    /** Technical identifier.  primary key */
    private String name;
    private double price;
    private int  inventoryQuantity;
    @OneToMany(mappedBy = "product")
    private List<CartProduct> cartProducts = new ArrayList<>();

    public Product(String name, double price, int inventoryQuantity) {
        this.name = name;
        this.price = price;
        this.inventoryQuantity = inventoryQuantity;
    }
}
