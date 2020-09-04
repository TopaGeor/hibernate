package gr.codehub.hibernate.jpa.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class CartProduct {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name= "cart_id")
    private Cart cart;
    @ManyToOne
    @JoinColumn(name= "product_id")
    private Product product;
    private String name;


    public CartProduct(Cart cart, Product product) {
        this.cart = cart;
        this.product = product;
    }
}
