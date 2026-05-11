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

CREATE TABLE LieuForage(
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_demande INT,
    region VARCHAR(255),
    district VARCHAR(255),
    commune VARCHAR(255),
    FOREIGN KEY (id_demande) REFERENCES Demande(id)
);

CREATE TABLE Status(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(255)
);

CREATE TABLE DemandeStatus(
    id INT PRIMARY KEY AUTO_INCREMENT,
    demande_id INT,
    status_id INT DEFAULT 1,
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

INSERT INTO Status (nom) VALUES 
('Créer'),
('Terminé'),
('Rejeté');

-- CREATE TABLE Fokotany(
--     id INT PRIMARY KEY AUTO_INCREMENT,
--     id_commune INT,
--     nom VARCHAR(255),
--     FOREIGN KEY (id_commune) REFERENCES Commune(id)
-- );

INSERT INTO Region (nom) VALUES 
('Analamanga'),
('Vakinankaratra'),
('Itasy'),
('Bongolava'),
('Alaotra Mangoro'),
('Sava'),
('Diana'),
('Sofia'),
('Boeny'),
('Melaky'),
('Menabe'),
('Atsimo Andrefana'),
('Androy'),
('Anosy');

INSERT INTO District (id_region, nom) VALUES 
(1, 'Antananarivo'),
(1, 'Ambohidratrimo'),
(1, 'Andramasina'),
(1, 'Anjozorobe'),
(1, 'Antananarivo-Atsimondrano'),
(1, 'Antananarivo-Avaradrano'),
(1, 'Antananarivo-Renivohitra'),
(2, 'Antsirabe I'),
(2, 'Antsirabe II'),
(2, 'Betafo'),
(2, 'Manandriana'),
(2, 'Mandoto'),
(2, 'Vakinankaratra'),
(3, 'Arivonimamo'),
(3, 'Miarinarivo'),
(3, 'Soavinandriana'),
(3, 'Analavory'),
(3, 'Itasy'),
(4, 'Tsiroanomandidy'),
(4, 'Bongolava'),
(4, 'Fenoarivo-Afovoany'),
(4, 'Kandreho'),
(4, 'Maevatanana'),
(5, 'Ambatondrazaka'),
(5, 'Amparafaravola'),
(5, 'Andilamena'),
(5, 'Anosibe An''ala'),
(5, 'Anosiarivo'),
(5, 'Atsinanana'),
(5, 'Atsinanana'),
(5, 'Atsinanana'),
(6, 'Andapa'),  
(6, 'Antalaha'),
(6, 'Sambava'),
(6, 'Vohemar'),
(7, 'Antsiranana I'),
(7, 'Antsiranana II'),
(7, 'Ambanja'),
(7, 'Ambilobe'),
(7, 'Andapa'),
(7, 'Ankazobe'),
(8, 'Befandriana-Nord'),
(8, 'Befandriana-Sud'),
(8, 'Boriziny-Vaovao'),
(8, 'Maroantsetra'),
(8, 'Mandritsara'),
(8, 'Sambava'),
(9, 'Mahajanga I'),
(9, 'Mahajanga II'),
(9, 'Ambato-Boeni'),
(9, 'Boeny'); 

INSERT INTO Commune (id_district, nom) VALUES 
(1, 'Isoraka'),
(1, 'Analakely'),
(1, 'Ankadimbahoaka'),
(1, 'Anosibe'),
(1, 'Andohalo'),
(2, 'Ivato'),
(2, 'Alakamisy Ambohijato'),
(2, 'Ambohitrimanjaka'),
(2, 'Ambohimanarina'),
(2, 'Ambohimalaza'),
(3, 'Andramasina'),
(3, 'Ampangabe'),
(3, 'Anjoma Ramartina'),
(3, 'Anjoma Betoetra'),
(3, 'Andohariana'),
(4, 'Anjozorobe'),
(4, 'Alakamisy Anativolo'),
(4, 'Ambatomanga'),
(4, 'Andranomanelatra'),
(4, 'Ankazobe'),
(5, 'Antananarivo-Atsimondrano'),
(5, 'Alasora'),
(5, 'Ambohidrapeto'),
(5, 'Ampitatafika'),
(5, 'Andoharanofotsy'),
(6, 'Antananarivo-Avaradrano'),
(6, 'Alatsinainy Ambazaha'),
(6, 'Ambohimanarina'),
(6, 'Ambohimalaza'),
(6, 'Ambohitrimanjaka'),
(7, 'Antananarivo-Renivohitra'),
(7, 'Ankazobe'),
(7, 'Andramasina'),
(7, 'Anjozorobe'),
(7, 'Antananarivo-Atsimondrano'),
(8, 'Antsirabe I'),
(8, 'Antsirabe II'),
(8, 'Betafo'),
(8, 'Manandriana'),
(8, 'Mandoto'),
(8, 'Vakinankaratra'),
(9, 'Arivonimamo'),
(9, 'Miarinarivo'),
(9, 'Soavinandriana'),
(9, 'Analavory'),
(9, 'Itasy'),
(10, 'Tsiroanomandidy');