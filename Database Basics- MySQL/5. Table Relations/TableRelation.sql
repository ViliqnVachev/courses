CREATE DATABASE perosnal_information;

USE perosnal_information;


CREATE TABLE passports(
passport_id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
passport_number VARCHAR(8) NOT NULL UNIQUE
)AUTO_INCREMENT=101;

CREATE TABLE persons(
person_id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
first_name VARCHAR(20) NOT NULL,
salary DECIMAL(10, 2) NOT NULL DEFAULT 0,
passport_id INT(11) NOT NULL UNIQUE,
CONSTRAINT fk_persons_passports
FOREIGN KEY (passport_id)
REFERENCES passports(passport_id)
);

INSERT INTO passports (passport_number)
VALUES  ('N34FG21B'),('K65LO4R7'),('ZE657QP2');

INSERT INTO persons (first_name,salary,passport_id)
VALUES  ('Roberto',43300.00,102),
		('Tom',56100.00,103),
		('Yana',60200.00,101);
        
        
CREATE DATABASE productions;

USE productions; 

CREATE TABLE manufacturers
(
manufacturer_id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR (10) NOT NULL,
established_on DATE NOT NULL
);

CREATE TABLE models
(
model_id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR (10) NOT NULL,
manufacturer_id INT (11) NOT NULL
)AUTO_INCREMENT=101; 

ALTER TABLE models
ADD CONSTRAINT fk_manufacturers_models FOREIGN KEY (manufacturer_id) REFERENCES manufacturers (manufacturer_id);

INSERT INTO manufacturers (name,established_on) 
VALUES  ('BMW','1916-03-01'),
		('Tesla','2003-01-01'),
        ('Lada','1966-05-01');
        
INSERT INTO models(name,manufacturer_id)
VALUES  ('X1',1),
		('i6',1),
        ('Model S',2),
        ('Model X',2),
        ('Model 3',2),
        ('Nova',3);
        

CREATE DATABASE university;
USE university;

CREATE TABLE students(
student_id INT (11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
name VARCHAR (20) NOT NULL
);

CREATE TABLE exams(
exam_id INT (11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
name VARCHAR (20) NOT NULL
)AUTO_INCREMENT=101;

CREATE TABLE students_exams(
student_id INT (11),
exam_id INT (11),
	CONSTRAINT pk_students_exams
	PRIMARY KEY (student_id,exam_id),
    CONSTRAINT fk_students_exams_students
	FOREIGN KEY (student_id)REFERENCES students(student_id),
    CONSTRAINT fk_students_exams_exams
	FOREIGN KEY (exam_id)REFERENCES exams(exam_id)
);

INSERT INTO students(name)
VALUES ('Mila'),('Toni'),('Ron');

INSERT INTO exams(name)
VALUES ('Spring MVC'),('Neo4j'),('Oracle 11g');

INSERT INTO students_exams(student_id,exam_id)
VALUES (1,101),(1,102),(2,101),(3,103),(2,102),(2,103);
        

CREATE TABLE teachers(
teacher_id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
name VARCHAR(20) NOT NULL,
manager_id INT(11) NULL
)AUTO_INCREMENT=101;

INSERT INTO teachers(name,manager_id)
VALUES ('John',NULL),('Maya',106),('Silvia',106),('Ted',105),('Mark',101),('Greta',101);

ALTER TABLE teachers
ADD CONSTRAINT fk_teachers_managers
FOREIGN KEY (manager_id) REFERENCES teachers(teacher_id);



CREATE DATABASE online_store;
USE online_store;

CREATE TABLE cities(
city_id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR (50) NOT NULL
);

CREATE TABLE customers(
customer_id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR (50) NOT NULL,
birthday DATE NOT NULL,
city_id INT (11) NOT NULL,
CONSTRAINT fk_cities_customers FOREIGN KEY (city_id) REFERENCES cities(city_id)
);

CREATE TABLE orders(
order_id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
customer_id INT (11) NOT NULL, 
CONSTRAINT fk_orders_customers FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

CREATE TABLE item_types(
item_type_id INT (11)  NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR (50) NOT NULL
);

CREATE TABLE items(
item_id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR (50) NOT NULL,
item_type_id INT (11) NOT NULL,
CONSTRAINT fk_items_item_types FOREIGN KEY (item_type_id) REFERENCES item_types(item_type_id)
);

CREATE TABLE order_items(
order_id INT (11) NOT NULL,
item_id INT (11) NOT NULL,
CONSTRAINT pk_order_items PRIMARY KEY (order_id , item_id),
CONSTRAINT fk_order_items_orders FOREIGN KEY (order_id) REFERENCES orders(order_id),
CONSTRAINT fk_order_items_item_id FOREIGN KEY (item_id) REFERENCES items(item_id)
);



 CREATE DATABASE soft_uni;
 USE soft_uni;
 
 CREATE TABLE subjects(
 subject_id INT (11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 subject_name VARCHAR(50) NOT NULL
 );
 
 CREATE TABLE majors(
 major_id INT (11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 name VARCHAR(50) NOT NULL
 );
 
CREATE TABLE payments (
    payment_id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    payment_date DATE NOT NULL,
    payment_amount DECIMAL(8 , 2 ) NOT NULL,
    student_id INT(11) NOT NULL UNIQUE
);
 
 CREATE TABLE students(
 student_id INT (11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 student_number VARCHAR(12) NOT NULL,
 student_name VARCHAR(50) NOT NULL,
 major_id INT(11) NOT NULL
 );
 
 ALTER TABLE payments
 ADD CONSTRAINT fk_students_payments FOREIGN KEY(student_id) REFERENCES students (student_id);
        
 ALTER TABLE students
 ADD CONSTRAINT fk_major_students FOREIGN KEY(major_id) REFERENCES majors (major_id);
 
 CREATE TABLE agenda(
 student_id INT (11) NOT NULL,
 subject_id INT (11) NOT NULL,
 CONSTRAINT pk_agenda PRIMARY KEY (student_id,subject_id),
 CONSTRAINT fk_subjects_agenda FOREIGN KEY (subject_id) REFERENCES subjects (subject_id),
  CONSTRAINT fk_students_agenda FOREIGN KEY (student_id) REFERENCES students (student_id)
 );
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

