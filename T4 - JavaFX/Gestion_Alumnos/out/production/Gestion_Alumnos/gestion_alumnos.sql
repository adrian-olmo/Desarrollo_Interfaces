-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-02-2020 a las 19:11:45
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gestion_alumnos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignatura`
--

CREATE TABLE `asignatura` (
  `id_asig` int(11) NOT NULL,
  `nombre_asig` varchar(30) DEFAULT NULL,
  `DNI_usuario` varchar(10) DEFAULT NULL,
  `nombre_modulo` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `asignatura`
--

INSERT INTO `asignatura` (`id_asig`, `nombre_asig`, `DNI_usuario`, `nombre_modulo`) VALUES
(1, 'DI', '1A', '2º DAM'),
(2, 'AD', '1B', '2º DAM'),
(3, 'Programacion', '1C', '1º DAM'),
(4, 'BBDD', '1D', '1º DAM');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `calificacion`
--

CREATE TABLE `calificacion` (
  `id_calif` int(11) NOT NULL,
  `nota` int(11) DEFAULT NULL,
  `DNI_usuario` varchar(10) DEFAULT NULL,
  `id_asig` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `calificacion`
--

INSERT INTO `calificacion` (`id_calif`, `nota`, `DNI_usuario`, `id_asig`) VALUES
(1, 9, '1A', 1),
(2, 10, '1C', 3),
(3, 6, '1B', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `modulo`
--

CREATE TABLE `modulo` (
  `nombre_modulo` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `modulo`
--

INSERT INTO `modulo` (`nombre_modulo`) VALUES
('1º DAM'),
('2º DAM');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `DNI_usuario` varchar(10) NOT NULL,
  `nombre_usuario` varchar(20) NOT NULL,
  `apellido_usuario` varchar(30) DEFAULT NULL,
  `email_usuario` varchar(40) DEFAULT NULL,
  `password` varchar(16) NOT NULL,
  `nombre_modulo` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`DNI_usuario`, `nombre_usuario`, `apellido_usuario`, `email_usuario`, `password`, `nombre_modulo`) VALUES
('0', 'admin', NULL, NULL, 'admin', ''),
('1A', 'Adrian', 'Olmo', 'adri@prueba.com', '1234', '2º DAM'),
('1B', 'Julian', 'Garcia', 'julian@prueba.com', '1234', '2º DAM'),
('1C', 'Borja', 'Martin', 'borja@prueba.com', '1234', '1º DAM'),
('1D', 'Carlos', 'Peres', 'carlos@prueba.com', '1234', '1º DAM'),
('as', 'as', 'as', 'as', 'as', '1º DAM');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asignatura`
--
ALTER TABLE `asignatura`
  ADD PRIMARY KEY (`id_asig`),
  ADD KEY `DNI_usuario` (`DNI_usuario`),
  ADD KEY `nombre_modulo` (`nombre_modulo`);

--
-- Indices de la tabla `calificacion`
--
ALTER TABLE `calificacion`
  ADD PRIMARY KEY (`id_calif`),
  ADD KEY `DNI_usuario` (`DNI_usuario`),
  ADD KEY `id_asig` (`id_asig`);

--
-- Indices de la tabla `modulo`
--
ALTER TABLE `modulo`
  ADD PRIMARY KEY (`nombre_modulo`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`DNI_usuario`),
  ADD KEY `nombre_modulo` (`nombre_modulo`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asignatura`
--
ALTER TABLE `asignatura`
  ADD CONSTRAINT `asignatura_ibfk_1` FOREIGN KEY (`DNI_usuario`) REFERENCES `usuario` (`DNI_usuario`),
  ADD CONSTRAINT `asignatura_ibfk_2` FOREIGN KEY (`nombre_modulo`) REFERENCES `modulo` (`nombre_modulo`);

--
-- Filtros para la tabla `calificacion`
--
ALTER TABLE `calificacion`
  ADD CONSTRAINT `calificacion_ibfk_1` FOREIGN KEY (`DNI_usuario`) REFERENCES `usuario` (`DNI_usuario`),
  ADD CONSTRAINT `calificacion_ibfk_2` FOREIGN KEY (`id_asig`) REFERENCES `asignatura` (`id_asig`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`nombre_modulo`) REFERENCES `modulo` (`nombre_modulo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
