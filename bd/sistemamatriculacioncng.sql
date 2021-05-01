-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-01-2020 a las 05:41:35
-- Versión del servidor: 10.1.38-MariaDB
-- Versión de PHP: 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sistemamatriculacioncng`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `añolectivo`
--

CREATE TABLE `añolectivo` (
  `id` int(11) NOT NULL,
  `año` varchar(45) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `añolectivo`
--

INSERT INTO `añolectivo` (`id`, `año`, `estado`) VALUES
(1, '2019-2020', 'ACTIVO'),
(2, '2020-2021', 'INACTIVO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `discapacidad`
--

CREATE TABLE `discapacidad` (
  `id` int(11) NOT NULL,
  `tipodediscapacidad` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `discapacidad`
--

INSERT INTO `discapacidad` (`id`, `tipodediscapacidad`) VALUES
(1, 'VISUAL'),
(2, 'AUDITIVA'),
(3, 'AUTISMO'),
(4, 'MULTIDISCAPACIDAD');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `matriculacion`
--

CREATE TABLE `matriculacion` (
  `n_matricula` int(11) NOT NULL,
  `fecha` varchar(45) NOT NULL,
  `ced_est` varchar(45) NOT NULL,
  `ape_est` varchar(45) NOT NULL,
  `nom_est` varchar(45) NOT NULL,
  `año_bas` varchar(45) NOT NULL,
  `carnet` varchar(45) NOT NULL,
  `discapacidad` varchar(45) NOT NULL,
  `porcentaje` int(11) NOT NULL,
  `añolectivo` varchar(45) DEFAULT NULL,
  `ced_rep` varchar(45) NOT NULL,
  `ape_rep` varchar(45) NOT NULL,
  `nom_rep` varchar(45) NOT NULL,
  `dir_rep` varchar(45) NOT NULL,
  `tel_con` varchar(45) NOT NULL,
  `tel_celular` varchar(45) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `codigodeluz` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `matriculacion`
--

INSERT INTO `matriculacion` (`n_matricula`, `fecha`, `ced_est`, `ape_est`, `nom_est`, `año_bas`, `carnet`, `discapacidad`, `porcentaje`, `añolectivo`, `ced_rep`, `ape_rep`, `nom_rep`, `dir_rep`, `tel_con`, `tel_celular`, `correo`, `codigodeluz`) VALUES
(12, '2020-1-19 9:13:0', '0151591534', 'Pucha Suárez', 'Bither Dayanna', '85', '0151591534', 'AUTISMO', 30, '2019-2020', '0158246782', 'Suárez Pani', 'Elsa Andrea', 'Tomás Ordoñez y Muñoz Vernaza', '818182', '0991900638', 'elsa89@gmail.com', '89');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seguridad`
--

CREATE TABLE `seguridad` (
  `id_seguridad` int(11) NOT NULL,
  `ced_est` varchar(11) CHARACTER SET utf8 NOT NULL,
  `ape_est` varchar(20) CHARACTER SET utf8 NOT NULL,
  `nom_est` varchar(20) CHARACTER SET utf8 NOT NULL,
  `año_bas` int(11) NOT NULL,
  `ape_rep` varchar(20) CHARACTER SET utf8 NOT NULL,
  `nom_rep` varchar(20) CHARACTER SET utf8 NOT NULL,
  `dir_est` varchar(20) CHARACTER SET utf8 NOT NULL,
  `tel_est` int(11) NOT NULL,
  `forma_traslado` varchar(45) NOT NULL,
  `ced_responsable` varchar(45) DEFAULT NULL,
  `apellidos_responsable` varchar(45) DEFAULT NULL,
  `nombres_responsable` varchar(45) DEFAULT NULL,
  `telefono_responsable` varchar(45) DEFAULT NULL,
  `modalidad_transporte` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `seguridad`
--

INSERT INTO `seguridad` (`id_seguridad`, `ced_est`, `ape_est`, `nom_est`, `año_bas`, `ape_rep`, `nom_rep`, `dir_est`, `tel_est`, `forma_traslado`, `ced_responsable`, `apellidos_responsable`, `nombres_responsable`, `telefono_responsable`, `modalidad_transporte`) VALUES
(30, '0151591534', 'Urgiles Tambo', 'Luisa Claudina', 4, 'Tambo Fernandez', 'Maria', 'quitachica', 9634667, 'ACOMPAÑADO', '0151477270', 'soria', 'carlos', '423423', 'NO USA');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `añolectivo`
--
ALTER TABLE `añolectivo`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `discapacidad`
--
ALTER TABLE `discapacidad`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `matriculacion`
--
ALTER TABLE `matriculacion`
  ADD PRIMARY KEY (`n_matricula`);

--
-- Indices de la tabla `seguridad`
--
ALTER TABLE `seguridad`
  ADD PRIMARY KEY (`id_seguridad`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `añolectivo`
--
ALTER TABLE `añolectivo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `matriculacion`
--
ALTER TABLE `matriculacion`
  MODIFY `n_matricula` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `seguridad`
--
ALTER TABLE `seguridad`
  MODIFY `id_seguridad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
