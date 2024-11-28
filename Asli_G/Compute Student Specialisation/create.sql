-- Department Table
CREATE TABLE department (
                            department_id INT AUTO_INCREMENT PRIMARY KEY,
                            department_name VARCHAR(100) NOT NULL,
                            capacity INT NOT NULL
);

-- Specialisation Table
CREATE TABLE specialisation (
                                specialisation_id INT AUTO_INCREMENT PRIMARY KEY,
                                code VARCHAR(50) UNIQUE,
                                specialisation_name VARCHAR(100) NOT NULL,
                                description TEXT,
                                year DATE,
                                required_credit INT,
                                CONSTRAINT uq_specialisation_name UNIQUE(specialisation_name)
);

-- Employees Table
CREATE TABLE employees (
                           employee_id INT AUTO_INCREMENT PRIMARY KEY,
                           first_name VARCHAR(100) NOT NULL,
                           last_name VARCHAR(100),
                           email VARCHAR(100) UNIQUE NOT NULL,
                           title VARCHAR(100),
                           photograph_path VARCHAR(255),
                           password VARCHAR(255) NOT NULL,
                           department_id INT,
                           CONSTRAINT fk_department FOREIGN KEY (department_id) REFERENCES department(department_id)
);

-- Domain Table
CREATE TABLE domain (
                        domain_id INT AUTO_INCREMENT PRIMARY KEY,
                        program VARCHAR(100) NOT NULL,
                        batch VARCHAR(100) NOT NULL,
                        capacity INT NOT NULL,
                        qualification VARCHAR(100),
                        CONSTRAINT uq_program_batch UNIQUE(program, batch)
);

-- Course Table
CREATE TABLE course (
                        course_id INT AUTO_INCREMENT PRIMARY KEY,
                        course_code VARCHAR(50) UNIQUE NOT NULL,
                        course_name VARCHAR(100) NOT NULL,
                        description TEXT,
                        year DATE NOT NULL,
                        term VARCHAR(50) NOT NULL,
                        credits INT NOT NULL,
                        capacity INT NOT NULL
);

-- Students Table
CREATE TABLE students (
                          student_id INT AUTO_INCREMENT PRIMARY KEY,
                          roll_number VARCHAR(50) UNIQUE NOT NULL,
                          first_name VARCHAR(100) NOT NULL,
                          last_name VARCHAR(100),
                          email VARCHAR(100) UNIQUE NOT NULL,
                          photograph_path VARCHAR(255),
                          cgpa DECIMAL(3, 2) NOT NULL,
                          total_credit INT NOT NULL,
                          graduation_year DATE,
                          domain_id INT,
                          specialisation_id INT,
                          CONSTRAINT fk_domain FOREIGN KEY (domain_id) REFERENCES domain(domain_id),
                          CONSTRAINT fk_specialisation FOREIGN KEY (specialisation_id) REFERENCES specialisation(specialisation_id)
);

-- Student_Course Table (Join Table for Many-to-Many Relationship)
CREATE TABLE student_course (
                                student_course_id INT AUTO_INCREMENT PRIMARY KEY,
                                student_id INT,
                                course_id INT,
                                CONSTRAINT fk_student FOREIGN KEY (student_id) REFERENCES students(student_id),
                                CONSTRAINT fk_course FOREIGN KEY (course_id) REFERENCES course(course_id)
);

CREATE TABLE specialisation_course (
                                specialisation_course_id INT AUTO_INCREMENT PRIMARY KEY,
                                specialisation_id INT,
                                course_id INT,
                                CONSTRAINT fk_specialisation_id FOREIGN KEY (specialisation_id) REFERENCES specialisation(specialisation_id),
                                CONSTRAINT fk_course_id FOREIGN KEY (course_id) REFERENCES course(course_id)
);