create table if not exists courses(
    courseId int primary key,
    title varchar(50) not null,
    description varchar(100),
    price int,
    categoryId int not null,
    foreign key(categoryId) references categories(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE if not exists videos (
    videoId INT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    url VARCHAR(255) NOT NULL,
    duration INT,
    courseId INT,
    FOREIGN KEY (courseId) REFERENCES courses(courseId)
);
