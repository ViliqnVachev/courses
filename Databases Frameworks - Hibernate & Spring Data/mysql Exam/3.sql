


CREATE TABLE planets(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(30) NOT NULL
);

CREATE TABLE spaceports(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50) NOT NULL,
planet_id INT
);

CREATE TABLE spaceships(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50) NOT NULL,
manufacturer VARCHAR(30) NOT NULL,
light_speed_rate INT DEFAULT 0
);

CREATE TABLE colonists(
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(20) NOT NULL,
last_name VARCHAR(20) NOT NULL,
ucn VARCHAR(10) NOT NULL UNIQUE,
birth_date DATE NOT NULL
);

CREATE TABLE journeys(
id INT PRIMARY KEY AUTO_INCREMENT,
journey_start DATETIME NOT NULL,
journey_end DATETIME NOT NULL,
purpose ENUM('Medical','Technical','Educational','Military') ,
destination_spaceport_id INT,
spaceship_id INT
);

CREATE TABLE travel_cards(
id INT PRIMARY KEY AUTO_INCREMENT,
card_number CHAR(10) NOT NULL UNIQUE,
job_during_journey ENUM('Pilot','Engineer','Trooper','Cleaner','Cook'),
colonist_id INT,
journey_id INT
);

ALTER TABLE spaceports
ADD CONSTRAINT fk_spaceports_planets
FOREIGN KEY spaceports(planet_id)
REFERENCES planets(id);

ALTER TABLE journeys
ADD CONSTRAINT fk_jorneys_spaceports
FOREIGN KEY journeys(destination_spaceport_id)
REFERENCES spaceports(id);

ALTER TABLE journeys
ADD CONSTRAINT fk_jorneys_spaceships
FOREIGN KEY journeys(spaceship_id)
REFERENCES spaceships(id);

ALTER TABLE travel_cards
ADD CONSTRAINT fk_travel_cards_colonists
FOREIGN KEY travel_cards(colonist_id)
REFERENCES colonists(id);

ALTER TABLE travel_cards
ADD CONSTRAINT fk_travel_cards_journeys
FOREIGN KEY travel_cards(journey_id)
REFERENCES journeys(id);
















