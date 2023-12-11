#CREATE DATABASE saras_dealership;

#create tables
CREATE TABLE dealerships(
dealershipID INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50),
address VARCHAR(50),
phone VARCHAR(12)

);

CREATE TABLE vehicles(
VIN VARCHAR(17) PRIMARY KEY,
make VARCHAR(250),
model VARCHAR(250),
sold BIT

);

CREATE TABLE inventory(
dealershipID INT,
VIN INT,
FOREIGN KEY (VIN) REFERENCES vehicles (VIN),
FOREIGN KEY (dealershipID) REFERENCES dealerships (dealershipID)
);

CREATE TABLE sales_contracts(
saleID INT AUTO_INCREMENT PRIMARY KEY, 
VIN VARCHAR(17),
purchase_price INT,
FOREIGN KEY (VIN) REFERENCES vehicles(VIN)

);

CREATE TABLE lease_contracts(
leaseID INT AUTO_INCREMENT PRIMARY KEY,
VIN VARCHAR(17),
lease_term INT,
FOREIGN KEY (VIN) REFERENCES vehicles(VIN),  
FOREIGN KEY (dealershipID) REFERENCES vehicles(VIN)

);

#INSERT SAMPLE DATA
#INSERT INTO vehicles (VIN, make, model, sold)
#VALUES
#('1HGCM82633A123456', 'Honda', 'Civic', false),
#('5XYZU3LBXGG123789', 'AUdi', 'A7', false),
#('JH4DC2381RS012345', 'Volkswagen', 'Jetta', true);

#INSERT INTO inventory (dealershipID, VIN)
#VALUES
#('327805', '1HGCM82633A123456'),
#('250959', '5XYZU3LBXGG123789'),
#('258537', 'JH4DC2381RS012345');

#INSERT INTO sales_contracts (VIN, purchase_price)
#VALUES
#('1HGCM82633A123456', 25000),
#('5XYZU3LBXGG123789', 30000),
#('JH4DC2381RS012345', 18000);

#INSERT INTO lease_contracts (VIN, lease_term)
#VALUES
#('1HGCM82633A123456', 36),
#('5XYZU3LBXGG123789', 24),
#('JH4DC2381RS012345', 48);
  
#INSERT INTO dealerships (name, address, phone)
#VALUES
#('OHlive Motors', '123 Main Street', '469-247-8536'),
#('Blues Cars', '456 Oak Avenue', '469-247-8536'),
#('C&J Auto', '789 Elm Road', '214-994-2655');

#GET ALL DEALERSHIPS
SELECT *
FROM dealerships;

#FIND ALL VEHICLES FOR A SPECIFIC DEALERSHIP
SELECT * 
FROM vehicles
JOIN inventory ON vehicles.VIN = inventory.VIN
JOIN dealerships ON inventory.dealershipID = dealerships.dealershipID;

#FIND A CAR BY VIN
SELECT * 
FROM vehicles
WHERE VIN = '1HGCM82633A123456';


#FIND THE DEALERSHIP WHERE A CERTAIN CAR IS LOCATED BY VIN
SELECT *
FROM dealerships
JOIN inventory ON dealerships.delaershipID = inventory.dealershipID
WHERE VIN = '1HGCM82633A123456';

#FIND ALL DEALERSHIP THAT HAVE A CERTAIN CAR TYPE
SELECT *
FROM dealerships
JOIN inventory ON dealerships.DealershipID = inventory.dealershipID
JOIN vehicles ON inventory.VIN = vehicles.VIN
WHERE vehicles.make = 'Audi' AND vehicles.model = 'A7';

#GET ALL SALES INFORMATION FOR A SPECIFIC DEALER FOR A SPECIFIC DATE RANGE
SELECT *
FROM sales_contract
JOIN dealerships ON sales_contract.dealershipID = dealerships.DealershipID
WHERE #not sure what to put here to find the dates

