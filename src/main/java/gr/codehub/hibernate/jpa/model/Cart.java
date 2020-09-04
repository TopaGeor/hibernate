package gr.codehub.hibernate.jpa.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Date creationDate;
    private String name;
    @ManyToOne
    @JoinColumn(name= "customer_id")
    private Customer customer;
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartProduct> cartProducts = new ArrayList<>();

  public void addCartProduct(CartProduct cartProduct){
      cartProducts.add(cartProduct);
  }

}
