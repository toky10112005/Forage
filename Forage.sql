DROP DATABASE IF EXISTS Forage;
CREATE DATABASE Forage;
USE Forage;

CREATE TABLE Demande(
    id INT PRIMARY KEY AUTO_INCREMENT,
    dateDemande DATE,
    lieu VARCHAR(255),
    personne VARCHAR(255),
    distrrict VARCHAR(255),
    commune VARCHAR(255),
    fokotany VARCHAR(255),
    Lieu VARCHAR(255)
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