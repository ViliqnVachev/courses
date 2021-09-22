//package app.entities.university_system;
//
//import javax.persistence.*;
//import java.util.Set;
//
//@Entity
//@Table(name = "teachers")
//public class Teacher extends Person {
//    private String email;
//    private double salaryPerHour;
//    private Set<Course> courses;
//
//
//    public Teacher() {
//    }
//
//    @Column(name = "email")
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    @Column(name = "salary")
//    public double getSalaryPerHour() {
//        return salaryPerHour;
//    }
//
//    public void setSalaryPerHour(double salaryPerHour) {
//        this.salaryPerHour = salaryPerHour;
//    }
//
//    @OneToMany(mappedBy = "teacher", targetEntity = Course.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    public Set<Course> getCourses() {
//        return courses;
//    }
//
//    public void setCourses(Set<Course> courses) {
//        this.courses = courses;
//    }
//
//
//}
