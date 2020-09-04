package gr.codehub.hibernate.jpa.scenario;

import gr.codehub.hibernate.jpa.jpa.JpaUtil;
import gr.codehub.hibernate.jpa.model.Cart;
import gr.codehub.hibernate.jpa.model.CartProduct;
import gr.codehub.hibernate.jpa.model.Customer;
import gr.codehub.hibernate.jpa.model.Product;
import gr.codehub.hibernate.jpa.repository.CartProductRepository;
import gr.codehub.hibernate.jpa.repository.CartRepository;
import gr.codehub.hibernate.jpa.repository.CustomerRepository;
import gr.codehub.hibernate.jpa.repository.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

public class Scenario {
    private EntityManager em ;

    public Scenario(EntityManager em) {
        this.em = em;
    }

    public void useCaseCreateInventory(){

        ProductRepository productRepository = new ProductRepository(em);

        Product p = new Product("Pizza", 12, 23) ;
        productRepository.save(p);
        Product p1 = new Product("Calzone", 15, 12) ;
        productRepository.save(p1);

    }
    public void useCaseCreateCustomers() {

        CustomerRepository customerRepository = new CustomerRepository(em);

        Customer c = new Customer("dimitris", "athens", "dimitris@gmail.com");
        customerRepository.save(c);
    }
    public void useCaseCreatePurchase() {


        CustomerRepository customerRepository = new CustomerRepository(em);
        ProductRepository productRepository = new ProductRepository(em);

        Customer customer = customerRepository.findById( 3l).get();

        Product p1 = productRepository.findById(1l).get();

        Cart cart = new Cart();
        cart.setCustomer(customer);

        customer.getCarts().add(cart);
        cart.setName("Cart");

        CartProduct cartProduct = new  CartProduct(cart, p1);
        cart.addCartProduct(cartProduct);

        customerRepository.save(customer);

    }

    public void showData(){
        CustomerRepository customerRepository = new CustomerRepository(em);
        ProductRepository productRepository = new ProductRepository(em);
        CartRepository cartRepository = new CartRepository(em);
        CartProductRepository cartProductRepository = new CartProductRepository(em);
        Customer customer = customerRepository.findById( 2l).get();

        Cart cart = customer.getCarts().get(0);

     String name =   cart.getCartProducts().get(0).getProduct().getName();

        System.out.println(name);

    }

}
