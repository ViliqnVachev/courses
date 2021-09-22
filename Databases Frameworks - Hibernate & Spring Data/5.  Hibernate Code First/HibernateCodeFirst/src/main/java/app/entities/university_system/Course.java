//package app.entities.university_system;
//
//import javax.persistence.*;
//import java.util.Date;
//import java.util.Set;
//
//@Entity
//@Table(name = "courses")
//public class Course {
//    private int id;
//    private String name;
//    private String description;
//    private Date startDate;
//    private Date endDate;
//    private int credits;
//    private Teacher teacher;
//    private Set<Student> students;
//
//
//    public Course() {
//    }
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    @Column(name = "name")
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Column(name = "description")
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    @Column(name = "start_date")
//    public Date getStartDate() {
//        return startDate;
//    }
//
//    public void setStartDate(Date start_date) {
//        this.startDate = start_date;
//    }
//
//    @Column(name = "end_date")
//    public Date getEndDate() {
//        return endDate;
//    }
//
//    public void setEndDate(Date end_date) {
//        this.endDate = end_date;
//    }
//
//    @Column(name = "credit")
//    public int getCredits() {
//        return credits;
//    }
//
//    public void setCredits(int credits) {
//        this.credits = credits;
//    }
//
//    @ManyToOne(targetEntity = Teacher.class)
//    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
//    public Teacher getTeacher() {
//        return teacher;
//    }
//
//    public void setTeacher(Teacher teacher) {
//        this.teacher = teacher;
//    }
//
//
//    @ManyToMany(mappedBy = "courses")
//    public Set<Student> getStudents() {
//        return students;
//    }
//
//    public void setStudents(Set<Student> students) {
//        this.students = students;
//    }
//}
