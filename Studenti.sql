CREATE TABLE  IF NOT EXISTS school_students(
	id SERIAL PRIMARY KEY,
	name VARCHAR NOT NULL,
	lastname VARCHAR NOT NULL,
	gender CHAR(1) NOT NULL CHECK (gender IN ('m', 'f')),
	birthdate DATE NOT NULL,
	avg INT NOT NULL,
	min_vote INT NOT NULL,
	max_vote INT NOT NULL
);

SELECT * FROM school_students;