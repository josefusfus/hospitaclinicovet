DROP TABLE IF EXISTS ingreso;
DROP TABLE IF EXISTS mascota;

CREATE TABLE mascota (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    especie VARCHAR(255),
    raza VARCHAR(255),
    edad INT,
    codigo_identificacion VARCHAR(255),
    dni_responsable VARCHAR(255)
);

CREATE TABLE ingreso (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fecha_alta_ingreso DATE,
    fecha_fin_ingreso DATE,
    estado VARCHAR(255),
    mascota_id BIGINT,
    dni_registrador VARCHAR(255),
    CONSTRAINT fk_mascota FOREIGN KEY (mascota_id) REFERENCES mascota(id)
);


-- Insertar Mascotas
INSERT INTO mascota (especie, raza, edad, codigo_identificacion, dni_responsable) VALUES 
('Perro', 'Labrador', 3, 'ABC123', '12345678A'),
('Gato', 'Siamés', 2, 'DEF456', '23456789B'),
('Perro', 'Bulldog', 4, 'GHI789', '34567890C'),
('Ave', 'Canario', 1, 'JKL012', '45678901D'),
('Perro', 'Poodle', 5, 'MNO345', '56789012E');

-- Insertar más registros de mascotas
INSERT INTO mascota (especie, raza, edad, codigo_identificacion, dni_responsable) VALUES 
('Perro', 'Beagle', 2, 'XYZ006', '00000006A'),
('Gato', 'Persa', 3, 'XYZ007', '00000007A'),
('Perro', 'Chihuahua', 1, 'XYZ008', '00000008A'),
('Ave', 'Periquito', 2, 'XYZ009', '00000009A'),
('Gato', 'Maine Coon', 4, 'XYZ010', '00000010A');

-- Repetir para llegar a 50 registros
INSERT INTO mascota (especie, raza, edad, codigo_identificacion, dni_responsable) VALUES 
('Perro', 'Boxer', 3, 'XYZ011', '00000011A'),
('Gato', 'Sphynx', 2, 'XYZ012', '00000012A'),
('Perro', 'Dachshund', 4, 'XYZ013', '00000013A'),
('Ave', 'Cotorra', 1, 'XYZ014', '00000014A'),
('Perro', 'Husky', 5, 'XYZ015', '00000015A'),
('Perro', 'Golden Retriever', 3, 'XYZ016', '00000016A'),
('Gato', 'Birmano', 2, 'XYZ017', '00000017A'),
('Perro', 'Pastor Alemán', 4, 'XYZ018', '00000018A'),
('Ave', 'Agaporni', 1, 'XYZ019', '00000019A'),
('Gato', 'Angora', 5, 'XYZ020', '00000020A'),
('Perro', 'San Bernardo', 3, 'XYZ021', '00000021A'),
('Gato', 'Chartreux', 2, 'XYZ022', '00000022A'),
('Perro', 'Galgo', 4, 'XYZ023', '00000023A'),
('Ave', 'Loro', 1, 'XYZ024', '00000024A'),
('Perro', 'Shih Tzu', 5, 'XYZ025', '00000025A'),
('Perro', 'Cocker Spaniel', 3, 'XYZ026', '00000026A'),
('Gato', 'Exótico', 2, 'XYZ027', '00000027A'),
('Perro', 'Akita', 4, 'XYZ028', '00000028A'),
('Ave', 'Ganso', 1, 'XYZ029', '00000029A'),
('Gato', 'Ragdoll', 5, 'XYZ030', '00000030A'),
('Perro', 'Mastín', 3, 'XYZ031', '00000031A'),
('Gato', 'Siberiano', 2, 'XYZ032', '00000032A'),
('Perro', 'Terrier', 4, 'XYZ033', '00000033A'),
('Ave', 'Paloma', 1, 'XYZ034', '00000034A'),
('Perro', 'Salchicha', 5, 'XYZ035', '00000035A'),
('Perro', 'Labrador', 3, 'XYZ036', '00000036A'),
('Gato', 'Siamés', 2, 'XYZ037', '00000037A'),
('Perro', 'Bulldog', 4, 'XYZ038', '00000038A'),
('Ave', 'Canario', 1, 'XYZ039', '00000039A'),
('Perro', 'Poodle', 5, 'XYZ040', '00000040A'),
('Perro', 'Beagle', 2, 'XYZ041', '00000041A'),
('Gato', 'Persa', 3, 'XYZ042', '00000042A'),
('Perro', 'Chihuahua', 1, 'XYZ043', '00000043A'),
('Ave', 'Periquito', 2, 'XYZ044', '00000044A'),
('Gato', 'Maine Coon', 4, 'XYZ045', '00000045A'),
('Perro', 'Boxer', 3, 'XYZ046', '00000046A'),
('Gato', 'Sphynx', 2, 'XYZ047', '00000047A'),
('Perro', 'Dachshund', 4, 'XYZ048', '00000048A'),
('Ave', 'Cotorra', 1, 'XYZ049', '00000049A'),
('Perro', 'Husky', 5, 'XYZ050', '00000050A');

-- Insertar Ingresos
INSERT INTO ingreso (fecha_alta_ingreso, fecha_fin_ingreso, estado, mascota_id, dni_registrador) VALUES 
('2023-01-01', '2023-01-10', 'FINALIZADO', 1, '12345678A'),
('2023-02-01', NULL, 'HOSPITALIZACION', 2, '23456789B'),
('2023-03-01', '2023-03-15', 'FINALIZADO', 3, '34567890C'),
('2023-04-01', NULL, 'HOSPITALIZACION', 4, '45678901D'),
('2023-05-01', '2023-05-20', 'FINALIZADO', 5, '56789012E');

-- Insertar más registros de ingresos (50 registros en total)
INSERT INTO ingreso (fecha_alta_ingreso, fecha_fin_ingreso, estado, mascota_id, dni_registrador) VALUES 
('2023-06-01', '2023-06-10', 'FINALIZADO', 6, '00000006A'),
('2023-07-01', NULL, 'HOSPITALIZACION', 7, '00000007A'),
('2023-08-01', '2023-08-15', 'FINALIZADO', 8, '00000008A'),
('2023-09-01', NULL, 'HOSPITALIZACION', 9, '00000009A'),
('2023-10-01', '2023-10-20', 'FINALIZADO', 10, '00000010A'),
('2023-11-01', '2023-11-10', 'FINALIZADO', 11, '00000011A'),
('2023-12-01', NULL, 'HOSPITALIZACION', 12, '00000012A'),
('2024-01-01', '2024-01-15', 'FINALIZADO', 13, '00000013A'),
('2024-02-01', NULL, 'HOSPITALIZACION', 14, '00000014A'),
('2024-03-01', '2024-03-20', 'FINALIZADO', 15, '00000015A'),
('2024-04-01', '2024-04-10', 'FINALIZADO', 16, '00000016A'),
('2024-05-01', NULL, 'HOSPITALIZACION', 17, '00000017A'),
('2024-06-01', '2024-06-15', 'FINALIZADO', 18, '00000018A'),
('2024-07-01', NULL, 'HOSPITALIZACION', 19, '00000019A'),
('2024-08-01', '2024-08-20', 'FINALIZADO', 20, '00000020A'),
('2024-09-01', '2024-09-10', 'FINALIZADO', 21, '00000021A'),
('2024-10-01', NULL, 'HOSPITALIZACION', 22, '00000022A'),
('2024-11-01', '2024-11-15', 'FINALIZADO', 23, '00000023A'),
('2024-12-01', NULL, 'HOSPITALIZACION', 24, '00000024A'),
('2025-01-01', '2025-01-20', 'FINALIZADO', 25, '00000025A'),
('2025-02-01', '2025-02-10', 'FINALIZADO', 26, '00000026A'),
('2025-03-01', NULL, 'HOSPITALIZACION', 27, '00000027A'),
('2025-04-01', '2025-04-15', 'FINALIZADO', 28, '00000028A'),
('2025-05-01', NULL, 'HOSPITALIZACION', 29, '00000029A'),
('2025-06-01', '2025-06-20', 'FINALIZADO', 30, '00000030A'),
('2025-07-01', '2025-07-10', 'FINALIZADO', 31, '00000031A'),
('2025-08-01', NULL, 'HOSPITALIZACION', 32, '00000032A'),
('2025-09-01', '2025-09-15', 'FINALIZADO', 33, '00000033A'),
('2025-10-01', NULL, 'HOSPITALIZACION', 34, '00000034A'),
('2025-11-01', '2025-11-20', 'FINALIZADO', 35, '00000035A'),
('2025-12-01', '2025-12-10', 'FINALIZADO', 36, '00000036A'),
('2026-01-01', NULL, 'HOSPITALIZACION', 37, '00000037A'),
('2026-02-01', '2026-02-15', 'FINALIZADO', 38, '00000038A'),
('2026-03-01', NULL, 'HOSPITALIZACION', 39, '00000039A'),
('2026-04-01', '2026-04-20', 'FINALIZADO', 40, '00000040A'),
('2026-05-01', '2026-05-10', 'FINALIZADO', 41, '00000041A'),
('2026-06-01', NULL, 'HOSPITALIZACION', 42, '00000042A'),
('2026-07-01', '2026-07-15', 'FINALIZADO', 43, '00000043A'),
('2026-08-01', NULL, 'HOSPITALIZACION', 44, '00000044A'),
('2026-09-01', '2026-09-20', 'FINALIZADO', 45, '00000045A'),
('2026-10-01', '2026-10-10', 'FINALIZADO', 46, '00000046A'),
('2026-11-01', NULL, 'HOSPITALIZACION', 47, '00000047A'),
('2026-12-01', '2026-12-15', 'FINALIZADO', 48, '00000048A'),
('2027-01-01', NULL, 'HOSPITALIZACION', 49, '00000049A'),
('2027-02-01', '2027-02-20', 'FINALIZADO', 50, '00000050A');
