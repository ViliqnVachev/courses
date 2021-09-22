//package app.entities.sales_database;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@Entity
//@Table(name = "sales")
//public class Sale {
//    private int id;
//    private Product product;
//    private Customer customer;
//    private StoreLocation storeLocation;
//    private Date date;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//
//    @ManyToOne(targetEntity = Product.class)
//    @JoinColumn(name = "product_id", referencedColumnName = "id")
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
//
//    @ManyToOne(targetEntity = Customer.class)
//    @JoinColumn(name = "customer_id", referencedColumnName = "id")
//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }
//
//    @OneToOne(targetEntity = StoreLocation.class)
//    @JoinColumn(name = "location_store_id",referencedColumnName = "id")
//    public StoreLocation getStoreLocation() {
//        return storeLocation;
//    }
//
//    public void setStoreLocation(StoreLocation storeLocation) {
//        this.storeLocation = storeLocation;
//    }
//
//    @Column(name = "date")
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//}
