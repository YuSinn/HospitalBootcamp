-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: hospital
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `asignacion_paciente_medico`
--

DROP TABLE IF EXISTS `asignacion_paciente_medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asignacion_paciente_medico` (
  `idAsignacion` int NOT NULL AUTO_INCREMENT,
  `idMedico` int NOT NULL,
  `idPaciente` int NOT NULL,
  PRIMARY KEY (`idAsignacion`),
  KEY `asignacion_paciente_medico_medico_FK` (`idMedico`),
  KEY `asignacion_paciente_medico_paciente_FK` (`idPaciente`),
  CONSTRAINT `asignacion_paciente_medico_medico_FK` FOREIGN KEY (`idMedico`) REFERENCES `medico` (`idMedico`),
  CONSTRAINT `asignacion_paciente_medico_paciente_FK` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`idPaciente`)
) ENGINE=InnoDB AUTO_INCREMENT=245 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asignacion_paciente_medico`
--

LOCK TABLES `asignacion_paciente_medico` WRITE;
/*!40000 ALTER TABLE `asignacion_paciente_medico` DISABLE KEYS */;
INSERT INTO `asignacion_paciente_medico` VALUES (201,1,1),(202,32,2),(203,34,3),(204,33,4),(205,24,5),(206,20,6),(207,27,7),(208,33,8),(209,6,9),(210,10,10),(211,30,11),(212,1,12),(213,34,13),(214,9,14),(215,19,15),(216,29,16),(217,8,17),(218,33,18),(219,19,19),(220,36,20),(221,2,21),(222,20,22),(223,14,23),(224,12,24),(225,15,25),(226,38,26),(227,24,27),(228,7,28),(229,1,29),(230,24,30),(231,38,31),(232,38,32),(233,35,33),(234,18,34),(235,27,35),(236,39,36),(237,33,37),(238,10,38),(239,29,39),(240,34,40),(241,3,41),(242,31,42),(243,27,43);
/*!40000 ALTER TABLE `asignacion_paciente_medico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departamento` (
  `idDepartamento` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `descripcion` text NOT NULL,
  PRIMARY KEY (`idDepartamento`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (1,'Cardiología2','Departamento de Cardiología2'),(2,'Neurología','Departamento de Neurología'),(3,'Cirugía General','Departamento de Cirugía General'),(4,'Pediatría','Departamento de Pediatría'),(5,'Ginecología','Departamento de Ginecología'),(6,'Oftalmología','Departamento de Oftalmología'),(7,'Ortopedia','Departamento de Ortopedia'),(8,'Dermatología','Departamento de Dermatología'),(9,'Oncología','Departamento de Oncología'),(10,'Radiología','Departamento de Radiología'),(11,'Endocrinología','Departamento de Endocrinología'),(12,'Urología','Departamento de Urología'),(13,'Nefrología','Departamento de Nefrología'),(14,'Hematología','Departamento de Hematología'),(15,'Infectología','Departamento de Infectología'),(16,'Psiquiatría','Departamento de Psiquiatría'),(17,'Neumología','Departamento de Neumología'),(18,'Traumatología','Departamento de Traumatología'),(19,'Reumatología','Departamento de Reumatología'),(20,'Gastroenterología','Departamento de Gastroenterología');
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `material` (
  `idMaterial` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `cantidad` varchar(100) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `idDepartamento` int NOT NULL,
  PRIMARY KEY (`idMaterial`),
  KEY `material_departamento_FK` (`idDepartamento`),
  CONSTRAINT `material_departamento_FK` FOREIGN KEY (`idDepartamento`) REFERENCES `departamento` (`idDepartamento`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
INSERT INTO `material` VALUES (1,'Guantes de látex','500','Guantes de látex para procedimientos médicos',1),(2,'Mascarillas quirúrgicas','1000','Mascarillas de protección para cirugías',1),(3,'Jeringas de 5 ml','300','Jeringas para administración de medicamentos',2),(4,'Agujas hipodérmicas','400','Agujas para inyecciones',2),(5,'Algodón estéril','200','Algodón utilizado en procedimientos médicos',3),(6,'Vendas adhesivas','150','Vendas para el tratamiento de heridas',3),(7,'Bisturíes quirúrgicos','50','Bisturíes para cirugías',4),(8,'Gasa estéril','300','Gasas para curaciones',4),(9,'Termómetros clínicos','100','Termómetros para medición de temperatura',5),(10,'Esparadrapo quirúrgico','200','Esparadrapo para fijar apósitos',5),(11,'Camillas plegables','20','Camillas portátiles para traslado de pacientes',6),(12,'Sillas de ruedas','15','Sillas de ruedas para movilidad de pacientes',6),(13,'Electrocardiógrafos','5','Dispositivos para registrar la actividad eléctrica del corazón',7),(14,'Desfibriladores','3','Dispositivos para administrar una descarga eléctrica al corazón',7),(15,'Rayos X portátiles','2','Dispositivos para obtener imágenes radiográficas',8),(16,'Máquinas de anestesia','4','Equipos para administrar anestesia durante procedimientos quirúrgicos',8),(17,'Microscopios clínicos','3','Microscopios para análisis de muestras biológicas',9),(18,'Centrífugas de laboratorio','2','Equipos para separar componentes de muestras',9),(19,'Bombas de infusión','10','Dispositivos para administrar fluidos en el cuerpo',10),(20,'Monitores de signos vitales','8','Dispositivos para medir constantes fisiológicas',10),(21,'Incubadoras neonatales','5','Equipos para el cuidado de recién nacidos prematuros',11),(22,'Desfibriladores pediátricos','2','Dispositivos para administrar descargas eléctricas a niños',11),(23,'Férulas ortopédicas','30','Dispositivos para inmovilizar extremidades',12),(24,'Sondas de alimentación','40','Dispositivos para la administración de nutrientes',12),(25,'Lámparas de examinación','25','Lámparas para iluminar áreas de examen médico',13),(26,'Máscaras de oxígeno','50','Dispositivos para administrar oxígeno a pacientes',13),(27,'Espirometrías','3','Dispositivos para medir la capacidad pulmonar',14),(28,'Desfibriladores automáticos','5','Dispositivos automáticos para administrar descargas eléctricas',14),(29,'Electroencefalogramas','2','Dispositivos para medir la actividad eléctrica del cerebro',15),(30,'Colchones antiescaras','15','Colchones para prevenir úlceras por presión',15),(31,'Ecógrafos','4','Dispositivos para obtener imágenes mediante ultrasonido',16),(32,'Cámaras hiperbáricas','2','Cámaras para administrar oxígeno a presión',16),(33,'Estetoscopios','40','Instrumentos para escuchar sonidos internos del cuerpo',17),(34,'Laringoscopios','10','Instrumentos para visualizar la laringe durante intubación',17),(35,'Filtros de agua para equipos médicos','100','Filtros para garantizar la pureza del agua utilizada',18),(36,'Camas hospitalarias','25','Camas diseñadas para uso hospitalario',18),(37,'Instrumental quirúrgico básico','10','Instrumentos esenciales para procedimientos quirúrgicos',19),(38,'Máscaras faciales para ventilación','30','Máscaras para administrar ventilación a pacientes',19),(39,'Lámparas quirúrgicas','8','Lámparas para iluminar áreas de cirugía',20),(40,'Desinfectantes de manos','200','Desinfectantes para manos en áreas médicas',20);
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medico`
--

DROP TABLE IF EXISTS `medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medico` (
  `idMedico` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `prApellido` varchar(100) NOT NULL,
  `sgApellido` varchar(100) DEFAULT NULL,
  `especialidad` varchar(100) NOT NULL,
  `telefono` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `idDepartamento` int NOT NULL,
  PRIMARY KEY (`idMedico`),
  KEY `medico_departamento_FK` (`idDepartamento`),
  CONSTRAINT `medico_departamento_FK` FOREIGN KEY (`idDepartamento`) REFERENCES `departamento` (`idDepartamento`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medico`
--

LOCK TABLES `medico` WRITE;
/*!40000 ALTER TABLE `medico` DISABLE KEYS */;
INSERT INTO `medico` VALUES (1,'Juan','Gómez','Martínez','Cardiólogo','555-1234','juan.gomez@example.com',1),(2,'María','Rodríguez','Fernández','Neurólogo','555-5678','maria.rod@example.com',1),(3,'Carlos','López',NULL,'Cirujano General','555-9876','carlos.lopez@example.com',2),(4,'Laura','Díaz','Gutiérrez','Pediatra','555-4321','laura.diaz@example.com',2),(5,'Pedro','Sánchez','Ruíz','Ginecólogo','555-8765','pedro.sanchez@example.com',3),(6,'Ana','Fernández','Hernández','Oftalmólogo','555-2109','ana.fernandez@example.com',3),(7,'Javier','García','Jiménez','Ortopedista','555-1098','javier.garcia@example.com',4),(8,'Elena','Martínez','Gómez','Dermatólogo','555-5432','elena.martinez@example.com',4),(9,'Sergio','Hernández',NULL,'Oncólogo','555-8765','sergio.hernandez@example.com',5),(10,'Lucía','Ruíz','López','Radiólogo','555-8901','lucia.ruiz@example.com',5),(11,'Miguel','Díaz','González','Endocrinólogo','555-3210','miguel.diaz@example.com',6),(12,'Carmen','Gutiérrez','Sánchez','Urología','555-2345','carmen.gutierrez@example.com',6),(13,'Alberto','López','Torres','Nefrólogo','555-7654','alberto.lopez@example.com',7),(14,'Isabel','Jiménez','Fernández','Hematólogo','555-4567','isabel.jimenez@example.com',7),(15,'Antonio','Sánchez',NULL,'Infectólogo','555-8765','antonio.sanchez@example.com',8),(16,'Adriana','Torres','Díaz','Psiquiatra','555-6789','adriana.torres@example.com',8),(17,'Diego','Ruíz','Martínez','Neumólogo','555-8901','diego.ruiz@example.com',9),(18,'Sofía','García','López','Traumatólogo','555-1098','sofia.garcia@example.com',9),(19,'Alejandro','Fernández','Ramírez','Reumatólogo','555-2109','alejandro.fernandez@example.com',10),(20,'Rosa','Martínez','Gómez','Gastroenterólogo','555-4321','rosa.martinez@example.com',10),(21,'Juan','Gómez','Pérez','Cardiólogo','555-8765','juan.gomez@example.com',11),(22,'Laura','Díaz','Sánchez','Neurólogo','555-9876','laura.diaz@example.com',11),(23,'Carlos','López','Martínez','Cirujano General','555-5432','carlos.lopez@example.com',12),(24,'María','Rodríguez','Fernández','Pediatra','555-3210','maria.rod@example.com',12),(25,'Pedro','Sánchez',NULL,'Ginecólogo','555-8765','pedro.sanchez@example.com',13),(26,'Ana','Fernández','Hernández','Oftalmólogo','555-2109','ana.fernandez@example.com',13),(27,'Javier','García','Jiménez','Ortopedista','555-1098','javier.garcia@example.com',14),(28,'Elena','Martínez','Gómez','Dermatólogo','555-5432','elena.martinez@example.com',14),(29,'Sergio','Hernández',NULL,'Oncólogo','555-8765','sergio.hernandez@example.com',15),(30,'Lucía','Ruíz','López','Radiólogo','555-3210','lucia.ruiz@example.com',15),(31,'Miguel','Díaz','González','Endocrinólogo','555-2345','miguel.diaz@example.com',16),(32,'Carmen','Gutiérrez','Sánchez','Urología','555-7654','carmen.gutierrez@example.com',16),(33,'Alberto','López','Torres','Nefrólogo','555-4321','alberto.lopez@example.com',17),(34,'Isabel','Jiménez','Fernández','Hematólogo','555-5678','isabel.jimenez@example.com',17),(35,'Antonio','Sánchez',NULL,'Infectólogo','555-8765','antonio.sanchez@example.com',18),(36,'Adriana','Torres','Díaz','Psiquiatra','555-6789','adriana.torres@example.com',18),(37,'Diego','Ruíz','Martínez','Neumólogo','555-8901','diego.ruiz@example.com',19),(38,'Sofía','García','López','Traumatólogo','555-1098','sofia.garcia@example.com',19),(39,'Alejandro','Fernández','Ramírez','Reumatólogo','555-2109','alejandro.fernandez@example.com',20),(40,'Rosa','Martínez','Gómez','Gastroenterólogo','555-4321','rosa.martinez@example.com',20);
/*!40000 ALTER TABLE `medico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paciente`
--

DROP TABLE IF EXISTS `paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paciente` (
  `idPaciente` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `prApellido` varchar(100) NOT NULL,
  `sgApellido` varchar(100) DEFAULT NULL,
  `fechaNacimiento` date NOT NULL,
  `genero` varchar(100) DEFAULT NULL,
  `direccion` varchar(150) NOT NULL,
  `telefono` varchar(100) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idPaciente`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente`
--

LOCK TABLES `paciente` WRITE;
/*!40000 ALTER TABLE `paciente` DISABLE KEYS */;
INSERT INTO `paciente` VALUES (1,'María','Rodríguez','Fernández','1985-08-22','Femenino','Avenida 456, Ciudad Y','555-5678','maria.rodo@example.com'),(2,'María','Rodríguez','Fernández','1985-08-22','Femenino','Avenida 456, Ciudad Y','555-5678','maria.rod@example.com'),(3,'Carlos','López',NULL,'1972-03-10','Masculino','Carrera 789, Ciudad Z','555-9876',NULL),(4,'Laura','Díaz','Gutiérrez','1995-11-28','Femenino','Calle 234, Ciudad W','555-4321','laura.diaz@example.com'),(5,'Pedro','Sánchez','Ruíz','1980-06-03','Masculino','Avenida 567, Ciudad V','555-8765','pedro.sanchez@example.com'),(6,'Ana','Fernández','Hernández','1988-09-17','Femenino','Carrera 890, Ciudad U','555-2109','ana.fernandez@example.com'),(7,'Javier','García','Jiménez','1975-04-05','Masculino','Calle 345, Ciudad T','555-1098','javier.garcia@example.com'),(8,'Elena','Martínez','Gómez','1992-01-20','Femenino','Avenida 678, Ciudad S','555-5432','elena.martinez@example.com'),(9,'Sergio','Hernández',NULL,'1983-07-12','Masculino','Carrera 901, Ciudad R','555-8765',NULL),(10,'Lucía','Ruíz','López','1998-02-14','Femenino','Calle 456, Ciudad Q','555-8901','lucia.ruiz@example.com'),(11,'Miguel','Díaz','González','1982-11-08','Masculino','Avenida 789, Ciudad P','555-3210','miguel.diaz@example.com'),(12,'Carmen','Gutiérrez','Sánchez','1991-06-25','Femenino','Carrera 012, Ciudad O','555-2345','carmen.gutierrez@example.com'),(13,'Alberto','López','Torres','1978-09-30','Masculino','Calle 567, Ciudad N','555-7654','alberto.lopez@example.com'),(14,'Isabel','Jiménez','Fernández','1996-04-03','Femenino','Avenida 123, Ciudad M','555-4567','isabel.jimenez@example.com'),(15,'Antonio','Sánchez',NULL,'1973-12-18','Masculino','Calle 234, Ciudad L','555-8765',NULL),(16,'Adriana','Torres','Díaz','1989-08-11','Femenino','Avenida 345, Ciudad K','555-6789','adriana.torres@example.com'),(17,'Diego','Ruíz','Martínez','1994-03-28','Masculino','Carrera 456, Ciudad J','555-8901','diego.ruiz@example.com'),(18,'Sofía','García','López','1976-10-02','Femenino','Calle 567, Ciudad I','555-2109','sofia.garcia@example.com'),(19,'Alejandro','Fernández','Ramírez','1993-05-17','Masculino','Avenida 678, Ciudad H','555-5432','alejandro.fernandez@example.com'),(20,'Rosa','Martínez','Gómez','1981-01-09','Femenino','Carrera 789, Ciudad G','555-4321','rosa.martinez@example.com'),(21,'Juan','Gómez','Pérez','1997-06-22','Masculino','Calle 890, Ciudad F','555-1098','juan.gomez@example.com'),(22,'Laura','Díaz','Sánchez','1979-11-15','Femenino','Avenida 901, Ciudad E','555-9876','laura.diaz@example.com'),(23,'Carlos','López','Martínez','1987-04-29','Masculino','Calle 012, Ciudad D','555-4321','carlos.lopez@example.com'),(24,'María','Rodríguez','Fernández','1998-09-03','Femenino','Avenida 123, Ciudad C','555-7654','maria.rod@example.com'),(25,'Pedro','Sánchez',NULL,'1974-02-16','Masculino','Carrera 234, Ciudad B','555-8765',NULL),(26,'Ana','Fernández','Hernández','1992-07-19','Femenino','Calle 345, Ciudad A','555-8901','ana.fernandez@example.com'),(27,'Javier','García','Jiménez','1983-12-12','Masculino','Avenida 456, Ciudad Z','555-2109','javier.garcia@example.com'),(28,'Elena','Martínez','Gómez','1990-05-05','Femenino','Carrera 567, Ciudad Y','555-5432','elena.martinez@example.com'),(29,'Sergio','Hernández',NULL,'1978-10-28','Masculino','Calle 678, Ciudad X','555-8765',NULL),(30,'Lucía','Ruíz','López','1985-03-14','Femenino','Avenida 789, Ciudad W','555-3210','lucia.ruiz@example.com'),(31,'Miguel','Díaz','González','1996-08-07','Masculino','Carrera 890, Ciudad V','555-2345','miguel.diaz@example.com'),(32,'Carmen','Gutiérrez','Sánchez','1972-01-30','Femenino','Calle 901, Ciudad U','555-7654','carmen.gutierrez@example.com'),(33,'Alberto','López','Torres','1989-06-13','Masculino','Avenida 012, Ciudad T','555-4321','alberto.lopez@example.com'),(34,'Isabel','Jiménez','Fernández','1993-11-25','Femenino','Carrera 123, Ciudad S','555-8765','isabel.jimenez@example.com'),(35,'Antonio','Sánchez',NULL,'1976-04-18','Masculino','Calle 234, Ciudad R','555-9876',NULL),(36,'Adriana','Torres','Díaz','1981-09-10','Femenino','Avenida 345, Ciudad Q','555-5432','adriana.torres@example.com'),(37,'Diego','Ruíz','Martínez','1997-02-03','Masculino','Carrera 456, Ciudad P','555-8901','diego.ruiz@example.com'),(38,'Sofía','García','López','1975-07-26','Femenino','Calle 567, Ciudad O','555-1098','sofia.garcia@example.com'),(39,'Alejandro','Fernández','Ramírez','1982-12-19','Masculino','Avenida 678, Ciudad N','555-2109','alejandro.fernandez@example.com'),(40,'Rosa','Martínez','Gómez','1990-05-02','Femenino','Carrera 789, Ciudad M','555-4321','rosa.martinez@example.com'),(41,'Juan','Gómez','Pérez','1978-10-15','Masculino','Calle 890, Ciudad L','555-8765','juan.gomez@example.com'),(42,'Laura','Díaz','Sánchez','1996-03-08','Femenino','Avenida 901, Ciudad K','555-9876','laura.diaz@example.com'),(43,'Carlos','López','Martínez','1984-08-01','Masculino','Calle 012, Ciudad J','555-5432','carlos.lopez@example.com');
/*!40000 ALTER TABLE `paciente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'hospital'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-31 21:54:26
