-- CONSULTA STOCK GENERAL
DELIMITER $$
CREATE PROCEDURE `db_boutique_mvc`.`sp_consulta_stock`()
BEGIN

    SELECT P.producto_id as stock_id, P.producto_nombre as stock_nombre,P.producto_imagen as stock_imagen,

        -- INGRESO
        IF(P.producto_id IN (SELECT producto_id FROM ingreso),(SELECT SUM(ingreso_cantidad) FROM ingreso I WHERE I.producto_id = P.producto_id),0) stock_ingreso,

        -- SALIDA
        IF(P.producto_id IN (SELECT producto_id FROM salida), (SELECT SUM(salida_cantidad) FROM salida S WHERE S.producto_id = P.producto_id),0) stock_salida,

        -- EN USO
        IF(P.producto_id IN (SELECT producto_id FROM detalleventa), (SELECT SUM(detalleventa_cantidad) FROM detalleventa D WHERE D.producto_id = P.producto_id),0) stock_usado,

        -- TOTAL
        (
        (IF(P.producto_id IN (SELECT producto_id FROM ingreso),(SELECT SUM(ingreso_cantidad) FROM ingreso I WHERE I.producto_id = P.producto_id),0))
        -
        IF(P.producto_id IN (SELECT producto_id FROM salida), (SELECT SUM(salida_cantidad) FROM salida S WHERE S.producto_id = P.producto_id),0)
        -
        IF(P.producto_id IN (SELECT producto_id FROM detalleventa), (SELECT SUM(detalleventa_cantidad) FROM detalleventa D WHERE D.producto_id = P.producto_id),0) 
        ) stock_total

    FROM producto P

    ORDER BY P.producto_id DESC;
    
END$$

-- CONSULTA STOCK ID PRODUCTO
DELIMITER $$
CREATE PROCEDURE `db_boutique_mvc`.`sp_consulta_stock_producto_id`(IN var_id_producto INT)
BEGIN

    SELECT 
        P.producto_id as stock_id, 
        P.producto_nombre as stock_nombre, 
        M.marca_nombre as stock_marca,
        P.producto_imagen as stock_imagen,
        T.tipoproducto_nombre as stock_tipo_producto,
        P.producto_precio as stock_precio,

        -- INGRESO
        IF(P.producto_id IN (SELECT producto_id FROM ingreso),(SELECT SUM(ingreso_cantidad) FROM ingreso I WHERE I.producto_id = P.producto_id),0) stock_ingreso,

        -- SALIDA
        IF(P.producto_id IN (SELECT producto_id FROM salida), (SELECT SUM(salida_cantidad) FROM salida S WHERE S.producto_id = P.producto_id),0) stock_salida,

        -- EN USO
        IF(P.producto_id IN (SELECT producto_id FROM detalleventa), (SELECT SUM(detalleventa_cantidad) FROM detalleventa D WHERE D.producto_id = P.producto_id),0) stock_usado,

        -- TOTAL
        (
        (IF(P.producto_id IN (SELECT producto_id FROM ingreso),(SELECT SUM(ingreso_cantidad) FROM ingreso I WHERE I.producto_id = P.producto_id),0))
        -
        IF(P.producto_id IN (SELECT producto_id FROM salida), (SELECT SUM(salida_cantidad) FROM salida S WHERE S.producto_id = P.producto_id),0)
        -
        IF(P.producto_id IN (SELECT producto_id FROM detalleventa), (SELECT SUM(detalleventa_cantidad) FROM detalleventa D WHERE D.producto_id = P.producto_id),0) 
        ) stock_total

    FROM producto P 
        INNER JOIN marca M ON M.marca_id = P.marca_id
        INNER JOIN tipoproducto T ON T.tipoproducto_id = P.tipoproducto_id

    WHERE P.producto_id=var_id_producto;
    
END$$





-- CONSULTA REPORTE DE VENTA DE PRODUCTOS
DELIMITER $$
CREATE PROCEDURE `db_boutique_mvc`.`sp_reporte_venta_prod_fechas`(IN var_id_producto INT, IN var_fecha_inicio DATE, IN var_fecha_fin DATE)
BEGIN

    SELECT 
        dt.detalleventa_id as reporte_detalleventa_id,

        pr.producto_nombre,
        ma.marca_nombre,
        ti.tipoproducto_nombre,

        cl.cliente_nombre,
        cl.cliente_apellido,
        cl.cliente_dni,

        ve.venta_igv,
        pr.producto_precio,
        ds.descuento_procentaje,
        dt.detalleventa_cantidad,

        ve.venta_fecha,
        pr.producto_imagen,

		DATE_FORMAT(var_fecha_inicio,"%Y-%m-%d") AS var_fecha_inicio,
		DATE_FORMAT(var_fecha_fin,"%Y-%m-%d") AS var_fecha_fin
        

    FROM 
        detalleventa dt

        INNER JOIN venta ve ON ve.venta_id=dt.venta_id
        INNER JOIN producto pr ON pr.producto_id=dt.producto_id
        INNER JOIN marca ma ON ma.marca_id=pr.marca_id
        INNER JOIN tipoproducto ti ON ti.tipoproducto_id=pr.tipoproducto_id
        INNER JOIN descuento ds ON ds.descuento_id=dt.descuento_id
        INNER JOIN cliente cl ON cl.cliente_id=ve.cliente_id

    WHERE dt.producto_id=var_id_producto

        AND ve.venta_fecha BETWEEN var_fecha_inicio AND var_fecha_fin
    ORDER BY dt.detalleventa_id DESC;

END$$



-- CONSULTA HORARIOS
DELIMITER $$
CREATE PROCEDURE `db_boutique_mvc`.`sp_consulta_horarios`()
BEGIN

    SELECT 

        -- TABLA
        hr.horario_id,
        hr.horario_fecha,
        hr.horario_hora_inicio,
        hr.horario_hora_fin,
        hr.horario_detalle,
        hr.estadolaboral_id,
        hr.userid,

        -- CALCULO
        SEC_TO_TIME((TIMESTAMPDIFF(MINUTE , horario_hora_inicio , horario_hora_fin))*60) AS diferencia,

        -- TEXTOS
        us.name,
        us.lastname,
        et.estadolaboral_nombre

    FROM horario hr
        INNER JOIN users us ON us.userid=hr.userid
        INNER JOIN estadolaboral et ON et.estadolaboral_id=hr.estadolaboral_id

    ORDER BY hr.horario_fecha DESC;

END$$
