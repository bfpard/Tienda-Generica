CREATE SCHEMA `tienda2` DEFAULT CHARACTER SET utf8 ;
CREATE TABLE `tienda2`.`usuario` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `cedula` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `fullname` VARCHAR(45) NOT NULL,
  `userlogin` VARCHAR(45) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE INDEX `cedula_UNIQUE` (`cedula` ASC) VISIBLE,
  UNIQUE INDEX `correo_UNIQUE` (`correo` ASC) VISIBLE,
  UNIQUE INDEX `userlogin_UNIQUE` (`userlogin` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
CREATE TABLE `tienda2`.`rol` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `rol_nombre` VARCHAR(255) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `rol_nombre_UNIQUE` (`rol_nombre` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
CREATE TABLE `tienda2`.`usuario_rol` (
  `usuario_id` INT NOT NULL,
  `rol_id` INT NOT NULL,
  PRIMARY KEY (`usuario_id`, `rol_id`),
  INDEX `rol_idx` (`rol_id` ASC) VISIBLE,
  CONSTRAINT `user`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `tienda2`.`usuario` (`id_usuario`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `rol`
    FOREIGN KEY (`rol_id`)
    REFERENCES `tienda2`.`rol` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
INSERT INTO `tienda2`.`rol` (`rol_nombre`) VALUES ('ROLE_ADMIN');
INSERT INTO `tienda2`.`rol` (`rol_nombre`) VALUES ('ROLE_USER');
INSERT INTO `tienda2`.`usuario` (`cedula`, `correo`, `fullname`, `userlogin`, `password`) VALUES ('1478523698', 'admin@hotmail.com', 'admin inicial', 'admin', '$2a$10$h7x59Q1/HK2KwY72ptCteu4/Ritb4FFguKPPObljOYSVz5Sp7983a');
INSERT INTO `tienda2`.`usuario_rol` (`usuario_id`, `rol_id`) VALUES ('1', '1');
INSERT INTO `tienda2`.`usuario_rol` (`usuario_id`, `rol_id`) VALUES ('1', '2');