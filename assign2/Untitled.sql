USE assignment2;



/*Land Mass Table */
CREATE TABLE Land_Mass(
	name VARCHAR(35) NOT NULL PRIMARY KEY,
	AREA VARCHAR(35) NOT NULL);


/*Body of water table */
CREATE TABLE Body_Water(
	name VARCHAR(35) NOT NULL PRIMARY KEY,
	area VARCHAR(35) NOT NULL);

/*Continent Connect Table*/
CREATE TABLE CONT_CONNECT(
	CONTINENT VARCHAR(35) NOT NULL,
	CONNECT VARCHAR(35) NOT NULL,
	FOREIGN KEY (CONTINENT) REFERENCES Land_Mass (name));

/*Island Location Table*/
CREATE TABLE ISL_LOCATION(
	ISLAND	VARCHAR(35) NOT NULL,
	OCEAN VARCHAR(35) NOT NULL,
	FOREIGN KEY (ISLAND) REFERENCES Land_Mass (name),
	FOREIGN KEY (OCEAN) REFERENCES Body_Water (name));

/*Island and Continent Seperation Table */
CREATE TABLE CON_SEPERATE(



	CONTINENT VARCHAR(35) NOT NULL,
	ISLAND VARCHAR(35) NOT NULL,
	STRAIT VARCHAR(35) NOT NULL,	
	FOREIGN KEY (CONTINENT) REFERENCES Land_Mass (name),
	FOREIGN KEY (ISLAND) REFERENCES Land_Mass (name),
	FOREIGN KEY (STRAIT) REFERENCES Body_Water (name)); 


INSERT INTO Body_Water VALUES
	#OCEANS
	('Pacific Ocean','60,060,700'),('Atlantic Ocean','29,637,900'),('Indian Ocean','26,469,900'),('Artic Ocean','5,427,000'),('Southern Ocean', '7,848,300'),
	#STRAITS
	('Mozambique Channel', '257,400'), 
	('English Channel','52,500'), ('Balearic Sea','965,300'),
	('South China Sea', '1,351,000'),  ('Malacca Strait', '25,097'), ('East China Sea', '482,200'), ('Sea of Japan', '377,608'),
	('Coral Sea', '1,085,000'),  ('Arafura Sea', '280,000'),  ('Bass Strait', '65,000'),
	('Carribean Sea', '1,006,300'),
	('Gulf of Mexico', '617,800'),
	('Haskell Strait', '500'), ('Drakes Passage', '750');
	

	

INSERT INTO CON_SEPERATE VALUES
	#AFRICA 
	('Africa', 'Madagascar', 'Mozambique Channel'),
	('Africa', 'Comoros', 'Mozambique Channel'),
	('Africa', 'Mayotte', 'Mozambique Channel'),
	('Africa', 'Reunion', 'Mozambique Channel'),
	('Africa', 'Mauritus', 'Mozambique Channel'),
	#EUROPE
	('Europe', 'Ireland', 'English Channel'),
	('Europe', 'United Kingdom', 'English Channel'),
	('Europe', 'Isle of Man', 'English Channel'),
	('Europe', 'Faroe Island', 'English Channel'),
	('Europe', 'Ibiza', 'Balearic Sea'),
	#ASIA
	('Asia', 'Philippines', 'South China Sea'),
	('Asia', 'Malaysia', 'Malacca Strait'),
	('Asia', 'Taiwan', 'East China Sea'),
	('Asia', 'Japan', 'Sea of Japan'),
	('Asia', 'Sapporo', 'Sea of Japan'),
	#AUSTRALIA
	('Australia', 'Vanuatu', 'Coral Sea'),
	('Australia', 'New Caledonia', 'Coral Sea'),
	('Australia', 'Papua New Guinea', 'Arafura Sea'),
	('Australia', 'Indonesia', 'Arafura Sea'),
	('Australia', 'Tasmania', 'Bass Strait'),
	#SOUTH AMERICA
	('South America', 'Cayman Islands', 'Carribean Sea'),
	('South America', 'Jamaica', 'Carribean Sea'),
	('South America', 'Cuba', 'Carribean Sea'),
	('South America', 'Haiti', 'Carribean Sea'),
	('South America', 'Puerto Rico', 'Carribean Sea'),
	#NORTH AMERICA
	('North America', 'Jamaica', 'Gulf of Mexico'),
	('North America', 'Cuba', 'Gulf of Mexico'),
	('North America', 'Haiti', 'Gulf of Mexico'),
	('North America', 'Puerto Rico', 'Gulf of Mexico'),
	('North America', 'Dominican Republic', 'Gulf of Mexico'),
	#ANTARCTICA
	('Antarctica','Dundas Island','Haskell Strait'),
	('Antarctica','Masked Island','Haskell Strait'),
	('Antarctica','Rose Island','Haskell Strait'),
	('Antarctica','Shoe Island','Drakes Passage'),
	('Antarctica','Yule Island','Drakes Passage');



INSERT INTO ISL_LOCATION VALUES 
	('Madagascar','Indian Ocean'),('Comoros','Indian Ocean'), ('Mayotte','Indian Ocean'), ('Reunion','Indian Ocean'), ('Mauritus','Indian Ocean'),
 
	('Ireland','Atlantic Ocean'), ('United Kingdom','Atlantic Ocean'), ('Isle of Man','Atlantic Ocean'), ('Faroe Island','Atlantic Ocean'), ('Ibiza','Atlantic Ocean'),
 
	('Philippines','Pacific Ocean'), ('Malaysia','Pacific Ocean'), ('Taiwan','Pacific Ocean'), ('Japan','Pacific Ocean'), ('Sapporo','Pacific Ocean'),
 
	('Vanuatu','Pacific Ocean'), ('New Caledonia','Pacific Ocean'), ('Papua New Guinea','Pacific Ocean'), ('Indonesia','Pacific Ocean'), ('Tasmania','Pacific Ocean'),
 
	('Cayman Islands','Atlantic Ocean'), ('Jamaica','Atlantic Ocean'), ('Cuba','Atlantic Ocean'), ('Haiti','Atlantic Ocean'), ('Puerto Rico','Atlantic Ocean'), ('Dominican Republic','Atlantic Ocean'),
 
	('Dundas Island','Southern Ocean'),('Masked Island','Southern Ocean'),('Rose Island','Southern Ocean'),('Shoe Island','Southern Ocean'),('Yule Island','Southern Ocean');
 
	

INSERT INTO Land_Mass VALUES
	#Continents
	('Europe', '3,837,000'), ('North America', '9,365,000'),
	('South America', '6,880,000'), ('Asia', '17,212,000'),
	('Antarctica', '5,100,000') , ('Australia', '2,968,000'), 
	('Africa' , '11,608,000'),
	#ISLANDS
	('Madagascar','226,658'), ('Comoros','1,008'), ('Mayotte','144.4'), ('Reunion','970'), ('Mauritus','788'),
	('Ireland','32,595'), ('United Kingdom','93,628'), ('Isle of Man','220.9'), ('Faroe Island','540'), ('Ibiza','220.7'),
	('Philippines','115,831'), ('Malaysia','127,724'), ('Taiwan','13,974'), ('Japan','145,932'), ('Sapporo','433'),
	('Vanuatu','4,706'), ('New Caledonia','7,172'), ('Papua New Guinea','178,704'), ('Indonesia','735,400'), ('Tasmania','26,410'),
	('Cayman Islands','101.9'), ('Jamaica','4,244'), ('Cuba','42,426'), ('Haiti','10,714'), ('Puerto Rico','3,515'), ('Dominican Republic','18,704'),
	('Dundas Island','560'),('Masked Island','1,201'),('Rose Island','750'),('Shoe Island','300'),('Yule Island','1,400');
 



INSERT INTO CONT_CONNECT VALUES
	('North America', 'South America'), ('Africa', 'Asia'), ('Europe', 'Asia') , ('Europe', 'Africa') , ('Australia', 'Nothing'), ('Antarctica', 'Nothing');

#SELECT *
#FROM CON_SEPERATE;
#SELECT Land_Mass.name AS Continent, Land_Mass.AREA AS Area, CONT_CONNECT.CONNECT AS 'Connected to', CON_SEPERATE.STRAIT AS 'Strait Seperates ->', CON_SEPERATE.ISLAND
#FROM Land_Mass, CONT_CONNECT, CON_SEPERATE
#WHERE Land_Mass.name = CONT_CONNECT.CONTINENT AND Land_Mass.name = CON_SEPERATE.CONTINENT;

DROP TABLE Body_Water;

