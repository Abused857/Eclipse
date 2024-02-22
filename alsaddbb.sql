-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-02-2024 a las 15:06:39
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `alsa`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autobus`
--

CREATE TABLE `autobus` (
  `id` binary(16) NOT NULL,
  `modelo` varchar(255) DEFAULT NULL,
  `capacidad_pasajeros` int(11) DEFAULT NULL,
  `placa` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `autobus`
--

INSERT INTO `autobus` (`id`, `modelo`, `capacidad_pasajeros`, `placa`, `color`) VALUES
(0x33396333643938342d636633352d3131, 'Volvo B8RLE', 30, 'DEF456', 'Azul'),
(0x33396333646233382d636633352d3131, 'MAN Lios City', 25, 'GHI789', 'Rojo'),
(0x33396333646238312d636633352d3131, 'Scania OmniExpress', 35, 'JKL012', 'Verde'),
(0x33396333646263652d636633352d3131, 'Iveco Crossway LE', 40, 'MNO345', 'Amarillo'),
(0x33396333646266662d636633352d3131, 'Renault Master', 15, 'PQR678', 'Negro'),
(0x33396333646332652d636633352d3131, 'Ford Transit', 18, 'STU901', 'Gris'),
(0x33396333646431362d636633352d3131, 'Mitsubishi Rosa', 22, 'VWX234', 'Naranja'),
(0x33396333646465332d636633352d3131, 'Toyota Coaster', 28, 'YZA567', 'Morado'),
(0x33396333646466392d636633352d3131, 'Isuzu Journey', 32, 'BCD890', 'Plateado'),
(0x34396631386531392d636633352d3131, 'Mercedes-Benz Sprinter', 20, 'ABC123', 'Blanco'),
(0x34396631393163372d636633352d3131, 'Volvo B8RLE', 30, 'DEF456', 'Azul'),
(0x34396631393233642d636633352d3131, 'MAN Lios City', 25, 'GHI789', 'Rojo'),
(0x34396631393237372d636633352d3131, 'Scania OmniExpress', 35, 'JKL012', 'Verde'),
(0x34396631393262352d636633352d3131, 'Iveco Crossway LE', 40, 'MNO345', 'Amarillo'),
(0x34396631393265332d636633352d3131, 'Renault Master', 15, 'PQR678', 'Negro'),
(0x34396631393331342d636633352d3131, 'Ford Transit', 18, 'STU901', 'Gris'),
(0x34396631393334312d636633352d3131, 'Mitsubishi Rosa', 22, 'VWX234', 'Naranja'),
(0x34396631393337342d636633352d3131, 'Toyota Coaster', 28, 'YZA567', 'Morado'),
(0x34396631393361312d636633352d3131, 'Isuzu Journey', 32, 'BCD890', 'Plateado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `chofer`
--

CREATE TABLE `chofer` (
  `id` binary(16) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  `experiencia_años` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `chofer`
--

INSERT INTO `chofer` (`id`, `nombre`, `apellido`, `edad`, `experiencia_años`) VALUES
(0x33396338323331312d636633352d3131, 'Juan', 'Perez', 35, 10),
(0x33396338336533332d636633352d3131, 'Maria', 'Gonzalez', 40, 15),
(0x33396338343034382d636633352d3131, 'Carlos', 'Lopez', 30, 8),
(0x33396338343062312d636633352d3131, 'Laura', 'Martinez', 45, 20),
(0x33396338343131632d636633352d3131, 'Pedro', 'Sanchez', 38, 12),
(0x33396338343135632d636633352d3131, 'Ana', 'Rodriguez', 33, 9),
(0x33396338343161312d636633352d3131, 'Diego', 'Hernandez', 37, 11),
(0x33396338343164622d636633352d3131, 'Sofia', 'Diaz', 42, 18),
(0x33396338343261642d636633352d3131, 'Daniel', 'Garcia', 36, 13),
(0x33396338343265392d636633352d3131, 'Elena', 'Ruiz', 39, 16);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pasajero`
--

CREATE TABLE `pasajero` (
  `id` binary(16) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  `correo_electronico` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pasajero`
--

INSERT INTO `pasajero` (`id`, `nombre`, `apellido`, `edad`, `correo_electronico`) VALUES
(0x36363634356666662d636633352d3131, 'Roberto', 'Alvarez', 25, 'roberto@example.com'),
(0x36363634376137632d636633352d3131, 'Isabel', 'Lopez', 30, 'isabel@example.com'),
(0x36363634376233362d636633352d3131, 'Manuel', 'Gomez', 40, 'manuel@example.com'),
(0x36363634376238362d636633352d3131, 'Ana', 'Hernandez', 35, 'ana@example.com'),
(0x36363634376264652d636633352d3131, 'Luis', 'Perez', 28, 'luis@example.com'),
(0x36363634376330652d636633352d3131, 'Carmen', 'Martinez', 42, 'carmen@example.com'),
(0x36363634376334312d636633352d3131, 'Javier', 'Rodriguez', 33, 'javier@example.com'),
(0x36363634376336652d636633352d3131, 'Laura', 'Garcia', 27, 'laura@example.com'),
(0x36363634376431302d636633352d3131, 'Diego', 'Sanchez', 38, 'diego@example.com'),
(0x36363634376434312d636633352d3131, 'Elena', 'Fernandez', 45, 'elena@example.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `id` binary(16) NOT NULL,
  `id_ticket` binary(16) DEFAULT NULL,
  `id_pasajero` binary(16) DEFAULT NULL,
  `numero_asiento` int(11) DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `reserva`
--

INSERT INTO `reserva` (`id`, `id_ticket`, `id_pasajero`, `numero_asiento`, `estado`) VALUES
(0x62373238393563322d636633382d3131, 0x39623735356431612d636633372d3131, 0x36363634376431302d636633352d3131, 12, 'no confirmado'),
(0x63383035666136302d636633382d3131, 0x39623735356431612d636633372d3131, 0x36363634376434312d636633352d3131, 17, 'no confirmado'),
(0x64323033613063322d636633382d3131, 0x39623735356431612d636633372d3131, 0x36363634376434312d636633352d3131, 14, ' no confirmado'),
(0x65326464363439352d636633382d3131, 0x39623735356362392d636633372d3131, 0x36363634376233362d636633352d3131, 22, 'confirmado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ruta`
--

CREATE TABLE `ruta` (
  `id` binary(16) NOT NULL,
  `origen` varchar(255) DEFAULT NULL,
  `destino` varchar(255) DEFAULT NULL,
  `distancia_km` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ruta`
--

INSERT INTO `ruta` (`id`, `origen`, `destino`, `distancia_km`) VALUES
(0x33396362626137322d636633352d3131, 'Ciudad A', 'Ciudad B', 200),
(0x33396362633832352d636633352d3131, 'Ciudad C', 'Ciudad D', 300),
(0x33396362633838642d636633352d3131, 'Ciudad E', 'Ciudad F', 400),
(0x33396362633866382d636633352d3131, 'Ciudad G', 'Ciudad H', 500),
(0x33396362633931312d636633352d3131, 'Ciudad I', 'Ciudad J', 600),
(0x33396362633932332d636633352d3131, 'Ciudad K', 'Ciudad L', 700),
(0x33396362633933352d636633352d3131, 'Ciudad M', 'Ciudad N', 800),
(0x33396362633934332d636633352d3131, 'Ciudad O', 'Ciudad P', 900),
(0x33396362633935392d636633352d3131, 'Ciudad Q', 'Ciudad R', 1000),
(0x33396362633936392d636633352d3131, 'Ciudad S', 'Ciudad T', 1100),
(0x35613035393261622d636633352d3131, 'Ciudad A', 'Ciudad B', 200),
(0x35613035393565312d636633352d3131, 'Ciudad C', 'Ciudad D', 300),
(0x35613035393633372d636633352d3131, 'Ciudad E', 'Ciudad F', 400),
(0x35613035393666392d636633352d3131, 'Ciudad G', 'Ciudad H', 500),
(0x35613035393734332d636633352d3131, 'Ciudad I', 'Ciudad J', 600),
(0x35613035393736642d636633352d3131, 'Ciudad K', 'Ciudad L', 700),
(0x35613035393739372d636633352d3131, 'Ciudad M', 'Ciudad N', 800),
(0x35613035393762652d636633352d3131, 'Ciudad O', 'Ciudad P', 900),
(0x35613035393765652d636633352d3131, 'Ciudad Q', 'Ciudad R', 1000),
(0x35613035393831372d636633352d3131, 'Ciudad S', 'Ciudad T', 1100);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ticket`
--

CREATE TABLE `ticket` (
  `id` binary(16) NOT NULL,
  `id_autobus` binary(16) DEFAULT NULL,
  `id_ruta` binary(16) DEFAULT NULL,
  `fecha_viaje` date DEFAULT NULL,
  `precio` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ticket`
--

INSERT INTO `ticket` (`id`, `id_autobus`, `id_ruta`, `fecha_viaje`, `precio`) VALUES
(0x39623735356338342d636633372d3131, 0x33396333646233382d636633352d3131, 0x33396362633838642d636633352d3131, '2024-01-15', 25.00),
(0x39623735356362392d636633372d3131, 0x34396631393262352d636633352d3131, 0x33396362633936392d636633352d3131, '2021-10-07', 20.00),
(0x39623735356366302d636633372d3131, 0x34396631393262352d636633352d3131, 0x33396362633936392d636633352d3131, '2024-01-31', 25.00),
(0x39623735356431612d636633372d3131, 0x34396631393337342d636633352d3131, 0x35613035393565312d636633352d3131, '2024-02-20', 10.00),
(0x39623735356434392d636633372d3131, 0x34396631393337342d636633352d3131, 0x35613035393565312d636633352d3131, '2024-02-17', 20.00),
(0x39623735356437322d636633372d3131, 0x34396631393361312d636633352d3131, 0x35613035393831372d636633352d3131, '2024-02-17', 55.00);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `autobus`
--
ALTER TABLE `autobus`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `chofer`
--
ALTER TABLE `chofer`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `pasajero`
--
ALTER TABLE `pasajero`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`id`),
  ADD KEY `reserva_ibfk_1` (`id_ticket`),
  ADD KEY `reserva_ibfk_2` (`id_pasajero`);

--
-- Indices de la tabla `ruta`
--
ALTER TABLE `ruta`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ticket_ibfk_1` (`id_autobus`),
  ADD KEY `ticket_ibfk_2` (`id_ruta`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`id_ticket`) REFERENCES `ticket` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `reserva_ibfk_2` FOREIGN KEY (`id_pasajero`) REFERENCES `pasajero` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`id_autobus`) REFERENCES `autobus` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ticket_ibfk_2` FOREIGN KEY (`id_ruta`) REFERENCES `ruta` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
