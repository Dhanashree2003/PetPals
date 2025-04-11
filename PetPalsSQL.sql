-- create database
create database if not exists PetPals;
use PetPals;


-- Pets table
create table Pets (
    PetID int primary key,
    Name varchar(255),
    Age int,
    Breed varchar(255),
    Available boolean
);

-- Donations table
create table Donations (
    DonationID int auto_increment primary key,
    DonorName varchar(255),
    DonationType enum('cash', 'item'),
    DonationAmount decimal(10,2),
    DonationItem varchar(255),
    DonationDate datetime
);

-- AdoptionEvents table
create table AdoptionEvents (
    EventID int auto_increment primary key,
    EventName varchar(255),
    EventDate datetime,
    Location varchar(255)
);

-- Shelters table
create table Shelters (
    shelterid int primary key,
    name varchar(255),
    location varchar(255)
);

-- Participants table
create table Participants (
    ParticipantID int auto_increment primary key,
    ParticipantName varchar(255),
    ParticipantType enum('adopter', 'shelter'),
    EventID int,
    foreign key (eventid) references adoptionevents(eventid)

);

-- Insert into Pets table
insert into Pets (PetID, Name, Age, Breed, Available) values
(1, 'Ramu', 3, 'Rajapalayam', true),
(2, 'Meena', 2, 'Siamese', true),
(3, 'Tommy', 5, 'Kanni', false),
(4, 'Kavi', 1, 'Indian Spitz', true),
(5, 'Kutty', 4, 'Pariah', true);

-- Insert into Donations table
insert into Donations (DonorName, DonationType, DonationAmount, DonationItem, DonationDate) values
('Raj', 'cash', 500.00, null, now()),
('Devi', 'item', null, 'Pet food', now()),
('Vikram', 'cash', 1000.00, null, now()),
('Revathi', 'item', null, 'Dog bed', now()),
('Anbu', 'cash', 750.00, null, now());

-- Insert into AdoptionEvents table
insert into AdoptionEvents (EventName, Location) values
('Pongal Pet Mela', 'Chennai Trade Centre'),
('Summer Shelter Fest', 'Coimbatore Town Hall'),
('Diwali Pet Drive', 'Trichy SPCA'),
('Pet Seva Sammelan', 'Madurai Collector Ground'),
('Tamil Nadu Rescue Meet', 'Salem Civic Center');


-- Insert into Shelters table
insert into Shelters (shelterid, name, location) values
(1, 'Sanjeevani Animal Shelter', '15 MG Road, Pune'),
(2, 'Paws of Hope Foundation', '22 Anna Salai, Chennai'),
(3, 'Jeevdaya Pet Care', '8 Park Street, Kolkata'),
(4, 'Karuna Animal Rescue', '41 Bannerghatta Road, Bengaluru'),
(5, 'Anbu Pet Shelter', '5 RK Mutt Road, Mylapore, Chennai');


-- Insert into Participants table
insert into Participants (ParticipantName, ParticipantType, EventID) values
('Sarvodaya Shelter', 'shelter', 1),
('Ramya', 'adopter', 2),
('Pets Rescue', 'shelter', 3),
('Suresh', 'adopter', 4),
('New Pets Foundation', 'shelter', 5);


select * from pets;
select * from donations;
select * from participants;
select * from adoptionevents;
select * from shelters;