CREATE TABLE `proyecto_db`.`cursos` (
  `id_curso` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `duracion` INT NULL,
  `precio` DOUBLE NULL,
  `disponibilidad` VARCHAR(45) NULL,
  PRIMARY KEY (`id_curso`));

ALTER TABLE `proyecto_db`.`cursos` 
ADD COLUMN `plazas` INT NULL AFTER `disponibilidad`;
