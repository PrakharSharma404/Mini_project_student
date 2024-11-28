-- Insert Data into Department Table
INSERT INTO department (department_name, capacity) VALUES
                                                       ('ADMIN', 100),
                                                       ('HR', 50);

-- Insert Data into Specialisation Table
INSERT INTO specialisation (code, specialisation_name, description, year, required_credit) VALUES
                                                                                               ('AI001', 'AI', 'Artificial Intelligence Specialisation', '2024-09-01', 30),
                                                                                               ('ML001', 'ML', 'Machine Learning Specialisation', '2024-09-01', 30),
                                                                                               ('DS001', 'DS', 'Data Science Specialisation', '2024-09-01', 30),
                                                                                               ('VLSI001', 'VLSI', 'VLSI Design Specialisation', '2024-09-01', 30),
                                                                                               ('ES001', 'ES', 'Embedded System Specialisation', '2024-09-01', 30);


-- Insert Data into Employees Table
INSERT INTO employees (first_name, last_name, email, title, photograph_path, password, department_id) VALUES
                                                                                                          ('Admin', 'One', 'admin1@example.com', 'Admin', '/images/admin_one.jpg', 'password123', 1),  -- CSE Department
                                                                                                          ('HR', 'One', 'admin2@example.com', 'Admin', '/images/admin_two.jpg', 'password123', 2);  -- ECE Department

-- Insert Data into Domain Table
INSERT INTO domain (program, batch, capacity, qualification) VALUES
                                                                 ('CS', '2024', 100, 'Bachelors in Technology'),
                                                                 ('ECE', '2024', 50, 'Masters in Technology');

-- Insert Data into Course Table
INSERT INTO course (course_code, course_name, description, year, term, credits, capacity) VALUES
                                                                                              ('CS101', 'Introduction to Computer Science', 'Basic computer science course', '2024-01-01', 'Spring', 4, 100),
                                                                                              ('CS102', 'Data Structures', 'Data Structures and Algorithms', '2024-01-01', 'Fall', 4, 100),                                                                                           -- CS Specializations (DS, AL, ML)
                                                                                              ('CS201', 'Data Mining', 'Introduction to Data Mining techniques', '2024-01-01', 'Spring', 4, 100), -- DS
                                                                                              ('CS202', 'Advanced Algorithms', 'Deep dive into algorithmic paradigms', '2024-01-01', 'Fall', 4, 100), -- AL
                                                                                              ('CS203', 'Deep Learning', 'Neural networks and applications', '2024-01-01', 'Spring', 4, 100), -- ML
                                                                                              ('CS204', 'Big Data Analytics', 'Big data technologies and tools', '2024-01-01', 'Fall', 3, 100), -- DS
                                                                                              ('CS205', 'Reinforcement Learning', 'RL and decision-making models', '2024-01-01', 'Spring', 3, 100), -- AL
                                                                                              ('CS301', 'Operating Systems', 'Operating system concepts', '2024-01-01', 'Spring', 4, 100),
                                                                                              ('CS302', 'Database Systems', 'Database design and applications', '2024-01-01', 'Fall', 4, 100),
                                                                                              ('CS303', 'Computer Networks', 'Networking principles and protocols', '2024-01-01', 'Spring', 4, 100),

                                                                                              -- ECE Specializations (VLSI, ES)
                                                                                              ('ECE201', 'Digital VLSI Design', 'VLSI digital systems design', '2024-01-01', 'Spring', 4, 50), -- VLSI
                                                                                              ('ECE202', 'FPGA Design', 'Programming FPGAs for custom hardware', '2024-01-01', 'Fall', 4, 50), -- VLSI
                                                                                              ('ECE203', 'Embedded Systems Basics', 'Introduction to Embedded Systems', '2024-01-01', 'Spring', 3, 50), -- ES
                                                                                              ('ECE204', 'IoT and Sensors', 'IoT devices and sensor networks', '2024-01-01', 'Fall', 3, 50), -- ES
                                                                                              ('ECE205', 'System-on-Chip Design', 'Advanced VLSI techniques', '2024-01-01', 'Spring', 4, 50), -- VLSI
                                                                                              ('ECE101', 'Basic Electronics', 'Fundamentals of Electronics', '2024-01-01', 'Spring', 3, 50),
                                                                                              ('ECE301', 'Control Systems', 'Basic principles of control systems', '2024-01-01', 'Spring', 3, 50),
                                                                                              ('ECE302', 'Communication Systems', 'Principles of digital communication', '2024-01-01', 'Fall', 4, 50);

-- Insert Data into Specialisation_Course Table
INSERT INTO specialisation_course (specialisation_id, course_id) VALUES
                                                                     (1,1),
                                                                     (1,2),
                                                                     (1,3),
                                                                     (1,4),
                                                                     (2,5),
                                                                     (2,6),
                                                                     (2,7),
                                                                     (3,8),
                                                                     (3,9),
                                                                     (3,10),
                                                                     (4,11),
                                                                     (4,12),
                                                                     (4,13),
                                                                     (4,14),
                                                                     (5,15),
                                                                     (5,16),
                                                                     (5,17),
                                                                     (5,18);



-- Insert Data into Students Table
INSERT INTO students (roll_number, first_name, last_name, email, photograph_path, cgpa, total_credit, graduation_year, domain_id, specialisation_id) VALUES
                                                                                                                                                         ('S001', 'John', 'Doe', 'john.doe@example.com', '/images/john_doe.jpg', 8.5, 25, '2024-05-01', 1, 1),  -- B.Tech, AI
                                                                                                                                                         ('S002', 'Jane', 'Smith', 'jane.smith@example.com', '/images/jane_smith.jpg', 9.0, 22, '2024-05-01', 1, 2),  -- M.Tech, ML
                                                                                                                                                         ('S003', 'Alice', 'Brown', 'alice.brown@example.com', '/images/alice_brown.jpg', 8.8, 20, '2024-05-01', 1, 3), -- B.Tech, DS
                                                                                                                                                         ('S004', 'Bob', 'Johnson', 'bob.johnson@example.com', '/images/bob_johnson.jpg', 8.2, 18, '2024-05-01', 1, 2), -- B.Tech, AL
                                                                                                                                                         ('S005', 'Charlie', 'Davis', 'charlie.davis@example.com', '/images/charlie_davis.jpg', 8.5, 22, '2024-05-01', 1, 3), -- B.Tech, ML
                                                                                                                                                         ('S006', 'Diana', 'Evans', 'diana.evans@example.com', '/images/diana_evans.jpg', 9.1, 24, '2024-05-01', 1, 1), -- M.Tech, VLSI
                                                                                                                                                         ('S007', 'Eve', 'Foster', 'eve.foster@example.com', '/images/eve_foster.jpg', 9.4, 26, '2024-05-01', 1, 2), -- M.Tech, ES
                                                                                                                                                         ('S008', 'Frank', 'Green', 'frank.green@example.com', '/images/frank_green.jpg', 8.3, 20, '2024-05-01', 1, 3), -- B.Tech, DS
                                                                                                                                                         ('S009', 'Grace', 'Harris', 'grace.harris@example.com', '/images/grace_harris.jpg', 8.9, 19, '2024-05-01', 2, 4), -- B.Tech, AL
                                                                                                                                                         ('S010', 'Henry', 'Iverson', 'henry.iverson@example.com', '/images/henry_iverson.jpg', 9.0, 21, '2024-05-01', 2, 4), -- M.Tech, VLSI
                                                                                                                                                         ('S011', 'Ivy', 'Jackson', 'ivy.jackson@example.com', '/images/ivy_jackson.jpg', 9.3, 23, '2024-05-01', 2, 5), -- M.Tech, ES
                                                                                                                                                         ('S012', 'Jack', 'King', 'jack.king@example.com', '/images/jack_king.jpg', 8.6, 22, '2024-05-01', 2, 5); -- B.Tech, ML

-- Insert Data into Student_Course Table
INSERT INTO student_course (student_id, course_id) VALUES
                                                       (1, 1), (2, 3), (3, 5), (4, 7), (5, 2),
                                                       (6, 4), (7, 6), (8, 8), (1, 9), (2, 10),
                                                       (3, 1), (4, 2), (5, 3), (6, 4), (7, 5),
                                                       (8, 6), (1, 7), (2, 8), (3, 9), (4, 10),
                                                       (5, 1), (6, 2), (7, 3), (8, 4), (1, 5),
                                                       (2, 6), (3, 7), (4, 8), (5, 9), (6, 10),
                                                       (7, 1), (8, 2), (1, 3), (2, 4), (3, 5),
                                                       (4, 6), (5, 7), (6, 8), (7, 9), (8, 10),
                                                       (9, 11), (9, 12), (9, 13), (9, 14), (9, 15),
                                                       (10, 11), (10, 16), (10, 12), (10, 18), (10, 14),
                                                       (11, 15), (11, 16), (11, 13), (11, 17), (11, 18),
                                                       (12, 12), (12, 14), (12, 15), (12, 17), (12, 18),
                                                       (9, 16), (9, 18), (10, 13), (11, 14), (12, 11);


