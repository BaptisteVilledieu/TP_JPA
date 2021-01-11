-- Initialisation spécifiques pour un jeu de test
INSERT INTO Galerie(id, nom, adresse) VALUES (1, 'Saatchi', 'King\''s Road, Londres');
INSERT INTO Galerie(id, nom, adresse) VALUES (2, 'Louvre', 'Musée du Louvre, Paris');
INSERT INTO Personne(id,nom,adresse) VALUES (1, 'Fourcade','5 rue des Pyrennees, Castres');
INSERT INTO Personne(id,nom,adresse) VALUES (2, 'Jacquelin', '4 rue des Alpes, Annecy');
INSERT INTO Personne(id,nom,adresse) VALUES (3,'De Vinci','5 rue de Naples, Florence');
INSERT INTO Personne(id,nom,adresse) VALUES (4,'Picasso','5 rue de Barcelone, Madrid');
INSERT INTO Personne(id,nom,adresse) VALUES (5,'Dali','5 rue de Valence, Grenade');
INSERT INTO Artiste(id,biographie) VALUES (4,'Je suis espagnol');
INSERT INTO Artiste(id,biographie) VALUES (3, 'C est moi qui ai fait la Joconde');
INSERT INTO Artiste(id,biographie) VALUES (5, 'J adore la mer');
INSERT INTO Exposition(id,debut,intitule,duree,organisateur) VALUES (1,LocalDate.of(2020,Month.MARCH,15),'Renaissance',30,2);
INSERT INTO Exposition(id,debut,intitule,duree,organisateur) VALUES (2,LocalDate.of(2020,Month.JUNE,12),'Cubisme',60,2);
INSERT INTO Tableau(id,titre,support,largeur,hauteur,auteur) VALUES (1,'La Joconde','toile',100,20,3);
INSERT INTO Tableau(id,titre,support,largeur,hauteur,auteur) VALUES (2,'Guernica','toile',80,40,4);
INSERT INTO Tableau(id,titre,support,largeur,hauteur,auteur) VALUES (3,'La persistance de la memoire','peinture',90,40,5);
INSERT INTO Transaction(id,venduLe,prixVente,lieuDeVente,client,oeuvre) VALUES (1,LocalDate.of(2020,Month.MARCH,20),5000000,1,2,1);
INSERT INTO Transaction(id,venduLe,prixVente,lieuDeVente,client,oeuvre) VALUES (2,LocalDate.of(2020,Month.JULY,20),1000000,2,1,2);
INSERT INTO Transaction(id,venduLe,prixVente,lieuDeVente,client,oeuvre) VALUES (3,LocalDate.of(2020,Month.JULY,30),2000000,1,1,3);