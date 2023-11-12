/*
PARA TODOS LOS USUARIOS LA CONTRASEÑA ES 
-> admin
*/

-- USERS
INSERT INTO `db_boutique_mvc`.`users` (`userid`,`name`,`lastname`,`dni`,`email`,`username`,`password`,`movil`,`active`) VALUES (1,'Juan ','Salinas Quispe','40908298','juan@gmail.com','admin','$2a$12$OrYWOX3Z2DvfShMnfcx6NOx2gB2Q5dqN055u7KWzFUZ63kJs.oJs2','949187100',1);
INSERT INTO `db_boutique_mvc`.`users` (`userid`,`name`,`lastname`,`dni`,`email`,`username`,`password`,`movil`,`active`) VALUES (2,'Edgar ','Rosas Rasmussen','41339066','edgar@gmail.com','admin2','$2a$12$OrYWOX3Z2DvfShMnfcx6NOx2gB2Q5dqN055u7KWzFUZ63kJs.oJs2','940889700',1);
INSERT INTO `db_boutique_mvc`.`users` (`userid`,`name`,`lastname`,`dni`,`email`,`username`,`password`,`movil`,`active`) VALUES (3,'Victor ','Rodriguet Ronchi','76380232','victor@gmail.com','cajero','$2a$12$OrYWOX3Z2DvfShMnfcx6NOx2gB2Q5dqN055u7KWzFUZ63kJs.oJs2','934441882',1);
INSERT INTO `db_boutique_mvc`.`users` (`userid`,`name`,`lastname`,`dni`,`email`,`username`,`password`,`movil`,`active`) VALUES (4,'Diego','Humber Melendez','76119321','diego@gmail.com','cajero2','$2a$12$OrYWOX3Z2DvfShMnfcx6NOx2gB2Q5dqN055u7KWzFUZ63kJs.oJs2','959299631',1);
INSERT INTO `db_boutique_mvc`.`users` (`userid`,`name`,`lastname`,`dni`,`email`,`username`,`password`,`movil`,`active`) VALUES (5,'Claudia','Crolle Clies','09221129','claudia@gmail.com','almacen','$2a$12$OrYWOX3Z2DvfShMnfcx6NOx2gB2Q5dqN055u7KWzFUZ63kJs.oJs2','991920526',1);

-- ROLES
INSERT INTO `db_boutique_mvc`.`roles` (`rolid`, `rolname`) VALUES ('1', 'ADMIN');
INSERT INTO `db_boutique_mvc`.`roles` (`rolid`, `rolname`) VALUES ('2', 'CAJERO');
INSERT INTO `db_boutique_mvc`.`roles` (`rolid`, `rolname`) VALUES ('3', 'ALMACEN');

-- USER_ROLE
INSERT INTO `db_boutique_mvc`.`user_role` (`userid`, `rolid`) VALUES ('1', '1');
INSERT INTO `db_boutique_mvc`.`user_role` (`userid`, `rolid`) VALUES ('2', '1');
INSERT INTO `db_boutique_mvc`.`user_role` (`userid`, `rolid`) VALUES ('3', '2');
INSERT INTO `db_boutique_mvc`.`user_role` (`userid`, `rolid`) VALUES ('4', '2');
INSERT INTO `db_boutique_mvc`.`user_role` (`userid`, `rolid`) VALUES ('5', '3');

-- MARCA
INSERT INTO `db_boutique_mvc`.`marca` (`marca_id`, `marca_nombre`) VALUES ('1', 'Urban Elegance');
INSERT INTO `db_boutique_mvc`.`marca` (`marca_id`, `marca_nombre`) VALUES ('2', 'Celestial Threads');
INSERT INTO `db_boutique_mvc`.`marca` (`marca_id`, `marca_nombre`) VALUES ('3', 'Zenith Style');
INSERT INTO `db_boutique_mvc`.`marca` (`marca_id`, `marca_nombre`) VALUES ('4', 'Fashion Gust');
INSERT INTO `db_boutique_mvc`.`marca` (`marca_id`, `marca_nombre`) VALUES ('5', 'Luxe Loom');
INSERT INTO `db_boutique_mvc`.`marca` (`marca_id`, `marca_nombre`) VALUES ('6', 'Spectral Styles');
INSERT INTO `db_boutique_mvc`.`marca` (`marca_id`, `marca_nombre`) VALUES ('7', 'Artisan Attire');

-- TIPOPRODUCTO
INSERT INTO `db_boutique_mvc`.`tipoproducto` (`tipoproducto_id`, `tipoproducto_nombre`) VALUES ('1', 'Vestidos de Gala');
INSERT INTO `db_boutique_mvc`.`tipoproducto` (`tipoproducto_id`, `tipoproducto_nombre`) VALUES ('2', 'Vestidos de Novia');
INSERT INTO `db_boutique_mvc`.`tipoproducto` (`tipoproducto_id`, `tipoproducto_nombre`) VALUES ('3', 'Vestidos de Fiesta');
INSERT INTO `db_boutique_mvc`.`tipoproducto` (`tipoproducto_id`, `tipoproducto_nombre`) VALUES ('4', 'Vestidos de 15 años');
INSERT INTO `db_boutique_mvc`.`tipoproducto` (`tipoproducto_id`, `tipoproducto_nombre`) VALUES ('5', 'Vestidos Casuales');

-- PRODUCTO
INSERT INTO `db_boutique_mvc`.`producto` (`producto_id`,`producto_nombre`,`producto_descripcion`,`producto_estado`,`producto_precio`,`producto_imagen`,`marca_id`,`tipoproducto_id`) VALUES (1,'Vestido de gasa de manga larga','La exquisita textura de su tejido se combina armoniosamente con su encantadora falda única. Estos detalles hacen que este diseño sea especialmente apreciado.',1,190.90,'https://i.postimg.cc/wjTdsmxh/1.jpg',1,1);
INSERT INTO `db_boutique_mvc`.`producto` (`producto_id`,`producto_nombre`,`producto_descripcion`,`producto_estado`,`producto_precio`,`producto_imagen`,`marca_id`,`tipoproducto_id`) VALUES (2,'Vestido gala color Celeste','La exquisita textura de su tejido se combina armoniosamente con su encantadora falda única. Estos detalles hacen que este diseño sea especialmente apreciado.',1,225.90,'https://i.postimg.cc/N0ZhVC64/2.jpg',1,1);
INSERT INTO `db_boutique_mvc`.`producto` (`producto_id`,`producto_nombre`,`producto_descripcion`,`producto_estado`,`producto_precio`,`producto_imagen`,`marca_id`,`tipoproducto_id`) VALUES (3,'Vestido color gris azulado','La exquisita textura de su tejido se combina armoniosamente con su encantadora falda única. Estos detalles hacen que este diseño sea especialmente apreciado.',1,245.90,'https://i.postimg.cc/Qxh2RTTR/3.jpg',2,1);
INSERT INTO `db_boutique_mvc`.`producto` (`producto_id`,`producto_nombre`,`producto_descripcion`,`producto_estado`,`producto_precio`,`producto_imagen`,`marca_id`,`tipoproducto_id`) VALUES (4,'Estilo adore talla M','La exquisita textura de su tejido se combina armoniosamente con su encantadora falda única. Estos detalles hacen que este diseño sea especialmente apreciado.',1,500.90,'https://i.postimg.cc/C1DyVCJV/4.jpg',4,2);
INSERT INTO `db_boutique_mvc`.`producto` (`producto_id`,`producto_nombre`,`producto_descripcion`,`producto_estado`,`producto_precio`,`producto_imagen`,`marca_id`,`tipoproducto_id`) VALUES (5,'Estilo línea A reducida talla M','La exquisita textura de su tejido se combina armoniosamente con su encantadora falda única. Estos detalles hacen que este diseño sea especialmente apreciado.',1,450.90,'https://i.postimg.cc/T2V879pV/5.jpg',5,2);
INSERT INTO `db_boutique_mvc`.`producto` (`producto_id`,`producto_nombre`,`producto_descripcion`,`producto_estado`,`producto_precio`,`producto_imagen`,`marca_id`,`tipoproducto_id`) VALUES (6,'Corte a escote redondo asimétrico','La exquisita textura de su tejido se combina armoniosamente con su encantadora falda única. Estos detalles hacen que este diseño sea especialmente apreciado.',1,150.90,'https://i.postimg.cc/R0W5gxHh/6.jpg',7,3);
INSERT INTO `db_boutique_mvc`.`producto` (`producto_id`,`producto_nombre`,`producto_descripcion`,`producto_estado`,`producto_precio`,`producto_imagen`,`marca_id`,`tipoproducto_id`) VALUES (7,'Corte a escote en v','La exquisita textura de su tejido se combina armoniosamente con su encantadora falda única. Estos detalles hacen que este diseño sea especialmente apreciado.',1,270.90,'https://i.postimg.cc/VvcxsSH0/7.jpg',7,3);
INSERT INTO `db_boutique_mvc`.`producto` (`producto_id`,`producto_nombre`,`producto_descripcion`,`producto_estado`,`producto_precio`,`producto_imagen`,`marca_id`,`tipoproducto_id`) VALUES (8,'Vestido largo de apliques champagne','La exquisita textura de su tejido se combina armoniosamente con su encantadora falda única. Estos detalles hacen que este diseño sea especialmente apreciado.',1,159.90,'https://i.postimg.cc/hvbHXSHy/8.jpg',4,4);
INSERT INTO `db_boutique_mvc`.`producto` (`producto_id`,`producto_nombre`,`producto_descripcion`,`producto_estado`,`producto_precio`,`producto_imagen`,`marca_id`,`tipoproducto_id`) VALUES (9,'Vestido largo de apliques vino','La exquisita textura de su tejido se combina armoniosamente con su encantadora falda única. Estos detalles hacen que este diseño sea especialmente apreciado.',1,169.90,'https://i.postimg.cc/bwCf0wd4/9.jpg',3,4);
INSERT INTO `db_boutique_mvc`.`producto` (`producto_id`,`producto_nombre`,`producto_descripcion`,`producto_estado`,`producto_precio`,`producto_imagen`,`marca_id`,`tipoproducto_id`) VALUES (10,'Cuello redondo sin mangas asimétrico','La exquisita textura de su tejido se combina armoniosamente con su encantadora falda única. Estos detalles hacen que este diseño sea especialmente apreciado.',1,89.90,'https://i.postimg.cc/HszqHk0j/10.jpg',7,5);


-- INGRESO
INSERT INTO `db_boutique_mvc`.`ingreso` (`ingreso_id`, `ingreso_cantidad`, `ingreso_fecha`, `ingreso_proveedor`, `ingreso_descripcion`, `producto_id`) VALUES ('1', '3500', '2018-09-25', 'CLOTHING S.A.C.', 'Ingreso de nuevo stock para el producto.', '1');
INSERT INTO `db_boutique_mvc`.`ingreso` (`ingreso_id`, `ingreso_cantidad`, `ingreso_fecha`, `ingreso_proveedor`, `ingreso_descripcion`, `producto_id`) VALUES ('2', '7000', '2018-09-30', 'GOLDEN SUMMER E.I.R.L.', 'Ingreso de nuevo stock para el producto.', '1');
INSERT INTO `db_boutique_mvc`.`ingreso` (`ingreso_id`, `ingreso_cantidad`, `ingreso_fecha`, `ingreso_proveedor`, `ingreso_descripcion`, `producto_id`) VALUES ('3', '6500', '2018-12-05', 'SUN COLOR E.I.R.L.', 'Ingreso de nuevo stock para el producto.', '2');
INSERT INTO `db_boutique_mvc`.`ingreso` (`ingreso_id`, `ingreso_cantidad`, `ingreso_fecha`, `ingreso_proveedor`, `ingreso_descripcion`, `producto_id`) VALUES ('4', '4000', '2019-03-15', 'DRESSES S.A.C.', 'Ingreso de nuevo stock para el producto.', '2');
INSERT INTO `db_boutique_mvc`.`ingreso` (`ingreso_id`, `ingreso_cantidad`, `ingreso_fecha`, `ingreso_proveedor`, `ingreso_descripcion`, `producto_id`) VALUES ('5', '3800', '2019-05-03', 'CLOTHING S.A.C.', 'Ingreso de nuevo stock para el producto.', '3');
INSERT INTO `db_boutique_mvc`.`ingreso` (`ingreso_id`, `ingreso_cantidad`, `ingreso_fecha`, `ingreso_proveedor`, `ingreso_descripcion`, `producto_id`) VALUES ('6', '4500', '2019-08-01', 'SUN COLOR E.I.R.L.', 'Ingreso de nuevo stock para el producto.', '3');
INSERT INTO `db_boutique_mvc`.`ingreso` (`ingreso_id`, `ingreso_cantidad`, `ingreso_fecha`, `ingreso_proveedor`, `ingreso_descripcion`, `producto_id`) VALUES ('7', '8050', '2019-12-20', 'GOLDEN SUMMER E.I.R.L.', 'Ingreso de nuevo stock para el producto.', '3');
INSERT INTO `db_boutique_mvc`.`ingreso` (`ingreso_id`, `ingreso_cantidad`, `ingreso_fecha`, `ingreso_proveedor`, `ingreso_descripcion`, `producto_id`) VALUES ('8', '3040', '2020-01-01', 'CLOTHING S.A.C.', 'Ingreso de nuevo stock para el producto.', '4');
INSERT INTO `db_boutique_mvc`.`ingreso` (`ingreso_id`, `ingreso_cantidad`, `ingreso_fecha`, `ingreso_proveedor`, `ingreso_descripcion`, `producto_id`) VALUES ('9', '1470', '2020-06-30', 'DRESSES S.A.C.', 'Ingreso de nuevo stock para el producto.', '5');
INSERT INTO `db_boutique_mvc`.`ingreso` (`ingreso_id`, `ingreso_cantidad`, `ingreso_fecha`, `ingreso_proveedor`, `ingreso_descripcion`, `producto_id`) VALUES ('10', '3500', '2020-09-13', 'DRESSES S.A.C.', 'Ingreso de nuevo stock para el producto.', '6');
INSERT INTO `db_boutique_mvc`.`ingreso` (`ingreso_id`, `ingreso_cantidad`, `ingreso_fecha`, `ingreso_proveedor`, `ingreso_descripcion`, `producto_id`) VALUES ('11', '6500', '2021-03-12', 'CLOTHING S.A.C.', 'Ingreso de nuevo stock para el producto.', '7');
INSERT INTO `db_boutique_mvc`.`ingreso` (`ingreso_id`, `ingreso_cantidad`, `ingreso_fecha`, `ingreso_proveedor`, `ingreso_descripcion`, `producto_id`) VALUES ('12', '7800', '2021-05-15', 'ELEGANT LADY E.I.R.L.', 'Ingreso de nuevo stock para el producto.', '8');
INSERT INTO `db_boutique_mvc`.`ingreso` (`ingreso_id`, `ingreso_cantidad`, `ingreso_fecha`, `ingreso_proveedor`, `ingreso_descripcion`, `producto_id`) VALUES ('13', '9000', '2021-11-20', 'CLOTHING S.A.C.', 'Ingreso de nuevo stock para el producto.', '9');
INSERT INTO `db_boutique_mvc`.`ingreso` (`ingreso_id`, `ingreso_cantidad`, `ingreso_fecha`, `ingreso_proveedor`, `ingreso_descripcion`, `producto_id`) VALUES ('14', '1500', '2022-09-25', 'SUN COLOR E.I.R.L.', 'Ingreso de nuevo stock para el producto.', '10');
INSERT INTO `db_boutique_mvc`.`ingreso` (`ingreso_id`, `ingreso_cantidad`, `ingreso_fecha`, `ingreso_proveedor`, `ingreso_descripcion`, `producto_id`) VALUES ('15', '750', '2022-10-30', 'GOLDEN SUMMER E.I.R.L.', 'Ingreso de nuevo stock para el producto.', '10');


-- SALIDA
INSERT INTO `db_boutique_mvc`.`salida` (`salida_id`, `salida_cantidad`, `salida_fecha`, `salida_descripcion`, `producto_id`) VALUES ('1', '80', '2019-11-20', 'Salida de stock para el producto.', '1');
INSERT INTO `db_boutique_mvc`.`salida` (`salida_id`, `salida_cantidad`, `salida_fecha`, `salida_descripcion`, `producto_id`) VALUES ('2', '205', '2019-12-26', 'Salida de stock para el producto.', '1');
INSERT INTO `db_boutique_mvc`.`salida` (`salida_id`, `salida_cantidad`, `salida_fecha`, `salida_descripcion`, `producto_id`) VALUES ('3', '40', '2020-02-15', 'Salida de stock para el producto.', '2');
INSERT INTO `db_boutique_mvc`.`salida` (`salida_id`, `salida_cantidad`, `salida_fecha`, `salida_descripcion`, `producto_id`) VALUES ('4', '50', '2020-09-30', 'Salida de stock para el producto.', '3');
INSERT INTO `db_boutique_mvc`.`salida` (`salida_id`, `salida_cantidad`, `salida_fecha`, `salida_descripcion`, `producto_id`) VALUES ('5', '80', '2020-12-01', 'Salida de stock para el producto.', '4');
INSERT INTO `db_boutique_mvc`.`salida` (`salida_id`, `salida_cantidad`, `salida_fecha`, `salida_descripcion`, `producto_id`) VALUES ('6', '70', '2021-05-15', 'Salida de stock para el producto.', '5');
INSERT INTO `db_boutique_mvc`.`salida` (`salida_id`, `salida_cantidad`, `salida_fecha`, `salida_descripcion`, `producto_id`) VALUES ('7', '60', '2021-09-20', 'Salida de stock para el producto.', '6');
INSERT INTO `db_boutique_mvc`.`salida` (`salida_id`, `salida_cantidad`, `salida_fecha`, `salida_descripcion`, `producto_id`) VALUES ('8', '100', '2021-10-30', 'Salida de stock para el producto.', '7');
INSERT INTO `db_boutique_mvc`.`salida` (`salida_id`, `salida_cantidad`, `salida_fecha`, `salida_descripcion`, `producto_id`) VALUES ('9', '70', '2022-05-15', 'Salida de stock para el producto.', '8');
INSERT INTO `db_boutique_mvc`.`salida` (`salida_id`, `salida_cantidad`, `salida_fecha`, `salida_descripcion`, `producto_id`) VALUES ('10', '45', '2022-09-30', 'Salida de stock para el producto.', '9');
INSERT INTO `db_boutique_mvc`.`salida` (`salida_id`, `salida_cantidad`, `salida_fecha`, `salida_descripcion`, `producto_id`) VALUES ('11', '30', '2022-11-24', 'Salida de stock para el producto.', '10');

-- DESCUENTO
INSERT INTO `db_boutique_mvc`.`descuento` (`descuento_id`, `descuento_nombre`, `descuento_procentaje`, `descuento_disponible`) VALUES ('1', 'Ninguno', '0', '1');
INSERT INTO `db_boutique_mvc`.`descuento` (`descuento_id`, `descuento_nombre`, `descuento_procentaje`, `descuento_disponible`) VALUES ('2', 'SPRING DSCT 20%', '20', '1');
INSERT INTO `db_boutique_mvc`.`descuento` (`descuento_id`, `descuento_nombre`, `descuento_procentaje`, `descuento_disponible`) VALUES ('3', 'MONTH DSCT 30%', '30', '1');
INSERT INTO `db_boutique_mvc`.`descuento` (`descuento_id`, `descuento_nombre`, `descuento_procentaje`, `descuento_disponible`) VALUES ('4', 'LOCKER ROOM DSCT 50%', '50', '1');
INSERT INTO `db_boutique_mvc`.`descuento` (`descuento_id`, `descuento_nombre`, `descuento_procentaje`, `descuento_disponible`) VALUES ('5', 'SPECIAL DSCT 80%', '80', '1');


-- TIPOPAGO
INSERT INTO `db_boutique_mvc`.`tipopago` (`tipopago_id`, `tipopago_nombre`) VALUES ('1', 'Efectivo');
INSERT INTO `db_boutique_mvc`.`tipopago` (`tipopago_id`, `tipopago_nombre`) VALUES ('2', 'Tarjeta');


-- COMPROBANTE
INSERT INTO `db_boutique_mvc`.`comprobante` (`comprobante_id`, `comprobante_nombre`) VALUES ('1', 'Boleta');
/* INSERT INTO `db_boutique_mvc`.`comprobante` (`comprobante_id`, `comprobante_nombre`) VALUES ('2', 'Factura'); */

-- CLIENTE
INSERT INTO `db_boutique_mvc`.`cliente` (`cliente_id`,`cliente_nombre`,`cliente_apellido`,`cliente_dni`,`cliente_celular`,`cliente_estado`) VALUES (1,'Pool','Tirado Liyo','45725070','977988644',1);
INSERT INTO `db_boutique_mvc`.`cliente` (`cliente_id`,`cliente_nombre`,`cliente_apellido`,`cliente_dni`,`cliente_celular`,`cliente_estado`) VALUES (2,'Geraldine ','Cruz Dies','44992527','986353811',1);
INSERT INTO `db_boutique_mvc`.`cliente` (`cliente_id`,`cliente_nombre`,`cliente_apellido`,`cliente_dni`,`cliente_celular`,`cliente_estado`) VALUES (3,'Anibal ','Esteban Altamitre','45754026','957097876',1);
INSERT INTO `db_boutique_mvc`.`cliente` (`cliente_id`,`cliente_nombre`,`cliente_apellido`,`cliente_dni`,`cliente_celular`,`cliente_estado`) VALUES (4,'Rony ','Quispe Bilco','73106888','942136263',1);
INSERT INTO `db_boutique_mvc`.`cliente` (`cliente_id`,`cliente_nombre`,`cliente_apellido`,`cliente_dni`,`cliente_celular`,`cliente_estado`) VALUES (5,'Teodora ','Montalvin Vicente','46313711','978619147',1);
INSERT INTO `db_boutique_mvc`.`cliente` (`cliente_id`,`cliente_nombre`,`cliente_apellido`,`cliente_dni`,`cliente_celular`,`cliente_estado`) VALUES (6,'Jenny ','Aguirre Cubes','09985067','953470224',1);
INSERT INTO `db_boutique_mvc`.`cliente` (`cliente_id`,`cliente_nombre`,`cliente_apellido`,`cliente_dni`,`cliente_celular`,`cliente_estado`) VALUES (7,'Yeffry','Atenci Tantara','75963484','929422419',1);


-- VENTA
INSERT INTO `db_boutique_mvc`.`venta` (`venta_id`, `venta_fecha`, `venta_descripcion`, `venta_igv`, `venta_estado`, `tipopago_id`, `cliente_id`, `comprobante_id`) VALUES ('1', '2022-08-02', 'Descripción de la venta realizada.', '0.18', '1', '1', '1', '1');
INSERT INTO `db_boutique_mvc`.`venta` (`venta_id`, `venta_fecha`, `venta_descripcion`, `venta_igv`, `venta_estado`, `tipopago_id`, `cliente_id`, `comprobante_id`) VALUES ('2', '2022-08-02', 'Descripción de la venta realizada.', '0.18', '1', '1', '2', '1');
INSERT INTO `db_boutique_mvc`.`venta` (`venta_id`, `venta_fecha`, `venta_descripcion`, `venta_igv`, `venta_estado`, `tipopago_id`, `cliente_id`, `comprobante_id`) VALUES ('3', '2022-08-02', 'Descripción de la venta realizada.', '0.18', '1', '2', '3', '1');
INSERT INTO `db_boutique_mvc`.`venta` (`venta_id`, `venta_fecha`, `venta_descripcion`, `venta_igv`, `venta_estado`, `tipopago_id`, `cliente_id`, `comprobante_id`) VALUES ('4', '2022-08-02', 'Descripción de la venta realizada.', '0.18', '1', '2', '4', '1');
INSERT INTO `db_boutique_mvc`.`venta` (`venta_id`, `venta_fecha`, `venta_descripcion`, `venta_igv`, `venta_estado`, `tipopago_id`, `cliente_id`, `comprobante_id`) VALUES ('5', '2022-08-02', 'Descripción de la venta realizada.', '0.18', '1', '2', '5', '1');

-- DETALLEVENTA
INSERT INTO `db_boutique_mvc`.`detalleventa` (`detalleventa_id`, `detalleventa_cantidad`, `venta_id`, `producto_id`, `descuento_id`) VALUES ('1', '7', '1', '1', '1');
INSERT INTO `db_boutique_mvc`.`detalleventa` (`detalleventa_id`, `detalleventa_cantidad`, `venta_id`, `producto_id`, `descuento_id`) VALUES ('2', '8', '1', '2', '3');
INSERT INTO `db_boutique_mvc`.`detalleventa` (`detalleventa_id`, `detalleventa_cantidad`, `venta_id`, `producto_id`, `descuento_id`) VALUES ('3', '7', '1', '3', '2');
INSERT INTO `db_boutique_mvc`.`detalleventa` (`detalleventa_id`, `detalleventa_cantidad`, `venta_id`, `producto_id`, `descuento_id`) VALUES ('4', '5', '1', '4', '1');
INSERT INTO `db_boutique_mvc`.`detalleventa` (`detalleventa_id`, `detalleventa_cantidad`, `venta_id`, `producto_id`, `descuento_id`) VALUES ('5', '6', '1', '5', '3');
INSERT INTO `db_boutique_mvc`.`detalleventa` (`detalleventa_id`, `detalleventa_cantidad`, `venta_id`, `producto_id`, `descuento_id`) VALUES ('6', '8', '1', '6', '1');
INSERT INTO `db_boutique_mvc`.`detalleventa` (`detalleventa_id`, `detalleventa_cantidad`, `venta_id`, `producto_id`, `descuento_id`) VALUES ('7', '9', '2', '7', '1');
INSERT INTO `db_boutique_mvc`.`detalleventa` (`detalleventa_id`, `detalleventa_cantidad`, `venta_id`, `producto_id`, `descuento_id`) VALUES ('8', '10', '2', '8', '3');
INSERT INTO `db_boutique_mvc`.`detalleventa` (`detalleventa_id`, `detalleventa_cantidad`, `venta_id`, `producto_id`, `descuento_id`) VALUES ('9', '4', '2', '9', '1');
INSERT INTO `db_boutique_mvc`.`detalleventa` (`detalleventa_id`, `detalleventa_cantidad`, `venta_id`, `producto_id`, `descuento_id`) VALUES ('10', '5', '2', '5', '4');
INSERT INTO `db_boutique_mvc`.`detalleventa` (`detalleventa_id`, `detalleventa_cantidad`, `venta_id`, `producto_id`, `descuento_id`) VALUES ('11', '5', '2', '4', '1');
INSERT INTO `db_boutique_mvc`.`detalleventa` (`detalleventa_id`, `detalleventa_cantidad`, `venta_id`, `producto_id`, `descuento_id`) VALUES ('12', '9', '2', '6', '5');
INSERT INTO `db_boutique_mvc`.`detalleventa` (`detalleventa_id`, `detalleventa_cantidad`, `venta_id`, `producto_id`, `descuento_id`) VALUES ('13', '1', '3', '2', '1');
INSERT INTO `db_boutique_mvc`.`detalleventa` (`detalleventa_id`, `detalleventa_cantidad`, `venta_id`, `producto_id`, `descuento_id`) VALUES ('14', '2', '3', '1', '2');
INSERT INTO `db_boutique_mvc`.`detalleventa` (`detalleventa_id`, `detalleventa_cantidad`, `venta_id`, `producto_id`, `descuento_id`) VALUES ('15', '15', '3', '4', '1');
INSERT INTO `db_boutique_mvc`.`detalleventa` (`detalleventa_id`, `detalleventa_cantidad`, `venta_id`, `producto_id`, `descuento_id`) VALUES ('16', '7', '3', '5', '1');
INSERT INTO `db_boutique_mvc`.`detalleventa` (`detalleventa_id`, `detalleventa_cantidad`, `venta_id`, `producto_id`, `descuento_id`) VALUES ('17', '5', '3', '7', '5');
INSERT INTO `db_boutique_mvc`.`detalleventa` (`detalleventa_id`, `detalleventa_cantidad`, `venta_id`, `producto_id`, `descuento_id`) VALUES ('18', '4', '4', '10', '1');
INSERT INTO `db_boutique_mvc`.`detalleventa` (`detalleventa_id`, `detalleventa_cantidad`, `venta_id`, `producto_id`, `descuento_id`) VALUES ('19', '12', '4', '8', '1');
INSERT INTO `db_boutique_mvc`.`detalleventa` (`detalleventa_id`, `detalleventa_cantidad`, `venta_id`, `producto_id`, `descuento_id`) VALUES ('20', '10', '4', '7', '2');
INSERT INTO `db_boutique_mvc`.`detalleventa` (`detalleventa_id`, `detalleventa_cantidad`, `venta_id`, `producto_id`, `descuento_id`) VALUES ('21', '8', '5', '2', '1');
INSERT INTO `db_boutique_mvc`.`detalleventa` (`detalleventa_id`, `detalleventa_cantidad`, `venta_id`, `producto_id`, `descuento_id`) VALUES ('22', '6', '5', '3', '3');
INSERT INTO `db_boutique_mvc`.`detalleventa` (`detalleventa_id`, `detalleventa_cantidad`, `venta_id`, `producto_id`, `descuento_id`) VALUES ('23', '9', '5', '4', '1');
INSERT INTO `db_boutique_mvc`.`detalleventa` (`detalleventa_id`, `detalleventa_cantidad`, `venta_id`, `producto_id`, `descuento_id`) VALUES ('24', '5', '5', '8', '2');
INSERT INTO `db_boutique_mvc`.`detalleventa` (`detalleventa_id`, `detalleventa_cantidad`, `venta_id`, `producto_id`, `descuento_id`) VALUES ('25', '12', '5', '6', '1');


--  ESTADOLABORAL
INSERT INTO `db_boutique_mvc`.`estadolaboral` (`estadolaboral_id`, `estadolaboral_nombre`) VALUES ('1', 'Asistencia');
INSERT INTO `db_boutique_mvc`.`estadolaboral` (`estadolaboral_id`, `estadolaboral_nombre`) VALUES ('2', 'Descanso');
INSERT INTO `db_boutique_mvc`.`estadolaboral` (`estadolaboral_id`, `estadolaboral_nombre`) VALUES ('3', 'Descanso Médico');
INSERT INTO `db_boutique_mvc`.`estadolaboral` (`estadolaboral_id`, `estadolaboral_nombre`) VALUES ('4', 'Tardanza');

-- HORARIOS
INSERT INTO `db_boutique_mvc`.`horario` (`horario_id`, `horario_fecha`, `horario_hora_inicio`, `horario_hora_fin`, `horario_detalle`, `estadolaboral_id`, `userid`) VALUES ('1', '2022-07-29', '8:00:00', '17:00:00', 'OK', '1', '1');
INSERT INTO `db_boutique_mvc`.`horario` (`horario_id`, `horario_fecha`, `horario_hora_inicio`, `horario_hora_fin`, `horario_detalle`, `estadolaboral_id`, `userid`) VALUES ('2', '2022-07-30', '8:00:00', '17:00:00', 'OK', '1', '1');
INSERT INTO `db_boutique_mvc`.`horario` (`horario_id`, `horario_fecha`, `horario_hora_inicio`, `horario_hora_fin`, `horario_detalle`, `estadolaboral_id`, `userid`) VALUES ('3', '2022-08-01', '8:00:00', '17:00:00', 'OK', '2', '1');
INSERT INTO `db_boutique_mvc`.`horario` (`horario_id`, `horario_fecha`, `horario_hora_inicio`, `horario_hora_fin`, `horario_detalle`, `estadolaboral_id`, `userid`) VALUES ('4', '2022-08-02', '8:00:00', '17:00:00', 'OK', '1', '1');
INSERT INTO `db_boutique_mvc`.`horario` (`horario_id`, `horario_fecha`, `horario_hora_inicio`, `horario_hora_fin`, `horario_detalle`, `estadolaboral_id`, `userid`) VALUES ('5', '2022-08-03', '8:00:00', '17:00:00', 'OK', '2', '1');
INSERT INTO `db_boutique_mvc`.`horario` (`horario_id`, `horario_fecha`, `horario_hora_inicio`, `horario_hora_fin`, `horario_detalle`, `estadolaboral_id`, `userid`) VALUES ('6', '2022-08-04', '8:00:00', '17:00:00', 'OK', '1', '1');

