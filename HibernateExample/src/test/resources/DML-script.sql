SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE pracownik_has_projekt;
TRUNCATE TABLE pracownik;
TRUNCATE TABLE dzial; 
TRUNCATE TABLE projekt;  

SET FOREIGN_KEY_CHECKS = 1;

-- SELECT * FROM DZIAL;

INSERT INTO dzial (nazwa_dzialu)
	VALUES ('Package Based Solutions'), ('Wasilewski'), ('Auto'), ('Nearshore Test Center'), ('Zaremba');
    
INSERT INTO pracownik (imie, nazwisko, data_urodzenia, pesel, dzial_iddzial)
	VALUES
    ('Jan', 'Kowalski', '1990-01-20', '90012052342', 1),
    ('Mariusz', 'Kopeć', '1982-01-22', '82012242343', 2),
    ('Józef', 'Nowakowski', '1972-04-10', '72041023411', 3),
    ('Anna', 'German', '1968-02-14', '68021489231', DEFAULT),
    ('Tadeusz', 'Panski', '1931-10-30', '31103041231', 5),
    ('Marek', 'Jurek', '1975-02-13', '75021334421', 4),
    ('Beata', 'Szydełko', '1990-04-04', '90040442211', 3),
    ('Roman', 'Abramowicz', '1966-10-24', '66102453344', 5);
    


INSERT INTO projekt (nazwa, czy_wewnetrzny)
	VALUES
    ('Projekt AngularJS', 1),
    ('Projekt GuideWire', 1),
    ('Projekt Automoto', 0),
    ('System płatniczy dla VISA', 1),
    ('StarterKit', 1);
 
 INSERT INTO pracownik_has_projekt (pracownik_id_pracownik, projekt_id_projekt, data_rozpoczecia, data_zakonczenia, stawka_dzienna, rola)
	VALUES
    (1, 1, '2016-01-20', NULL , '220.90', 'PL'), -- kierownik
    (2, 2, '2014-05-10', '2015-10-04' , '150.50', 'PL'), -- kierownik
    (3, 3, '2015-10-04', '2016-05-04' , '170.00', 'PL'), -- kierownik
	(3, 4, '2014-12-04', '2015-10-03', '170.00', 'PL'), -- kierownik
    (4, 4, '2013-01-01', NULL , '320.10', 'PL'), -- kierownik
    
    (5, 5, '2015-01-03', NULL , '100.99', 'TCD'),
    (5, 1, '2013-02-03', NULL , '100.99', 'TCD'),
    (5, 2, '2014-03-03', NULL , '100.99', 'TCD'), 
    (5, 3, '2015-04-03', NULL , '100.99', 'TCD'),

    (6, 4, '2012-05-03', '2015-06-23' , '100.99', 'FCD'),
    (6, 1, '2013-03-03', '2014-06-23' , '100.99', 'FCD'),
    
    (6, 2, '2014-03-01', '2015-06-23', '100.99', 'DEV'), 
    (6, 3, '2015-06-23', NULL , '100.99', 'DEV'), 
    (6, 4, '2016-03-03', NULL , '100.99', 'DEV'), 
    (7, 5, '2014-07-03', NULL , '100.99', 'DEV'), 
    (7, 1, '2015-03-23', NULL , '100.99', 'DEV'), 
    (7, 2, '2015-08-01', '2015-12-23' , '100.99', 'DEV'), 
    (8, 3, '2015-08-03', NULL , '100.99', 'DEV'), 
    (8, 4, '2014-05-03', '2015-07-23' , '100.99', 'DEV'), 
    (1, 5, '2014-09-03', NULL , '100.99', 'DEV'), 
    (5, 1, '2015-03-03', NULL , '100.99', 'DEV'), 
    (5, 2, '2015-03-03', '2016-06-23' , '100.99', 'DEV');
    