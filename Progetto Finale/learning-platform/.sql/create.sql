CREATE TABLE courses (
    id BIGINT auto_increment primary key,
    name varchar(100) not null,
    description varchar(1000),
    teacher_firstname varchar(100) not null,
    teacher_lastname varchar(100) not null,
    date DATE DEFAULT (CURRENT_DATE) not null
);

CREATE TABLE lessons (
    id BIGINT auto_increment primary key,
    description varchar(1000),
    date DATE DEFAULT (CURRENT_DATE) not null,
    course_id BIGINT,
    foreign key (course_id) references courses(id)
);

CREATE TABLE students (
    id BIGINT auto_increment primary key,
    firstname varchar(100) not null,
    lastname varchar(100) not null,
    email varchar(100) not null unique
);

CREATE TABLE courses_students (
    course_id BIGINT,
    student_id BIGINT,
    foreign key (course_id) references courses(id),
    foreign key (student_id) references students(id)
);