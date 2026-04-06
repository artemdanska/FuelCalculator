CREATE DATABASE IF NOT EXISTS fuel_calculator_localization
CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE fuel_calculator_localization;

CREATE TABLE calculation_records (
    id INT AUTO_INCREMENT PRIMARY KEY,
    distance DOUBLE NOT NULL,
    consumption DOUBLE NOT NULL,
    price DOUBLE NOT NULL,
    total_fuel DOUBLE NOT NULL,
    total_cost DOUBLE NOT NULL,
    language VARCHAR(10),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE localization_strings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    `key` VARCHAR(100) NOT NULL,
    value VARCHAR(255) NOT NULL,
    language VARCHAR(10) NOT NULL,
    UNIQUE KEY unique_key_lang (`key`, `language`)
);

INSERT INTO localization_strings (`key`, value, language) VALUES

('title', 'Fuel Calculator', 'en'),
('calculate', 'Calculate', 'en'),
('distance', 'Distance', 'en'),
('consumption', 'Consumption', 'en'),
('price', 'Fuel Price', 'en'),
('result', 'Total cost is', 'en'),
('error', 'Invalid input', 'en'),

('title', 'Calculateur de carburant', 'fr'),
('calculate', 'Calculer', 'fr'),
('distance', 'Distance', 'fr'),
('consumption', 'Consommation', 'fr'),
('price', 'Prix du carburant', 'fr'),
('result', 'Le coût total est', 'fr'),
('error', 'Entrée invalide', 'fr'),

('title', '燃料計算機', 'jp'),
('calculate', '計算する', 'jp'),
('distance', '距離', 'jp'),
('consumption', '消費量', 'jp'),
('price', '燃料価格', 'jp'),
('result', '合計費用', 'jp'),
('error', '無効な入力', 'jp'),

('title', 'ماشین حساب سوخت', 'ir'),
('calculate', 'محاسبه', 'ir'),
('distance', 'مسافت', 'ir'),
('consumption', 'مصرف', 'ir'),
('price', 'قیمت سوخت', 'ir'),
('result', 'هزینه کل', 'ir'),
('error', 'ورودی نامعتبر', 'ir');