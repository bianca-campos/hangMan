

CREATE TABLE category
	-- This table storages the informations about categories
	(id INTEGER PRIMARY KEY, -- Unique ID
		name text NOT NULL-- Name of the category
		);

CREATE TABLE level
	-- This table storages the informations about level
	(
		id INTEGER PRIMARY KEY, -- Unique ID
		name VARCHAR(50) NOT NULL, -- Name of the level
		minLetter INTEGER NOT NULL, -- Number minimun of letters
		maxLetter INTEGER NOT NULL, -- Number maximun of letters
		numTry INTEGER NOT NULL, -- Number of try
		pointsLetter INTEGER NOT NULL, -- Number of points per letter
		extraPoints INTEGER NOT NULL -- Number of extra points per game
	);

CREATE TABLE word
	-- This table storages the informations about word
	(
		id INTEGER PRIMARY KEY, -- Unique ID
		name VARCHAR(50) NOT NULL, -- Name of the word
		FOREIGN KEY(idLevel) REFERENCES Level(id) -- FK Level table
		FOREIGN KEY(idCategory) REFERENCES Category(id) -- FK Category table
	);

CREATE TABLE player
	-- This table storages the informations about the Player
	( 
		id INTEGER PRIMARY KEY, -- Unique ID
		name VARCHAR(50) NOT NULL-- Name of the player
	);

CREATE TABLE score
	-- This table storages the informations about the Score
	( 
		id INTEGER PRIMARY KEY, -- Unique ID
		score INTEGER NOT NULL, -- Score of the Player
		FOREIGN KEY(idPlayer) REFERENCES Player(id) -- FK Player table
	);




