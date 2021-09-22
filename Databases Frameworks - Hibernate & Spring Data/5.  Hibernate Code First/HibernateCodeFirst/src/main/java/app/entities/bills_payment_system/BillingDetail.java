//package app.entities.bills_payment_system;
//
//import javax.persistence.*;
//
//
//@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//public abstract class BillingDetail {
//    private int id;
//    private String number;
//    private User user;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    @Column(name = "name")
//    public String getNumber() {
//        return number;
//    }
//
//    public void setNumber(String number) {
//        this.number = number;
//    }
//
//    @ManyToOne(targetEntity = User.class)
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//}
//
//
