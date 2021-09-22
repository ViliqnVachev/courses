//package app.entities.sales_database;
//
//import javax.annotation.Generated;
//import javax.persistence.*;
//import java.util.Set;
//
//@Entity
//@Table(name = "store_location")
//public class StoreLocation {
//    private int id;
//    private String locationName;
//    private Set<Sale> sales;
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
//    @Column(name = "location_name")
//    public String getLocationName() {
//        return locationName;
//    }
//
//    public void setLocationName(String locationName) {
//        this.locationName = locationName;
//    }
//
//    @OneToOne(targetEntity = Sale.class, mappedBy = "storeLocation")
//    public Set<Sale> getSales() {
//        return sales;
//    }
//
//    public void setSales(Set<Sale> sales) {
//        this.sales = sales;
//    }
//}
