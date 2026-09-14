CREATE DATABASE IF NOT EXISTS levelup;
USE levelup;

CREATE TABLE cliente (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefono VARCHAR(20),
    direccion VARCHAR(150),
    fecha_registro DATE
);

CREATE TABLE categoria (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(150)
);

CREATE TABLE producto (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(200),
    precio DECIMAL(8,2) NOT NULL,
    stock INT NOT NULL,
    tipo_producto VARCHAR(50),
    id_categoria INT,
    FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria)
);

CREATE TABLE pedido (
    id_pedido INT AUTO_INCREMENT PRIMARY KEY,
    fecha_pedido DATE NOT NULL,
    estado VARCHAR(50),
    total DECIMAL(10,2),
    id_cliente INT,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
);

CREATE TABLE detalle_pedido (
    id_detalle INT AUTO_INCREMENT PRIMARY KEY,
    id_pedido INT,
    id_producto INT,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(8,2) NOT NULL,
    subtotal DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (id_pedido) REFERENCES pedido(id_pedido),
    FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
);

INSERT INTO cliente (nombre, apellidos, email, telefono, direccion, fecha_registro) VALUES
('Carlos', 'Martínez López', 'carlos@email.com', '600123456', 'Madrid', '2026-01-10'),
('Laura', 'Gómez Sánchez', 'laura@email.com', '611234567', 'Getafe', '2026-01-15'),
('David', 'Fernández Ruiz', 'david@email.com', '622345678', 'Leganés', '2026-02-01');

INSERT INTO categoria (nombre, descripcion) VALUES
('Videojuegos', 'Juegos de diferentes plataformas'),
('Consolas', 'Consolas gaming'),
('Merchandising', 'Productos gaming');

INSERT INTO producto (nombre, descripcion, precio, stock, tipo_producto, id_categoria) VALUES
('EA Sports FC 26', 'Juego de fútbol', 69.99, 20, 'Videojuego', 1),
('PlayStation 5', 'Consola Sony', 499.99, 10, 'Consola', 2),
('Figura Mario', 'Figura decorativa', 24.99, 30, 'Merchandising', 3);

INSERT INTO pedido (fecha_pedido, estado, total, id_cliente) VALUES
('2026-03-10', 'Entregado', 69.99, 1),
('2026-03-12', 'Pendiente', 499.99, 2);

INSERT INTO detalle_pedido (id_pedido, id_producto, cantidad, precio_unitario, subtotal) VALUES
(1, 1, 1, 69.99, 69.99),
(2, 2, 1, 499.99, 499.99);


