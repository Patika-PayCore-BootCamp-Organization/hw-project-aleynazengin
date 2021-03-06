DROP TABLE IF EXISTS ticket;
DROP TABLE IF EXISTS screening_movie;
DROP TABLE IF EXISTS movie;
DROP TABLE IF EXISTS genre;
DROP TABLE IF EXISTS theatre;
DROP TABLE IF EXISTS customer;

CREATE TABLE genre
(
    id   INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name VARCHAR(20) NOT NULL
);
CREATE TABLE movie
(
    id      INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name    VARCHAR(50)  NOT NULL,
    description VARCHAR(350) NOT NULL,
    duration INT NOT NULL,
    genre_id INT NOT NULL,
    FOREIGN KEY (genre_id) REFERENCES genre (id)
);

CREATE TABLE theatre
(
    id        INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name      VARCHAR(25) NOT NULL,
    city      VARCHAR(50) NOT NULL,
    district VARCHAR(50) NOT NULL,
    address   VARCHAR(250)
);
CREATE TABLE customer
(
    id        INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    firstname VARCHAR(25)   NOT NULL,
    lastname  VARCHAR(25)   NOT NULL,
    gender    VARCHAR(10),
    age       INT DEFAULT 0,
    phone     VARCHAR(15),
    email     VARCHAR(25) UNIQUE NOT NULL
);

CREATE TABLE screening_movie
(
    id           INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    movie_id     INT NOT NULL,
    theatre_id INT NOT NULL,
    date_of_screening DATE,
    FOREIGN KEY (movie_id) REFERENCES movie (id),
    FOREIGN KEY (theatre_id) REFERENCES theatre(id)
);
CREATE TABLE ticket
(
    id                  INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    customer_id         INT NOT NULL,
    screening_movie_id  INT NOT NULL,
    price               DOUBLE PRECISION NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customer (id),
    FOREIGN KEY (screening_movie_id) REFERENCES screening_movie (id)
);
-- ////////////////////////////////////////////////////////////////////////////
--  Sample static test values
-- ////////////////////////////////////////////////////////////////////////////

INSERT INTO customer(firstname, lastname, gender, age, phone, email)
VALUES ('Ali', 'Tek', 'male', 27, '905554443322', 'ali@gmail.com'),
       ('Ceren', 'Telli', 'female', 26, '905554443322', 'ceren@gmail.com'),
       ('Dilek', 'Tutku', 'female', 14, '905554443322', 'dilek3@gmail.com'),
       ('Cem', 'Sayg??n', 'male', 25, '905554443322', 'cem4@gmail.com'),
       ('Selin', 'Sanl??', 'female', 25, '905554443322', 'selin123@gmail.com'),
       ('Veli', 'Telli', 'male', 26, '905554443322', 'veli@hotmail.com'),
       ('Sam', 'Caroline', 'male', 25, '905554443322', 'veli3@hotmail.com'),
       ('Jhonny', 'Deepy', 'male', 41, '905554443322', 'jhonny@gmail.com'),
       ('Caroline', 'Geenny', 'female', 27, '905554443322', 'caroline@hotmail.com');

INSERT INTO genre(name)
VALUES ('Action'),
       ('Comedy'),
       ('Drama'),
       ('Fantasy'),
       ('Horror'),
       ('Mystery'),
       ('Romance'),
       ('Thriller'),
       ('Science fiction');

INSERT INTO movie(name, description, duration,genre_id)
VALUES ('Uncharted','Uncharted is Sonys adaptation of the iconic gaming series created by Naughty Dog. Tom Holland plays Nathan Drake with Mark Wahlberg as his mentor Victor Sullivan.',116,1),
 ('The Batman','In his second year of fighting crime, Batman uncovers corruption in Gotham City that connects to his own family while facing a serial killer known as the Riddler.',175,1),
 ('The Cursed','A once-peaceful remote country village is under attack???but by who or what, no one knows. Villagers spread rumors of a cursed land, supernatural forces, and even demonic creatures, as the disappearances and killings continue.',112,5),
 ('Unbreakable Boy','A boy has both a rare brittle-bone disease and autism. But what makes Austin truly unique is his joyous, funny, life-affirming worldview that transforms and unites everyone around him. The boy???s father changes his life as he comes to see Austin not as the symbol of something broken, but the triumph of an indestructible spirit.',120,3);

INSERT INTO theatre(name,city,district,address)
VALUES ('A Plus AVM', 'Istanbul', 'Bakirkoy','Atakoy Konaklari Adnan Kahveci Bulvari 6.Kisim'),
 ('Adiyaman Park AVM', 'Adiyaman', 'Province','Yeni Sanayi, 2819. Sk. No:70 Merkez, 02040'),
 ('Akasya AVM', 'Istanbul', 'Uskudar', 'Acibadem, Cecen Sok. No:25'),
 ('Akasya AVM', 'Istanbul', 'Uskudar', 'Acibadem, Cecen Sok. No:25'),
 ('MaviBahce', 'Izmir', 'Karsiyaka', 'Mavisehir, Caher Dudayev Blv, 35590');

INSERT INTO screening_movie(movie_id,theatre_id,date_of_screening)
VALUES (1,1,'2022-02-17'),
 (1,1,'2022-02-18'),
 (1,1,'2022-02-19'),
 (1,1,'2022-02-20'),
 (2,1,'2022-02-17'),
 (2,1,'2022-02-18'),
 (1,3,'2022-02-17'),
 (1,2,'2022-02-17'),
 (2,2,'2022-02-17'),
 (2,3,'2022-02-17'),
 (2,3,'2022-02-18'),
 (1,3,'2022-02-18'),
 (3,3,'2022-02-19'),
 (3,3,'2022-02-20'),
 (3,3,'2022-02-21');

INSERT INTO ticket(customer_id,screening_movie_id,price)
VALUES (1,2,33.99),
 (2,2,33.99),
 (3,1,41.99),
 (4,5,36.99),
 (5,6,30.99),
 (6,7,38.99);
