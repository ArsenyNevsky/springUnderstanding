/*CREATE TABLE Person (
  id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  firstname VARCHAR(30)
);

CREATE TABLE Phone (
  id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  number VARCHAR(12),
  person_id INT,
  FOREIGN KEY (person_id) REFERENCES Person(id)
);

-- test inheritance
CREATE TABLE Account (
  id INT PRIMARY KEY,
  owner VARCHAR(30),
  balance INT
);

CREATE TABLE CREDITACCOUNT (
  id INT PRIMARY KEY,
  credit_limit INT,
  closed BOOLEAN,
  FOREIGN KEY(id) REFERENCES Account(id)
);

CREATE TABLE DEBITACCOUNT (
  id INT PRIMARY KEY,
  overdraft_fee INT,
  FOREIGN KEY(id) REFERENCES Account(id)
);
*/