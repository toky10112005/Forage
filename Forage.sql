DROP DATABASE IF EXISTS Forage;
CREATE DATABASE Forage;
USE Forage;

CREATE TABLE Personne(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(255)
);

CREATE TABLE Demande(
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_personne INT,
    dateDemande DATE,
    lieu VARCHAR(255),
    personne VARCHAR(255),
    region VARCHAR(255)
);

CREATE TABLE Status(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(255)
);

CREATE TABLE DemandeStatus(
    id INT PRIMARY KEY AUTO_INCREMENT,
    demande_id INT,
    status_id INT,
    Datemutation DATE,
    FOREIGN KEY (demande_id) REFERENCES Demande(id),
    FOREIGN KEY (status_id) REFERENCES Status(id)
);

CREATE TABLE Region(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(255)
);  

CREATE TABLE District(
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_region INT,
    nom VARCHAR(255),
    FOREIGN KEY (id_region) REFERENCES Region(id)
);

CREATE TABLE Commune(
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_district INT,
    nom VARCHAR(255),
    FOREIGN KEY (id_district) REFERENCES District(id)
);

-- CREATE TABLE Fokotany(
--     id INT PRIMARY KEY AUTO_INCREMENT,
--     id_commune INT,
--     nom VARCHAR(255),
--     FOREIGN KEY (id_commune) REFERENCES Commune(id)
-- );