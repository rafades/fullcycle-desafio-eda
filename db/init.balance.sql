CREATE DATABASE IF NOT EXISTS balance;

CREATE TABLE IF NOT EXISTS balance.balance (
  id INT AUTO_INCREMENT PRIMARY KEY,
  account_id VARCHAR(255) NOT NULL ,
  balance DOUBLE(18, 2),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);