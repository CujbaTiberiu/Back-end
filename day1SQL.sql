CREATE TABLE Clienti(
	NumeroCliente SERIAL NOT NULL PRIMARY KEY,
	Nome VARCHAR NOT NULL,
	Cognome VARCHAR NOT NULL,
	DataNascita DATE NOT NULL,
	RegioneResidenza VARCHAR NOT NULL
)

CREATE TABLE Fornitori(
	NumeroFornitore SERIAL NOT NULL PRIMARY KEY,
	Denominazione VARCHAR NOT NULL,
	RegioneResidenza VARCHAR NOT NULL
)

/*DROP TABLE Prodotti; */

CREATE TABLE Prodotti(
	IdProdotto SERIAL NOT NULL PRIMARY KEY,
	Descrizione VARCHAR NOT NULL,
	InProduzione VARCHAR NOT NULL,
	InCommercio VARCHAR NOT NULL,
	DataAttivazione DATE NOT NULL,
	DataDisattivazione DATE NOT NULL
)
DROP TABLE Fatture;

CREATE TABLE Fatture(
	NumeroFatture SERIAL NOT NULL PRIMARY KEY,
	Tipologia VARCHAR NOT NULL,
	Importo INTEGER NOT NULL,
	Iva INTEGER NOT NULL,
	IdCliente INTEGER NOT NULL,
	DataFattura DATE NOT NULL,
	NumeroFornitore INTEGER NOT NULL,
	CONSTRAINT IdCliente_FK FOREIGN KEY (IdCliente) REFERENCES Clienti (NumeroCliente),
	CONSTRAINT NumeroFornitore_FK FOREIGN KEY (NumeroFornitore) REFERENCES Fornitori (NumeroFornitore)
)

INSERT INTO Clienti (Nome, Cognome, DataNascita, RegioneResidenza)
VALUES ('Giuseppe', 'Verdi', TO_DATE('01-02-1990', 'DD-MM-YYYY'), 'Toscana');
INSERT INTO Clienti (Nome, Cognome, DataNascita, RegioneResidenza)
VALUES ('Franco', 'Bruni', TO_DATE('12-10-1960', 'DD-MM-YYYY'), 'Lombardia');
INSERT INTO Clienti (Nome, Cognome, DataNascita, RegioneResidenza)
VALUES ('Franco', 'Bruni', TO_DATE('15-01-1974', 'DD-MM-YYYY'), 'Lombardia');
INSERT INTO Clienti (Nome, Cognome, DataNascita, RegioneResidenza)
VALUES ('Michele', 'Rossi', TO_DATE('21-11-1985', 'DD-MM-YYYY'), 'Calabria');
INSERT INTO Clienti (Nome, Cognome, DataNascita, RegioneResidenza)
VALUES ('Antonio', 'Neri', ('20-11-1995'), 'Calabria');


INSERT INTO Fornitori(Denominazione, RegioneResidenza)
VALUES('PrimoFornitore', 'Puglia');
INSERT INTO Fornitori(Denominazione, RegioneResidenza)
VALUES('SecondoFornitore', 'Umbria');
INSERT INTO Fornitori(Denominazione, RegioneResidenza)
VALUES('TerzoFornitore', 'Abruzzo');
INSERT INTO Fornitori(Denominazione, RegioneResidenza)
VALUES('QuartoFornitore', 'Lombardia');

/*TRUNCATE TABLE Prodotti;*/
INSERT INTO Prodotti (Descrizione, InProduzione, InCommercio, DataAttivazione, DataDisattivazione)
VALUES ('Tablet', 'SI', 'SI', TO_DATE('10-02-2016', 'DD-MM-YYYY'), TO_DATE('01-02-2018', 'DD-MM-YYYY'));
INSERT INTO Prodotti (Descrizione, InProduzione, InCommercio, DataAttivazione, DataDisattivazione)
VALUES ('Monitor', 'NO', 'NO', TO_DATE('10-02-2016', 'DD-MM-YYYY'), TO_DATE('01-02-2020', 'DD-MM-YYYY'));
INSERT INTO Prodotti (Descrizione, InProduzione, InCommercio, DataAttivazione, DataDisattivazione)
VALUES ('Mouse', 'NO', 'SI', TO_DATE('10-02-2016', 'DD-MM-YYYY'), TO_DATE('01-02-2019', 'DD-MM-YYYY'));
INSERT INTO Prodotti (Descrizione, InProduzione, InCommercio, DataAttivazione, DataDisattivazione)
VALUES ('Tastiera', 'SI', 'NO', TO_DATE('10-02-2016', 'DD-MM-YYYY'), TO_DATE('01-02-2022', 'DD-MM-YYYY'));


INSERT INTO Fatture(Tipologia, Importo, Iva, IdCliente, DataFattura, NumeroFornitore)
VALUES('A', 100, 15, 1,  TO_DATE('01-01-2018', 'DD-MM-YYYY'), 2);
INSERT INTO Fatture(Tipologia, Importo, Iva, IdCliente, DataFattura, NumeroFornitore)
VALUES('B', 300, 25, 3,  TO_DATE('01-01-2019', 'DD-MM-YYYY'), 1);
INSERT INTO Fatture(Tipologia, Importo, Iva, IdCliente, DataFattura, NumeroFornitore)
VALUES('A', 40, 10, 2,  TO_DATE('01-11-2018', 'DD-MM-YYYY'), 3);
INSERT INTO Fatture(Tipologia, Importo, Iva, IdCliente, DataFattura, NumeroFornitore)
VALUES('C', 20, 21, 1,  TO_DATE('01-05-2018', 'DD-MM-YYYY'), 4);


SELECT * FROM Clienti;
SELECT * FROM Fornitori;
SELECT * FROM Prodotti;
SELECT * FROM Fatture;
-- 1
SELECT Nome, Cognome FROM Clienti WHERE DataNascita >= '01.01.1982';
SELECT Nome, Cognome FROM Clienti WHERE EXTRACT(YEAR FROM DataNascita) = '1990';

-- 2
SELECT count(*) AS num_fatt_21 FROM Fatture WHERE Iva = 21;

-- 3 
SELECT NumeroFatture ,Importo, DataFattura FROM Fatture WHERE Importo > 0;

SELECT 
EXTRACT(YEAR FROM DataFattura) AS anno,
count(*) AS num_fatt, 
SUM(Importo) AS importo_tot
FROM fatture 
GROUP BY EXTRACT(YEAR FROM DataFattura);

-- 4
SELECT * FROM Prodotti WHERE EXTRACT(YEAR FROM DataAttivazione) = 2016
AND (InProduzione = 'SI' OR InCommercio = 'SI');

-- 5

SELECT EXTRACT(YEAR FROM DataFattura) AS anno, COUNT(*) AS num_fatt FROM Fatture WHERE Iva = 20 GROUP BY EXTRACT(YEAR FROM DataFattura);

-- 6
SELECT EXTRACT(YEAR FROM DataFattura) AS anno,
COUNT(*) AS num_fatt_a
FROM Fatture WHERE Tipologia = 'A'
GROUP BY EXTRACT(YEAR FROM DataFattura)
HAVING COUNT(*) > 1;

-- 7
SELECT NumeroFatture, Importo, Iva, DataFattura, Denominazione FROM Fatture AS fa INNER JOIN Fornitori AS fo 
ON fo.NumeroFornitore = fo.NumeroFornitore;






